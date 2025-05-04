package sarinxo.service.exceptionanalyzer.security.controller;

import jakarta.validation.constraints.Pattern;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import sarinxo.service.exceptionanalyzer.security.dto.CreateRoleResponse;
import sarinxo.service.exceptionanalyzer.security.service.AppRoleService;

@Controller
@RequiredArgsConstructor
public class RoleController {

    private AppRoleService service;

    @PostMapping("/{roleName}")
    public CreateRoleResponse createRole(
            @PathVariable
            @Pattern(regexp = "^ROLE_[A-Z]+$", message = "the role must fit the pattern '^ROLE_[A-Z]+$'")
            String roleName ) {
        return service.create(roleName);
    }

    @DeleteMapping("{id}")
    public void deleteRole(@PathVariable Long id) {
        service.delete(id);
    }
}
