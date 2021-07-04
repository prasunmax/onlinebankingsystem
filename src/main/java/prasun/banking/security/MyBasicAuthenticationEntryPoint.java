package prasun.banking.security;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import net.minidev.json.JSONObject;

@Component
public class MyBasicAuthenticationEntryPoint extends BasicAuthenticationEntryPoint {
 
    @Override
    public void commence(
      HttpServletRequest request, HttpServletResponse response, AuthenticationException authEx) 
      throws IOException {
        response.addHeader("WWW-Authenticate", "Basic realm=" + getRealmName() + "");
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("message", "HTTP Status 401 -"+authEx.getMessage());
        PrintWriter writer = response.getWriter();
        writer.println(jsonObject.toJSONString());
    }
 
    @Override
    public void afterPropertiesSet() {
        setRealmName("Banking");
        super.afterPropertiesSet();
    }
}