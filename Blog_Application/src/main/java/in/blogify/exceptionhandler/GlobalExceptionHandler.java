package in.blogify.exceptionhandler;

import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	  @ExceptionHandler(Exception.class)
	    public String handleException(Exception ex, Model model) {
	        model.addAttribute("errorMessage", "An unexpected error occurred. Please try again later.");
	        return "error-page"; 
	    }
	  
	  @ExceptionHandler(NullPointerException.class)
	    public String handleNullPointerException(NullPointerException ex, Model model) {
	       
		  String message = ex.getMessage();
		  
		  LoggerFactory.getLogger(GlobalExceptionHandler.class).error(message);
		  
		  model.addAttribute("errorMessage", "Failed to retrieve post titles due to a null pointer exception.");
	        return "error-page";
	    }

}
