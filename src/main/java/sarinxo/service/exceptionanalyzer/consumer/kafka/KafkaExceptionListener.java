package sarinxo.service.exceptionanalyzer.consumer.kafka;

import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import sarinxo.service.exceptionanalyzer.consumer.dto.ExceptionDto;

@Component
@RequiredArgsConstructor
public class KafkaExceptionListener {

    private final ApplicationEventPublisher eventPublisher;

    @KafkaListener(topics = "exceptions", groupId = "exception-events")
    public void handleExceptionEvent(ExceptionDto dto) {
        ServiceExceptionEvent event = new ServiceExceptionEvent(this, dto);
        eventPublisher.publishEvent(event);
    }

}
