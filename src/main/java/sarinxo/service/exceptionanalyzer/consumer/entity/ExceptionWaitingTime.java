package sarinxo.service.exceptionanalyzer.consumer.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sarinxo.service.exceptionanalyzer.security.entity.AppUser;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "exception_waiting_time")
public class ExceptionWaitingTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "exception_happens_time")
    private LocalDateTime exceptionHappensTime;

    @Column(name = "exception_start_solving_time")
    private LocalDateTime exceptionStartSolvingTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "debug_man")
    private AppUser debugMan;

}
