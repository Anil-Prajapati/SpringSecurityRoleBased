package spring.core.security.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import spring.core.security.com.model.JwtReponse;
import spring.core.security.com.model.JwtRequest;
import spring.core.security.com.service.JwtService;

@RestController
@CrossOrigin
public class JwtController {
	
	@Autowired
	private JwtService jwtService;

	
	@PostMapping("/authenticate")
	public JwtReponse createJwtToken(@RequestBody JwtRequest jwtRequest) throws Exception {
		return jwtService.createJwtToke(jwtRequest);
	}
}








