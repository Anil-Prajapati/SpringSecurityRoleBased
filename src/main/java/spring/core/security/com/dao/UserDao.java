package spring.core.security.com.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import spring.core.security.com.model.User;

@Repository
public interface UserDao extends CrudRepository<User, String>{

}
