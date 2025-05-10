package sarinxo.service.exceptionanalyzer.security.handler;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import java.io.IOException;

public class AppAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    private final static String ADMIN = "ROLE_ADMIN";

    @Override
    public void onAuthenticationSuccess(
            HttpServletRequest request,
            HttpServletResponse response,
            Authentication authentication
    ) throws IOException {

        boolean isAdmin = authentication.getAuthorities().stream()
                .anyMatch(role -> ADMIN.equals(role.getAuthority()));

        if (isAdmin) {
            response.sendRedirect("/admin");
        } else {
            response.sendRedirect("/debug-man");
        }

    }
}
