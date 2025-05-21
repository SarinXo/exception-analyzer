package sarinxo.service.exceptionanalyzer.consumer.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import sarinxo.service.exceptionanalyzer.consumer.dto.ExceptionDto;
import sarinxo.service.exceptionanalyzer.consumer.entity.ExceptionInfo;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ExceptionInfoMapper {

    ExceptionInfo dtoToEntity(ExceptionDto dto);

}
