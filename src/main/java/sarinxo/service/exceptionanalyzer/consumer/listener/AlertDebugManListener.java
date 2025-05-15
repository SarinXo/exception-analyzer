package sarinxo.service.exceptionanalyzer.consumer.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import sarinxo.service.exceptionanalyzer.consumer.kafka.ServiceExceptionEvent;

@Component
public class AlertDebugManListener implements ApplicationListener<ServiceExceptionEvent> {

    @Override
    public void onApplicationEvent(ServiceExceptionEvent event) {

    }

}
