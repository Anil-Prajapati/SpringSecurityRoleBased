package spring.core.security.com.model;


public class JwtReponse {
	
	private User user;
	
	private String jwtToken;

	public JwtReponse(User user, String jwtToken) {
		super();
		this.user = user;
		this.jwtToken = jwtToken;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getJwtToken() {
		return jwtToken;
	}

	public void setJwtToken(String jwtToken) {
		this.jwtToken = jwtToken;
	}

	public JwtReponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "JwtReponse [user=" + user + ", jwtToken=" + jwtToken + "]";
	}
	
	

}
