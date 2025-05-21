package sarinxo.service.exceptionanalyzer.consumer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sarinxo.service.exceptionanalyzer.consumer.entity.ExceptionWaitingTime;

public interface ExceptionWaitingTimeRepository extends JpaRepository<ExceptionWaitingTime, Long> {
}