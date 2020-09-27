package br.com.softblue.bluetasks.test;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import br.com.softblue.bluetasks.domain.task.Task;
import br.com.softblue.bluetasks.domain.task.TaskRepository;
import br.com.softblue.bluetasks.domain.user.AppUser;
import br.com.softblue.bluetasks.domain.user.AppUserRepository;

@Component
public class InsertTestData {

	private TaskRepository taskRepository;
	private AppUserRepository appUserRepository;
	
	@Autowired
	public InsertTestData(TaskRepository taskRepository, AppUserRepository appUserRepository) {
		this.taskRepository = taskRepository;
		this.appUserRepository = appUserRepository;
	}
	
	@EventListener
	public void onApplicationEvent(ContextRefreshedEvent event) {
		// TODO: Criptografar Senha
		AppUser appUser = new AppUser("lucas", "abc", "Lucas Coder");
		appUserRepository.save(appUser);
		
		LocalDate baseDate = LocalDate.parse("2025-02-01");
		
		for (int i = 1; i <= 10; i++) {
			Task task = new Task("Tarefa #" + i, baseDate.plusDays(i), false, appUser);
			taskRepository.save(task);
		}
	}

}
