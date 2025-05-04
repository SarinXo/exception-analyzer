package sarinxo.service.exceptionanalyzer.security.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import sarinxo.service.exceptionanalyzer.security.dto.CreateUserRequest;
import sarinxo.service.exceptionanalyzer.security.dto.CreateUserResponse;
import sarinxo.service.exceptionanalyzer.security.entity.AppUser;
import sarinxo.service.exceptionanalyzer.security.mapper.AppUserMapper;
import sarinxo.service.exceptionanalyzer.security.repository.AppUserRepository;
import sarinxo.service.exceptionanalyzer.security.service.AppUserService;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AppUserDetailsServiceImpl implements AppUserService {

    private final AppUserRepository repository;
    private final AppUserMapper mapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository
                .findUserByUsername(username)
                .orElseThrow(
                        () -> new UsernameNotFoundException("User with username = " + username + " doesn't found")
                );
    }

    @Override
    public CreateUserResponse create(CreateUserRequest request) {
        if (repository.existsByUsername(request.getUsername())) {
            throw new IllegalArgumentException("Can't create user " + request.getUsername() + " because they already exist!");
        }

        AppUser newUser = AppUser.builder()
                .username(request.getUsername())
                .password(request.getPassword())
                .build();

        AppUser savedUser = repository.save(newUser);

        return mapper.entityToCreateResponse(savedUser);
    }

    @Override
    public Boolean isExist(String username) {
        return repository.existsByUsername(username);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
