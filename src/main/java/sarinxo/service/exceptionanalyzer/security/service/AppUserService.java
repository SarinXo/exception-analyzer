package sarinxo.service.exceptionanalyzer.security.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import sarinxo.service.exceptionanalyzer.security.dto.CreateUserRequest;
import sarinxo.service.exceptionanalyzer.security.dto.CreateUserResponse;

public interface AppUserService extends UserDetailsService {

    CreateUserResponse create(CreateUserRequest request);

    Boolean isExist(String username);

    void delete(Long id);
}
