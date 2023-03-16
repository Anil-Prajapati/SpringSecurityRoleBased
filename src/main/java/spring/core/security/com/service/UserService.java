package spring.core.security.com.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import spring.core.security.com.dao.RoleDao;
import spring.core.security.com.dao.UserDao;
import spring.core.security.com.model.Role;
import spring.core.security.com.model.User;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;

	@Autowired
	private RoleDao roleDao;

	@Autowired
	private PasswordEncoder passwordEncoder;

	public User createUser(User user) {
		Role role = roleDao.findById("User").get();
		Set<Role> roles = new HashSet<>();
		roles.add(role);
		user.setRole(roles);
		user.setUserPassword(getEncodedPassword(user.getUserPassword()));
		return userDao.save(user);
	}

	public void initCreateUserAndRole() {

//		// this is the admin role only access
//		Role AdminRole = new Role();
//		AdminRole.setRoleName("Admin");
//		AdminRole.setRoleDiscription("this is the admin role..");
//		roleDao.save(AdminRole);
//
//		// this is the product role and admin role we can access only
//		Role productRole = new Role();
//		productRole.setRoleName("Product");
//		productRole.setRoleDiscription("this is the product role..");
//		roleDao.save(productRole);
//
//		// this is the Order role and admin role we can access only. product role we can
//		// not access
//		Role OrderRole = new Role();
//		OrderRole.setRoleName("Order");
//		OrderRole.setRoleDiscription("this is the Order role..");
//		roleDao.save(OrderRole);
//
//		// this is the user roles
//		Role userRole = new Role();
//		userRole.setRoleName("user");
//		userRole.setRoleDiscription("this is the user role..");
//		roleDao.save(userRole);
//
//		// this is the admin role we can access
//		User adminRole = new User();
//		adminRole.setUserName("admin");
//		adminRole.setFirstName("admin");
//		adminRole.setLastName("prajaapti");
//		adminRole.setEmail("admin@gmail.com");
//		adminRole.setDate("11-02-2023");
//		adminRole.setUserPassword(getEncodedPassword("admin"));
//
//		Set<Role> userRoles = new HashSet<>();
//		userRoles.add(AdminRole);
//		adminRole.setRole(userRoles);
//		userDao.save(adminRole);
//
//		// this is the product role
//		User productRoles = new User();
//		productRoles.setUserName("product");
//		productRoles.setFirstName("product");
//		productRoles.setLastName("prajaapti");
//		productRoles.setEmail("admin@gmail.com");
//		productRoles.setDate("11-02-2023");
//		productRoles.setUserPassword(getEncodedPassword("product"));
//
//		Set<Role> productsRoles = new HashSet<>();
//		productsRoles.add(productRole);
//		productRoles.setRole(productsRoles);
//		userDao.save(productRoles);
//
//		// this is the order role
//		User oderRoles = new User();
//		oderRoles.setUserName("order");
//		oderRoles.setFirstName("order");
//		oderRoles.setLastName("prajaapti");
//		oderRoles.setEmail("order@gmail.com");
//		oderRoles.setDate("11-02-2023");
//		oderRoles.setUserPassword(getEncodedPassword("order"));
//
//		Set<Role> orderRoles = new HashSet<>();
//		orderRoles.add(OrderRole);
//		oderRoles.setRole(orderRoles);
//		userDao.save(oderRoles);

		// this is the user role
//		User usersRole = new User();
//		usersRole.setUserName("anil");
//		usersRole.setFirstName("anil");
//		usersRole.setLastName("prajaapti");
//		usersRole.setEmail("anil@gmail.com");
//		usersRole.setDate("11-02-2023");
//		usersRole.setUserPassword(getEncodedPassword("anil"));
//		
//		Set<Role> usersRoles = new HashSet<>();
//		usersRoles.add(userRole);
//		usersRole.setRole(usersRoles);
//		userDao.save(usersRole);
	}

	public String getEncodedPassword(String password) {
		return passwordEncoder.encode(password);
	}

}
