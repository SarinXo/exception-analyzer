package sarinxo.service.exceptionanalyzer.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sarinxo.service.exceptionanalyzer.security.entity.TelegramUserId;

import java.util.UUID;

public interface TelegramUserIdRepository extends JpaRepository<TelegramUserId, UUID> {
}
