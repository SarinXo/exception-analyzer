package sarinxo.service.exceptionanalyzer.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sarinxo.service.exceptionanalyzer.security.entity.AppRole;

public interface AppRoleRepository extends JpaRepository<AppRole, Long> {
}
