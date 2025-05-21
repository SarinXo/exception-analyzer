package sarinxo.service.exceptionanalyzer.security.service;

import jakarta.validation.constraints.NotNull;
import sarinxo.service.exceptionanalyzer.security.dto.TelegramUserIdRequest;
import sarinxo.service.exceptionanalyzer.security.entity.TelegramUserId;

import java.util.UUID;

public interface TelegramUserIdService {
    TelegramUserId create(TelegramUserIdRequest request);

    @NotNull TelegramUserId findByCode(UUID code);

    void delete(UUID code);
}
