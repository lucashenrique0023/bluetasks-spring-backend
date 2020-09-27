package br.com.softblue.bluetasks.domain.user;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "app_user")
public class AppUser implements Serializable {

	@Id
	@GeneratedValue
	private Integer id;
	
	private String username;
	
	private String password;
	
	private String displayName;
	
	public AppUser() {
	}
	
	public AppUser(String username, String password, String displayName) {
		super();
		this.username = username;
		this.password = password;
		this.displayName = displayName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	
	public String getDisplayName() {
		return this.displayName;
	}

	public Integer getId() {
		return id;
	}

	
}
