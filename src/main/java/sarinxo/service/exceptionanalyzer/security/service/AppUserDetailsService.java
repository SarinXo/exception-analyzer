package sarinxo.service.exceptionanalyzer.security.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import sarinxo.service.exceptionanalyzer.security.repository.AppUserRepository;

@Service
@RequiredArgsConstructor
public class AppUserDetailsService implements UserDetailsService {

    private final AppUserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository
                .findUserByUsername(username)
                .orElseThrow(
                        () -> new UsernameNotFoundException("User with username = " + username + " doesn't found")
                );
    }
}
