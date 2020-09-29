package br.com.softblue.bluetasks;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.core.event.ValidatingRepositoryEventListener;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import br.com.softblue.bluetasks.domain.task.Task;

@SpringBootApplication
public class BluetasksBackendApplication implements RepositoryRestConfigurer {
	private static final Logger logger = LoggerFactory.getLogger(BluetasksBackendApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BluetasksBackendApplication.class, args);
		logger.info("Bluetasks Iniciado!");
	}
	
	// Poderiamos criar uma nova classe anotar com @Configure e implementar a configuracao la.
	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
		config.exposeIdsFor(Task.class);
	}
	
	@Bean
	public Validator validator() {
		return new LocalValidatorFactoryBean();
	}
	
	// Configurar Eventos de Validacao (Momento em que a validacao vai ser executada)
	// As menssagens de erro de validacao ja vao voltar tratadas em um array de errors(sem stacktrace, etc..)
	@Override
	public void configureValidatingRepositoryEventListener(ValidatingRepositoryEventListener validatingListener) {
		Validator validator = validator();
		validatingListener.addValidator("beforeCreate", validator);
		validatingListener.addValidator("beforeSave", validator);
		
		logger.info("Configure Validator... OK!");
	}

}
