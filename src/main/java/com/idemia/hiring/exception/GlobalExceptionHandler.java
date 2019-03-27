package com.idemia.hiring.exception;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.idemia.hiring.response.ResponseEnvelope;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@ExceptionHandler(value = CandidateException.class)
	public ResponseEntity<Object> VerificationException(CandidateException exception, WebRequest request) {
		ResponseEnvelope errorMessage = new ResponseEnvelope();
		errorMessage.setSuccess(false);
		errorMessage.setMessage(exception.getMessage());
		return new ResponseEntity<Object>(errorMessage, HttpStatus.BAD_REQUEST);
	}
	
	@Override
	public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		logger.error("exception in verification service", ex);
		List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
		List<ObjectError> globalErrors = ex.getBindingResult().getGlobalErrors();
		List<FieldErrorDTO> errors = new ArrayList<FieldErrorDTO>(fieldErrors.size() + globalErrors.size());
		// String error;
		for (FieldError fieldError : fieldErrors) {
			FieldErrorDTO error = new FieldErrorDTO(fieldError.getField(), fieldError.getDefaultMessage());
			errors.add(error);
		}
		for (ObjectError objectError : globalErrors) {
			FieldErrorDTO error = new FieldErrorDTO(objectError.getObjectName(), objectError.getDefaultMessage());
			errors.add(error);
		}

		ResponseEnvelope errorMessage = new ResponseEnvelope();
		errorMessage.setErrors(errors);
		errorMessage.setSuccess(false);
		return new ResponseEntity<Object>(errorMessage, headers, status);

	}

	@Override
	public ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		logger.error("exception in verification service", ex);
		String unsupported = "Unsupported content type: " + ex.getContentType();
		String supported = "Supported content types: " + MediaType.toString(ex.getSupportedMediaTypes());
		ResponseEnvelope errorMessage = new ResponseEnvelope();
		errorMessage.setSuccess(false);
		errorMessage.setMessage(ex.getMessage());
		return new ResponseEntity<Object>(errorMessage, headers, status);

	}

}
