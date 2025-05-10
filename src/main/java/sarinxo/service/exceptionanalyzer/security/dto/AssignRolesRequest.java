package sarinxo.service.exceptionanalyzer.security.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class AssignRolesRequest {
    @NotNull(message = "userId will be not empty")
    private Long userId;
    @NotEmpty(message = "The 'roles' should include 1 or more role id" )
    private List<Long> roles;
}
