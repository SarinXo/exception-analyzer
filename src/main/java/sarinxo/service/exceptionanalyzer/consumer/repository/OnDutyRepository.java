package sarinxo.service.exceptionanalyzer.consumer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import sarinxo.service.exceptionanalyzer.consumer.entity.OnDuty;
import sarinxo.service.exceptionanalyzer.security.entity.AppUser;

import java.util.Collection;
import java.util.List;

public interface OnDutyRepository extends JpaRepository<OnDuty, Long> {
    @Query("SELECT o FROM OnDuty o JOIN FETCH o.onDuty u")
    List<OnDuty> findAllFetch();
}
