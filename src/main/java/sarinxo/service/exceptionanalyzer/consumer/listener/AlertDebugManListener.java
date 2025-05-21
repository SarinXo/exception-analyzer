package sarinxo.service.exceptionanalyzer.consumer.listener;

import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.util.Strings;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import sarinxo.service.exceptionanalyzer.consumer.client.TelegramClient;
import sarinxo.service.exceptionanalyzer.consumer.controller.TelegramController;
import sarinxo.service.exceptionanalyzer.consumer.dto.MessageDto;
import sarinxo.service.exceptionanalyzer.consumer.entity.OnDuty;
import sarinxo.service.exceptionanalyzer.consumer.kafka.ServiceExceptionEvent;
import sarinxo.service.exceptionanalyzer.consumer.repository.OnDutyRepository;

import java.util.List;
import java.util.Objects;

@Component
@RequiredArgsConstructor
public class AlertDebugManListener implements ApplicationListener<ServiceExceptionEvent> {

    private final OnDutyRepository repository;
    private final TelegramClient client;

    @Override
    public void onApplicationEvent(ServiceExceptionEvent event) {
        String errorMessage = "В сервисе " + event.getMessage().getAppName() +
                " id " + event.getMessage().getAppId() +
                " возникла ошибка c сообщением" + event.getMessage().getMessage() +
                " зайдите в приложение для дополнительной информации!";

        repository.findAllFetch()
                .stream()
                .filter(it -> !Objects.isNull(it.getOnDuty().getTelegramId()))
                .forEach(it -> {
                    MessageDto dto = new MessageDto(
                            it.getOnDuty().getTelegramId(),
                            errorMessage
                    );

                    client.sendMessageInBot(dto);
                });
    }

}
