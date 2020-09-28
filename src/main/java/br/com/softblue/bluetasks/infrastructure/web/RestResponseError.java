package br.com.softblue.bluetasks.infrastructure.web;

import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;

// Classe responsavel por tratar as mensagens de error.
public class RestResponseError {

	private String error;
	
	private RestResponseError() {
	}
	
	public String getError() {
		return error;
	}
	
	// Pega todos os errors e transforma em apenas 1.
	public static RestResponseError fromValidationError(Errors errors) {
		RestResponseError resp = new RestResponseError();
		StringBuilder sb = new StringBuilder();
		
		for (ObjectError error : errors.getAllErrors()) {
			sb.append(error.getDefaultMessage()).append(". ");
		}
		
		resp.error = sb.toString();
		return resp;
	}

}
