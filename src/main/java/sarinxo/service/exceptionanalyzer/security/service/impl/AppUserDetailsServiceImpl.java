package sarinxo.service.exceptionanalyzer.security.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import sarinxo.service.exceptionanalyzer.security.dto.AssignRolesRequest;
import sarinxo.service.exceptionanalyzer.security.dto.CreateUserRequest;
import sarinxo.service.exceptionanalyzer.security.dto.CreateUserResponse;
import sarinxo.service.exceptionanalyzer.security.entity.AppRole;
import sarinxo.service.exceptionanalyzer.security.entity.AppUser;
import sarinxo.service.exceptionanalyzer.security.mapper.AppUserMapper;
import sarinxo.service.exceptionanalyzer.security.repository.AppUserRepository;
import sarinxo.service.exceptionanalyzer.security.service.AppRoleService;
import sarinxo.service.exceptionanalyzer.security.service.AppUserService;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class AppUserDetailsServiceImpl implements AppUserService {

    private final AppUserRepository userRepository;
    private final AppRoleService roleService;
    private final AppUserMapper mapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository
                .findUserByUsername(username)
                .orElseThrow(
                        () -> new UsernameNotFoundException("User with username = " + username + " doesn't found")
                );
    }

    @Override
    public CreateUserResponse create(CreateUserRequest request) {
        if (userRepository.existsByUsername(request.getUsername())) {
            throw new IllegalArgumentException("Can't create user " + request.getUsername() + " because they already exist!");
        }

        String password = passwordEncoder.encode(request.getPassword());

        AppUser newUser = AppUser.builder()
                .username(request.getUsername())
                .password(password)
                .build();

        AppUser savedUser = userRepository.save(newUser);

        return mapper.entityToCreateResponse(savedUser);
    }

    @Override
    public Boolean isExist(String username) {
        return userRepository.existsByUsername(username);
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public void assignRoles(AssignRolesRequest request) {
        AppUser appUser = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new NoSuchElementException("User doesn't exist in database"));

        List<AppRole> roles = roleService.findByIds(request.getRoles());

        List<AppRole> finalRoles = Stream.of(appUser.getAuthorities(), roles)
                .flatMap(List::stream)
                .distinct()
                .collect(Collectors.toList());

        appUser.setAuthorities(finalRoles);
        userRepository.save(appUser);
    }
}
