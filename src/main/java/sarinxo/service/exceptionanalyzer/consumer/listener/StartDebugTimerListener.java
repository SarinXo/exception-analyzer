package sarinxo.service.exceptionanalyzer.consumer.listener;

import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import sarinxo.service.exceptionanalyzer.consumer.entity.ExceptionWaitingTime;
import sarinxo.service.exceptionanalyzer.consumer.kafka.ServiceExceptionEvent;
import sarinxo.service.exceptionanalyzer.consumer.repository.ExceptionWaitingTimeRepository;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class StartDebugTimerListener implements ApplicationListener<ServiceExceptionEvent> {

    private final ExceptionWaitingTimeRepository repository;

    @Override
    public void onApplicationEvent(ServiceExceptionEvent event) {
        ExceptionWaitingTime entity = ExceptionWaitingTime.builder()
                .exceptionHappensTime(LocalDateTime.now())
                .build();

        repository.save(entity);
    }

}
