package com.cwm.studentmanagement.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.web.csrf.CsrfException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@ControllerAdvice
public class GlobalExecptionHandler {
	
	private static final Logger Log = LoggerFactory.getLogger(GlobalExecptionHandler.class);
	
	@ExceptionHandler(CsrfException.class)
	public String csrfExceptionHandler(CsrfException ex, RedirectAttributes redirectAttributes) {
		Log.warn("CSRF validation failed", ex.getMessage());
		redirectAttributes.addFlashAttribute("message", "Session expired, please log in again.");
		return "redirect:/login";
	}
	
	
	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public String genericExceptionHandler(Exception ex) {
		Log.error("Something went wrong", ex);
		return("500");
	}

}
