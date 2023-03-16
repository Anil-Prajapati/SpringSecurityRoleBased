package spring.core.security.com.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import spring.core.security.com.model.Role;

@Repository
public interface RoleDao extends CrudRepository<Role, String>{

}
