package prasun.banking.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;

public class CustomLogoutSuccessHandler extends SimpleUrlLogoutSuccessHandler implements LogoutSuccessHandler {
	private static final Logger log = LoggerFactory.getLogger(CustomLogoutSuccessHandler.class);

    public CustomLogoutSuccessHandler() {
        super();
    }

    // API

    @Override
    public void onLogoutSuccess(final HttpServletRequest request, final HttpServletResponse response, final Authentication authentication) throws IOException, ServletException {
        final String refererUrl = request.getHeader("Referer");
        log.info(refererUrl);
        final HttpSession session = request.getSession();
        if (session != null) {
            session.removeAttribute("user");
        }

        super.onLogoutSuccess(request, response, authentication);
    }

}