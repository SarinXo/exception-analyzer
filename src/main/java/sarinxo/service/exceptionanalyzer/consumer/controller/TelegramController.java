package sarinxo.service.exceptionanalyzer.consumer.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sarinxo.service.exceptionanalyzer.consumer.dto.RegisterDto;
import sarinxo.service.exceptionanalyzer.consumer.entity.TelegramCodeChat;
import sarinxo.service.exceptionanalyzer.consumer.mapper.TelegramCodeChatMapper;
import sarinxo.service.exceptionanalyzer.consumer.repository.TelegramCodeChatRepository;
import sarinxo.service.exceptionanalyzer.security.entity.AppUser;
import sarinxo.service.exceptionanalyzer.security.service.AppUserService;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/telegram")
@RequiredArgsConstructor
public class TelegramController {

    private final TelegramCodeChatRepository repository;
    private final AppUserService appUserService;
    private final TelegramCodeChatMapper mapper;

    @PostMapping("/register")
    void postRegisterDto(@RequestBody RegisterDto dto) {
        TelegramCodeChat telegramCodeChat = mapper.toEntity(dto);

        repository.save(telegramCodeChat);
    }

}
