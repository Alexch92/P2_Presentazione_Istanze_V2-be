package it.osapulie.domain.dto;

public class UserInfo {
	private String userName;
	private String password;
	
	private String[] roles;
	
	public UserInfo() {
		super();
	}
	
	public UserInfo( String userName, String password, String[] roles ) {
		super();
		this.userName = userName;
		this.password = password;
		this.roles = roles;
	}

	public String getUserName() {
		return userName;
	}
	
	public String getPassword() {
		return password;
	}

	public String[] getRoles() {
		return roles;
	}

	public boolean hasRole( String ruolo ) {
		for (String r : roles) {
			if (r.equals( ruolo )) {
				return true;
			}
		}
		return false;
	}
}
