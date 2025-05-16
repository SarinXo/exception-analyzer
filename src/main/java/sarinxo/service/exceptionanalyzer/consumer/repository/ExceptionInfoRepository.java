package sarinxo.service.exceptionanalyzer.consumer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sarinxo.service.exceptionanalyzer.consumer.entity.ExceptionInfo;

public interface ExceptionInfoRepository extends JpaRepository<ExceptionInfo, Long> {
}
