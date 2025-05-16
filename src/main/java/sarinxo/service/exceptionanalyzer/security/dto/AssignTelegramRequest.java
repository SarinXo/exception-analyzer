package sarinxo.service.exceptionanalyzer.security.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class AssignTelegramRequest {
    private UUID code;
}
