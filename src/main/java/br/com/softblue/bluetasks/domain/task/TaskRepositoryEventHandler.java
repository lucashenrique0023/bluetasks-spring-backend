package br.com.softblue.bluetasks.domain.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.HandleBeforeSave;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.stereotype.Component;

@Component
@RepositoryEventHandler(Task.class)
public class TaskRepositoryEventHandler {

	private TaskRepository taskRepository;
	
	@Autowired
	public TaskRepositoryEventHandler(TaskRepository taskRepository) {
		this.taskRepository = taskRepository;
	}
	
	@HandleBeforeSave  //put
	@HandleBeforeCreate  //post
	public void handle(Task task) throws DuplicateTaskException {
		
		Task taskDB = taskRepository.findByDescription(task.getDescription());
		boolean duplicate = false;
		
		if (taskDB != null) {		
			// Criando
			if ((task.getId() == null || task.getId() == 0 ) && task.getDescription().equals(taskDB.getDescription())) {
				duplicate = true;
					
			}
			
			// Atualizando
			if ((task.getId() != null && task.getId() > 0) && task.getId().equals(taskDB.getId())){
				duplicate = true;
			}
		}
		
		if (duplicate) {
			throw new DuplicateTaskException("Ja existe uma tarefa com esta descricao");
		}
	}

}
