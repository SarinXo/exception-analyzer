package sarinxo.service.exceptionanalyzer.security.mapper;

import org.mapstruct.Mapper;
import sarinxo.service.exceptionanalyzer.security.dto.CreateUserResponse;
import sarinxo.service.exceptionanalyzer.security.entity.AppUser;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface AppUserMapper {
    CreateUserResponse entityToCreateResponse(AppUser user);
}
