package com.credit.analysis.exeption;

import org.hibernate.validator.internal.engine.ConstraintViolationImpl;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolationException;
import java.util.*;
import java.util.stream.Collectors;

@ControllerAdvice
public class CreditAnalysisExeptionHandler extends ResponseEntityExceptionHandler {
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
																  HttpHeaders headers, HttpStatus status, WebRequest request) {
		List<Errors> listErrors = generationErrors(ex.getBindingResult());
		return handleExceptionInternal(ex, listErrors, headers, HttpStatus.BAD_REQUEST, request);
	}

	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<Object> handleConstraintViolationException(
			ConstraintViolationException ex, WebRequest request) {
		String msg = ex.getMessage();
		List<Errors> listErrors = Arrays.asList(new Errors(msg));
		return handleExceptionInternal(ex, listErrors, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
	}

	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<Object> handleDataIntegrityViolationException(
			DataIntegrityViolationException ex, WebRequest request) {
		String msg = ex.getMessage();
		List<Errors> listErrors = Arrays.asList(new Errors(msg));
		return handleExceptionInternal(ex, listErrors, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
	}

	public List<Errors> generationErrors(BindingResult bindingResult) {
		List<Errors> listErrors = new ArrayList<>();
		bindingResult.getFieldErrors().forEach(fieldError -> {
			String teste = String.valueOf(trataError(fieldError));
			listErrors.add(new Errors(teste));
		});
		return listErrors;
	}

	public String trataError(FieldError fieldError) {
		return fieldError.getDefaultMessage();
	}
}
