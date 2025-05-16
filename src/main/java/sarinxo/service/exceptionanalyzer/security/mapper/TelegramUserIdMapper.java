package sarinxo.service.exceptionanalyzer.security.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import sarinxo.service.exceptionanalyzer.security.dto.TelegramUserIdRequest;
import sarinxo.service.exceptionanalyzer.security.entity.TelegramUserId;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface TelegramUserIdMapper {

    TelegramUserId dtoToEntity(TelegramUserIdRequest dto);
}
