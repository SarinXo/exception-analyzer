package sarinxo.service.exceptionanalyzer.consumer.listener;

import org.springframework.context.ApplicationListener;
import sarinxo.service.exceptionanalyzer.consumer.kafka.ServiceExceptionEvent;

public class CreateDatabaseRecordListener implements ApplicationListener<ServiceExceptionEvent> {

    @Override
    public void onApplicationEvent(ServiceExceptionEvent event) {

    }

}
