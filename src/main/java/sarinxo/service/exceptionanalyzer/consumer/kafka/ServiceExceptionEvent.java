package sarinxo.service.exceptionanalyzer.consumer.kafka;

import org.springframework.context.ApplicationEvent;
import sarinxo.service.exceptionanalyzer.consumer.dto.ExceptionDto;

public class ServiceExceptionEvent extends ApplicationEvent {
    private ExceptionDto dto;

    public ServiceExceptionEvent(Object source, ExceptionDto dto) {
        super(source);
        this.dto = dto;
    }
    public ExceptionDto getMessage() {
        return dto;
    }
}
