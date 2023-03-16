package spring.core.security.com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.core.security.com.dao.RoleDao;
import spring.core.security.com.model.Role;

@Service
public class RoleService {
	
	@Autowired
	private RoleDao roleDao;
	
	public Role createRole(Role role) {
		return roleDao.save(role);
	}

}
