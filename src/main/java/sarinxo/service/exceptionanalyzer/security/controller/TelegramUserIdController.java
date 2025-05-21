package sarinxo.service.exceptionanalyzer.security.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import sarinxo.service.exceptionanalyzer.security.dto.TelegramUserIdRequest;
import sarinxo.service.exceptionanalyzer.security.service.TelegramUserIdService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/telegram-user-ids")
public class TelegramUserIdController {

    private final TelegramUserIdService service;

    @PostMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void create(TelegramUserIdRequest request) {
        service.create(request);
    }

}
