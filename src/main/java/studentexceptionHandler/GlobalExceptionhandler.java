package studentexceptionHandler;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.StudentDetails.Entity.ApiErrorBased;




@ControllerAdvice
public class GlobalExceptionhandler extends ResponseEntityExceptionHandler {


	@Override
	protected ResponseEntity<Object> handleMissingPathVariable(MissingPathVariableException ex, HttpHeaders headers,
			HttpStatusCode status, WebRequest request) {
		String msg=ex.getMessage();
		List<String> details=new ArrayList<>();
		details.add("Path variable is missing");
		ApiErrorBased api=new ApiErrorBased(msg,details,status,LocalDateTime.now());
		return ResponseEntity.status(status).body(api);
	}

	@Override
	protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		String msg=ex.getMessage();
		List<String> details=new ArrayList<>();
		details.add("Request param is missing!");
		ApiErrorBased api=new ApiErrorBased(msg,details,status,LocalDateTime.now());
		return ResponseEntity.status(status).body(api);
		
	}

	@Override
	protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers,
			HttpStatusCode status, WebRequest request) {
		String msg=ex.getMessage();
		List<String> details=new ArrayList<>();
		details.add("sorry!Mismatch of Type");
		ApiErrorBased api=new ApiErrorBased(msg,details,status,LocalDateTime.now());
		return ResponseEntity.status(status).body(api);
		
	}

	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		String msg=ex.getMessage();
		List<String> details=new ArrayList<>();
		details.add("Request body is not readable");
		ApiErrorBased api=new ApiErrorBased(msg,details,status,LocalDateTime.now());
		return ResponseEntity.status(status).body(api);
	}

	@Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		String msg=ex.getMessage();
		List<String> details=new ArrayList<>();
		details.add("Request method not supported!");
		ApiErrorBased api=new ApiErrorBased(msg,details,status,LocalDateTime.now());
		return ResponseEntity.status(status).body(api);
	}

	@Override
	protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		
		String msg=ex.getMessage();
		List<String> details=new ArrayList<>();
		details.add("media not supported!");
		details.add(ex.getMessage());
		ApiErrorBased api=new ApiErrorBased(msg,details,status,LocalDateTime.now());
		return ResponseEntity.status(status).body(api);
	}
	
	//book not found exception
	
	@ExceptionHandler(BookNotFoundException.class)
	public ResponseEntity<Object> handleBookNotFoundException(BookNotFoundException ex){
		String msg=ex.getMessage();
		List<String> details=new ArrayList<>();
		details.add("Book not found");
		details.add(ex.getMessage());
		ApiErrorBased errors=new ApiErrorBased(msg,details,HttpStatus.BAD_REQUEST,LocalDateTime.now());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
		
	}
	
	//Id not found exception
	
		@ExceptionHandler(BookNotFoundException.class)
		public ResponseEntity<Object> handleIdNotFoundException(IdNotFoundException ex){
			String msg=ex.getMessage();
			List<String> details=new ArrayList<>();
			details.add("Id not available");
			details.add(ex.getMessage());
			ApiErrorBased errors=new ApiErrorBased(msg,details,HttpStatus.NOT_FOUND,LocalDateTime.now());
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errors);
			
		}
		
		//Other exception like nullpointer,sqlexceptions
		
			@ExceptionHandler(BookNotFoundException.class)
			public ResponseEntity<Object> handleOtherException(Exception ex){
				String msg=ex.getMessage();
				List<String> details=new ArrayList<>();
				details.add("other exceptions");
				details.add(ex.getMessage());
				ApiErrorBased errors=new ApiErrorBased(msg,details,HttpStatus.BAD_REQUEST,LocalDateTime.now());
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
				
			}
	

}
