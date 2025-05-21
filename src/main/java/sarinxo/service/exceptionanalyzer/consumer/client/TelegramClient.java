package sarinxo.service.exceptionanalyzer.consumer.client;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestClient;
import sarinxo.service.exceptionanalyzer.consumer.dto.MessageDto;

@Component
public class TelegramClient {
    private final RestClient restClient = RestClient.builder().baseUrl("http://localhost:8083").build();

    @PostMapping("/telegram/send-message")
    public void sendMessageInBot(MessageDto dto) {
        restClient.post().uri("/telegram/send-message").body(dto).retrieve().toBodilessEntity();
    }

}
