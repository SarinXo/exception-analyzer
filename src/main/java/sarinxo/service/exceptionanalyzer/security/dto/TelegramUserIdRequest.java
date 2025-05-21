package sarinxo.service.exceptionanalyzer.security.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class TelegramUserIdRequest {
    private UUID code;
    private Long telegramUserId;
}
