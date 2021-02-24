package com.tony.user.exception.handler;

import com.tony.user.controller.output.ErrorOutput;
import com.tony.user.exception.UserNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

	private static final Logger ERROR_LOGGER = LoggerFactory.getLogger(CustomExceptionHandler.class);

	@ExceptionHandler(UserNotFoundException.class)
	public final ResponseEntity<ErrorOutput> handleUserNotFoundException(UserNotFoundException ex, WebRequest request) {
		final HttpStatus status = HttpStatus.NOT_FOUND;
		ERROR_LOGGER.error("{}", ex.getMessage());//TODO get path
		return new ResponseEntity<>(new ErrorOutput(status.value(), ex.getMessage(), "", request.getContextPath()), getContentTypeHeader(), status);
	}

	private HttpHeaders getContentTypeHeader() {
		final HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		return headers;
	}

}
