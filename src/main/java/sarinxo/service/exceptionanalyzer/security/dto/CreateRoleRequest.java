package sarinxo.service.exceptionanalyzer.security.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class CreateRoleRequest {
    @NotNull
    @Pattern(regexp = "^ROLE_[A-Z]+$", message = "the role must fit the pattern '^ROLE_[A-Z]+$'")
    private final String role;
}
