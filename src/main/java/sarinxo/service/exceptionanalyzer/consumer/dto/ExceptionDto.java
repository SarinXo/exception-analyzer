package sarinxo.service.exceptionanalyzer.consumer.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExceptionDto {
    private String stackTrace;
    private LocalDateTime occurrenceTime;
    private String message;
    private String additionalInfo;
    private String appName;
    private UUID appId;
}
