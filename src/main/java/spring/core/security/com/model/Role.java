package spring.core.security.com.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="role")
public class Role {

	
	@Id
	private String roleName;
	private String roleDiscription;
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getRoleDiscription() {
		return roleDiscription;
	}
	public void setRoleDiscription(String roleDiscription) {
		this.roleDiscription = roleDiscription;
	}
	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Role(String roleName, String roleDiscription) {
		super();
		this.roleName = roleName;
		this.roleDiscription = roleDiscription;
	}
	
	
	@Override
	public String toString() {
		return "Role [roleName=" + roleName + ", roleDiscription=" + roleDiscription + "]";
	}
	
		
}
