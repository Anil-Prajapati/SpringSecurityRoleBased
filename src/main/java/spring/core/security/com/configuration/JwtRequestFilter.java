package spring.core.security.com.configuration;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.ExpiredJwtException;
import spring.core.security.com.service.JwtService;
import spring.core.security.com.util.JwtUtil;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {

	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	private JwtService jwtService;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		final String header = request.getHeader("Authorization");

		String jwtToken = null;
		String userName = null;
		if (header != null && header.startsWith("Bearer ")) {
			jwtToken = header.substring(7);

			try {
				userName = jwtUtil.getUserNameFormToken(jwtToken);
			} catch (IllegalArgumentException e) {
				System.out.println("unable to get jwt token");
			}catch(ExpiredJwtException e) {
				System.out.println("jwt token is expired");
			}
		} else {
			System.out.println("jwt token doen not start with bearer...");
		}
		if (userName != null && SecurityContextHolder.getContext().getAuthentication()==null) {
			UserDetails userDetails = jwtService.loadUserByUsername(userName);
			if (jwtUtil.validateToken(jwtToken, userDetails)) {
				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
						userName, userDetails.getAuthorities(), null);
				usernamePasswordAuthenticationToken
						.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
			}
		}

		filterChain.doFilter(request, response);
	}

}
