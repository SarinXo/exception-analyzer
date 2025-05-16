package sarinxo.service.exceptionanalyzer.consumer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sarinxo.service.exceptionanalyzer.consumer.entity.Report;

public interface ReportRepository extends JpaRepository<Report, Long> {
}
