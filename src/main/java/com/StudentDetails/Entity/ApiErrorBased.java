package com.StudentDetails.Entity;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatusCode;

public class ApiErrorBased {
	 String message;
	 List<String> details;
	 HttpStatusCode status;
     LocalDateTime timestamp;
     
     public ApiErrorBased() {
    	 
     }

	public ApiErrorBased(String message, List<String> details, HttpStatusCode status, LocalDateTime timestamp) {
		super();
		this.message = message;
		this.details = details;
		this.status = status;
		this.timestamp = timestamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<String> getDetails() {
		return details;
	}

	public void setDetails(List<String> details) {
		this.details = details;
	}

	public HttpStatusCode getStatus() {
		return status;
	}

	public void setStatus(HttpStatusCode status) {
		this.status = status;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public String toString() {
		return "ApiErrorBased [message=" + message + ", details=" + details + ", status=" + status + ", timestamp="
				+ timestamp + "]";
	}
     

}