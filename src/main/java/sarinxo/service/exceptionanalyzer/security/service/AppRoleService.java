package sarinxo.service.exceptionanalyzer.security.service;

import sarinxo.service.exceptionanalyzer.security.dto.CreateRoleRequest;
import sarinxo.service.exceptionanalyzer.security.dto.CreateRoleResponse;
import sarinxo.service.exceptionanalyzer.security.entity.AppRole;

import java.util.List;

public interface AppRoleService {
    CreateRoleResponse create(CreateRoleRequest request);

    List<AppRole> findByIds(List<Long> ids);

    void delete(Long id);
}
