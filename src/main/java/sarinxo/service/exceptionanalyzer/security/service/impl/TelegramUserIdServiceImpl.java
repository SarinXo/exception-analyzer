package sarinxo.service.exceptionanalyzer.security.service.impl;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sarinxo.service.exceptionanalyzer.security.dto.TelegramUserIdRequest;
import sarinxo.service.exceptionanalyzer.security.entity.TelegramUserId;
import sarinxo.service.exceptionanalyzer.security.mapper.TelegramUserIdMapper;
import sarinxo.service.exceptionanalyzer.security.repository.TelegramUserIdRepository;
import sarinxo.service.exceptionanalyzer.security.service.TelegramUserIdService;

import java.util.NoSuchElementException;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TelegramUserIdServiceImpl implements TelegramUserIdService {

    private final TelegramUserIdRepository repository;
    private final TelegramUserIdMapper mapper;

    @Override
    public TelegramUserId create(TelegramUserIdRequest request) {
        TelegramUserId telegramUserId = mapper.dtoToEntity(request);

        return repository.save(telegramUserId);
    }

    @Override
    @NotNull
    public TelegramUserId findByCode(UUID code) {
        return repository
                .findById(code)
                .orElseThrow(() -> new NoSuchElementException("Not found or already expired"));
    }

    @Override
    public void delete(UUID code) {
        repository.deleteById(code);
    }

}
