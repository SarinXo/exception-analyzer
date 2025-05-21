package sarinxo.service.exceptionanalyzer.consumer.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sarinxo.service.exceptionanalyzer.consumer.entity.enumerated.ExceptionStatus;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "exceptionInfo")
public class ExceptionInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "stack_trace", columnDefinition = "text")
    private String stackTrace;

    @Column(name = "occurence_time")
    private LocalDateTime occurrenceTime;

    @Column(name = "message", columnDefinition = "text")
    private String message;

    @Column(name = "additional_info")
    private String additionalInfo;

    @Column(name = "app_name")
    private String appName;

    @Column(name = "app_id")
    private UUID appId;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private ExceptionStatus status;
}
