package spring.core.security.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import spring.core.security.com.model.Role;
import spring.core.security.com.service.RoleService;

@RestController
@CrossOrigin
public class RoleController {
	
	@Autowired
	private RoleService roleService;
	
	
	//this is the created role of the method
	@PostMapping("/role")
	public Role createRole(@RequestBody Role role) {
		return roleService.createRole(role);
	}
	

}
