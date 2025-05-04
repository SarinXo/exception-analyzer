package sarinxo.service.exceptionanalyzer.security.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import sarinxo.service.exceptionanalyzer.security.dto.AssignRolesRequest;
import sarinxo.service.exceptionanalyzer.security.dto.CreateUserRequest;
import sarinxo.service.exceptionanalyzer.security.dto.CreateUserResponse;

import java.util.List;

public interface AppUserService extends UserDetailsService {

    CreateUserResponse create(CreateUserRequest request);

    Boolean isExist(String username);

    void delete(Long id);

    void assignRoles(AssignRolesRequest request);
}
