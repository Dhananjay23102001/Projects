package in.blogify.exceptionhandler;

import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	  @ExceptionHandler(Exception.class)
	    public String handleException(Exception ex, Model model) {
	        // Perform exception handling logic here
	        // You can log the exception, display an error message, etc.

	        model.addAttribute("errorMessage", "An unexpected error occurred. Please try again later.");
	        return "error-page"; // Specify the name of your custom error page
	    }
	  
	  @ExceptionHandler(NullPointerException.class)
	    public String handleNullPointerException(NullPointerException ex, Model model) {
	        // Perform exception handling logic for NullPointerException
	       
		  String message = ex.getMessage();
		  
		  LoggerFactory.getLogger(GlobalExceptionHandler.class).error(message);
		  
		  model.addAttribute("errorMessage", "Failed to retrieve post titles due to a null pointer exception.");
	        return "error-page";
	    }

}
