package sarinxo.service.exceptionanalyzer.consumer.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "telegram_code_chat")
public class TelegramCodeChat {

    @Id
    @Column(name = "code", nullable = false)
    private UUID code;

    @Column(name = "chat_id")
    private Long chatId;
}
