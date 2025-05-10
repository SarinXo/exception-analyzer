package sarinxo.service.exceptionanalyzer.security.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import sarinxo.service.exceptionanalyzer.security.dto.CreateRoleResponse;
import sarinxo.service.exceptionanalyzer.security.entity.AppRole;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface AppRoleMapper {

    @Mapping(source = "authority", target = "role")
    CreateRoleResponse entityToCreateResponse(AppRole role);
}
