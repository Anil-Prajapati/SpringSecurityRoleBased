package spring.core.security.com.controller;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import spring.core.security.com.model.User;
import spring.core.security.com.service.UserService;

@RestController
@CrossOrigin
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping({ "/createUser" })
	public User createUser(@RequestBody User user) {
		return userService.createUser(user);
	}

	@PostConstruct
	public void initAdminAndUser() {
		userService.initCreateUserAndRole();
	}

	// this is the admin of the method
	@GetMapping(value="/forAdmin")
	@PreAuthorize("hasAnyRole('Admin')")
	public String forAdmin() {
		return "THIS IS THE PRODUCT ROLE WE CAN ACCESS ADMIN AND PRODUCT";
	}

	// this is the order of the method
	@GetMapping(value="/forProduct")
	@PreAuthorize("hasAnyRole('Admin','Product')")
	public String forProduct() {
		return "THIS IS THE PRODUCT ROLE WE CAN ACCESS ADMIN AND PRODUCT";
	}
	
	
	@GetMapping(value="/forOrder")
	@PreAuthorize("hasAnyRole('Admin','Order')")
	public String forOrder() {
		return "THIS IS THE ONLY CAN ACCESS ADMIN AND ORDER ROLE...";
	}

	// this is the user method to access
	@GetMapping({ "/forUser" })
	@PreAuthorize("hasAnyRole('user')")
	public String forUser() {
		return "This is the URL for User ";
	}
}
