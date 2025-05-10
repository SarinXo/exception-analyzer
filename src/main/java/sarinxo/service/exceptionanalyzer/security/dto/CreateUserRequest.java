package sarinxo.service.exceptionanalyzer.security.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class CreateUserRequest {
    @NotEmpty(message = "username can't be empty")
    private String username;
    @NotEmpty(message = "password can't be empty")
    private String password;
}
