package sarinxo.service.exceptionanalyzer.consumer.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterDto {
    private UUID code;
    private Long chatId;
}
