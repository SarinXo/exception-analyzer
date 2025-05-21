package sarinxo.service.exceptionanalyzer.consumer.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MessageDto {
    @NotNull(message = "chatId is required")
    private Long chatId;
    @NotNull(message = "text is required")
    private String text;
}