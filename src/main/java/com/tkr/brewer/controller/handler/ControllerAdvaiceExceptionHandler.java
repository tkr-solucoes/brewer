package com.tkr.brewer.controller.handler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.tkr.brewer.service.exception.NomeEstiloJaCadastradoExcepition;

@ControllerAdvice
public class ControllerAdvaiceExceptionHandler {
	
	@ExceptionHandler(NomeEstiloJaCadastradoExcepition.class)
	public ResponseEntity<String> handleNomeEstiloCadastradoException(NomeEstiloJaCadastradoExcepition e){
		
		return ResponseEntity.badRequest().body(e.getMessage());
		
	}
	
	

}
