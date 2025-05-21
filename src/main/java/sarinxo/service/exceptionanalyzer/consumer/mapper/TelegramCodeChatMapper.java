package sarinxo.service.exceptionanalyzer.consumer.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import sarinxo.service.exceptionanalyzer.consumer.dto.RegisterDto;
import sarinxo.service.exceptionanalyzer.consumer.entity.TelegramCodeChat;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface TelegramCodeChatMapper {

    TelegramCodeChat toEntity(RegisterDto dto);
}
