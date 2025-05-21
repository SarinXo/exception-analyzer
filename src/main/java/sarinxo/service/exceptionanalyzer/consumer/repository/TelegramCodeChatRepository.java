package sarinxo.service.exceptionanalyzer.consumer.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import sarinxo.service.exceptionanalyzer.consumer.entity.TelegramCodeChat;

import java.util.UUID;

public interface TelegramCodeChatRepository extends JpaRepository<TelegramCodeChat, UUID> {
}
