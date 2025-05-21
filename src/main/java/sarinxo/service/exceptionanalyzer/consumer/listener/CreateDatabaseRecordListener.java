package sarinxo.service.exceptionanalyzer.consumer.listener;

import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import sarinxo.service.exceptionanalyzer.consumer.entity.ExceptionInfo;
import sarinxo.service.exceptionanalyzer.consumer.entity.enumerated.ExceptionStatus;
import sarinxo.service.exceptionanalyzer.consumer.kafka.ServiceExceptionEvent;
import sarinxo.service.exceptionanalyzer.consumer.mapper.ExceptionInfoMapper;
import sarinxo.service.exceptionanalyzer.consumer.repository.ExceptionInfoRepository;

@Component
@RequiredArgsConstructor
public class CreateDatabaseRecordListener implements ApplicationListener<ServiceExceptionEvent> {

    private final ExceptionInfoRepository repository;
    private final ExceptionInfoMapper mapper;

    @Override
    public void onApplicationEvent(ServiceExceptionEvent event) {
        ExceptionInfo entity = mapper.dtoToEntity(event.getMessage());
        entity.setStatus(ExceptionStatus.EMERGENCE);

        repository.save(entity);
    }

}
