package sarinxo.service.exceptionanalyzer.security.controller;

import jakarta.validation.constraints.Pattern;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sarinxo.service.exceptionanalyzer.security.dto.CreateRoleRequest;
import sarinxo.service.exceptionanalyzer.security.dto.CreateRoleResponse;
import sarinxo.service.exceptionanalyzer.security.service.AppRoleService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/roles")
public class RoleController {

    private final AppRoleService service;

    @PostMapping
    public CreateRoleResponse createRole(@RequestBody CreateRoleRequest request) {
        return service.create(request);
    }

    @DeleteMapping("{id}")
    public void deleteRole(@PathVariable Long id) {
        service.delete(id);
    }
}
