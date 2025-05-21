package sarinxo.service.exceptionanalyzer.consumer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sarinxo.service.exceptionanalyzer.consumer.entity.DebugSession;

public interface DebugSessionRepository extends JpaRepository<DebugSession, Long> {
}
