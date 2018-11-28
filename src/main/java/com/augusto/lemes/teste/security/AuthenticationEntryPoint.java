package com.augusto.lemes.teste.security;


import java.io.IOException;
import java.io.PrintWriter;
 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import org.springframework.stereotype.Component;


/**
 * 
 * @author Augusto Lemes
 * @since 28/11/2018
 * 
 * Component BASIC AUTHENTICATION.
 * Foi feito um BASIC AUTHENTICATION, porém esse serviço deve ser associado
 * a uma autenticação oAuth2 ou similar.
 *
 */
@Component
public class AuthenticationEntryPoint extends BasicAuthenticationEntryPoint {
	
	   @Override
	    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authEx)
	            throws IOException, ServletException {
	        response.addHeader("WWW-Authenticate", "Basic realm=" + getRealmName());
	        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
	        PrintWriter writer = response.getWriter();
	        writer.println("HTTP Status 401 - " + authEx.getMessage());
	    }
	 
	    @Override
	    public void afterPropertiesSet() throws Exception {
	        setRealmName("o7planning");
	        super.afterPropertiesSet();
	    }

}
