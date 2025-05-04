package sarinxo.service.exceptionanalyzer.security.service;

import sarinxo.service.exceptionanalyzer.security.dto.CreateRoleResponse;

public interface AppRoleService {
    CreateRoleResponse create(String roleName);

    void delete(Long id);
}
