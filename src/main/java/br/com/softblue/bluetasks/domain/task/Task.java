package br.com.softblue.bluetasks.domain.task;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.softblue.bluetasks.domain.user.AppUser;

@Entity
public class Task implements Serializable {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@NotEmpty(message = "A descricao da tarefa e obrigatoria")
	@Length(min = 3, max = 40, message = "O tamanho da tarefa e invalido.")
	private String description;
	
	@NotNull(message = "A data da tarefa e obrigatoria.")
	@FutureOrPresent(message = "A data da tarefa nao pode ser inferior a data atual.")
	private LocalDate whenToDo;
	
	private Boolean done = false;
	
	@ManyToOne
	@JoinColumn(name = "app_user_id")
	@NotNull(message = "O usuario da tarefa e obrigatorio.")
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
