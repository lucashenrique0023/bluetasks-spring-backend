package br.com.softblue.bluetasks.domain.task;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.com.softblue.bluetasks.domain.user.AppUser;

@Entity
public class Task implements Serializable {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	private String description;
	
	private LocalDate whenToDo;
	
	private Boolean done = false;
	
	@ManyToOne
	@JoinColumn(name = "app_user_id")
	private AppUser appUser;

	public Task() {
		// TODO Auto-generated constructor stub
	}

	public Task(String description, LocalDate whenToDo, Boolean done, AppUser appUser) {
		super();
		this.description = description;
		this.whenToDo = whenToDo;
		this.done = done;
		this.appUser = appUser;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getWhenToDo() {
		return whenToDo;
	}

	public void setWhenToDo(LocalDate whenToDo) {
		this.whenToDo = whenToDo;
	}

	public Boolean getDone() {
		return done;
	}

	public void setDone(Boolean done) {
		this.done = done;
	}

	public AppUser getAppUser() {
		return appUser;
	}

	public void setAppUser(AppUser appUser) {
		this.appUser = appUser;
	}

	public Integer getId() {
		return id;
	}
}
