package sarinxo.service.exceptionanalyzer.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sarinxo.service.exceptionanalyzer.security.entity.AppUser;

import java.util.Optional;

public interface AppUserRepository extends JpaRepository<AppUser, Long> {

    Optional<AppUser> findUserByUsername(String username);

    Boolean existsByUsername(String username);

}
