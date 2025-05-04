package sarinxo.service.exceptionanalyzer.security.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sarinxo.service.exceptionanalyzer.security.dto.CreateRoleResponse;
import sarinxo.service.exceptionanalyzer.security.entity.AppRole;
import sarinxo.service.exceptionanalyzer.security.mapper.AppRoleMapper;
import sarinxo.service.exceptionanalyzer.security.repository.AppRoleRepository;
import sarinxo.service.exceptionanalyzer.security.service.AppRoleService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AppRoleServiceImpl implements AppRoleService {

    private final AppRoleRepository repository;
    private final AppRoleMapper mapper;

    @Override
    public CreateRoleResponse create(String roleName) {
        AppRole role = AppRole.builder().authority(roleName).build();

        AppRole savedRole = repository.save(role);

        return mapper.entityToCreateResponse(savedRole);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<AppRole> findByIds(List<Long> ids) {
        return repository.findAllById(ids);
    }
}
