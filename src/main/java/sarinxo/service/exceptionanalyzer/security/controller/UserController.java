package sarinxo.service.exceptionanalyzer.security.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import sarinxo.service.exceptionanalyzer.security.dto.CreateUserRequest;
import sarinxo.service.exceptionanalyzer.security.dto.CreateUserResponse;
import sarinxo.service.exceptionanalyzer.security.service.AppUserService;

@Controller("/users")
@RequiredArgsConstructor
public class UserController {

    private final AppUserService userService;

    @GetMapping("/{username}")
    public Boolean isExistUserByUsername(@PathVariable String username) {
        return userService.isExist(username);
    }

    @PostMapping
    public CreateUserResponse createUser(@RequestBody CreateUserRequest request) {
        return userService.create(request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable Long id) {
        userService.delete(id);
    }

    @PostMapping("/assign-roles")
    public void assignUserRoles() {

    }
}
