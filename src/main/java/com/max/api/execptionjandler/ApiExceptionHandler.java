package com.max.api.execptionjandler;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		var problem = new ProblemException();
		var campos = new ArrayList<ProblemException.Campo>();
		
		for (ObjectError error: ex.getBindingResult().getAllErrors()) {
			String nomeCampo = ((FieldError) error).getField();
			String mensagem = error.getDefaultMessage();

			
			campos.add(new ProblemException.Campo(nomeCampo, mensagem));
		}
		
		problem.setStatus(status.value());
		problem.setTitulo("Campo inválido");
		problem.setDataHora(LocalDateTime.now());
		problem.setCampos(campos);
		return super.handleExceptionInternal(ex, problem, headers, status, request);
	}
	

}
