package net.guides.springboot.crud.exception;

import java.util.Date;
/**
 * 
 * @author diego
 *
 */
public class ErrorDetails {
	/**
	 * campos para manejar errores
	 * private Date timestamp;
	private String message;
	private String details;
	 */
	private Date timestamp;
	private String message;
	private String details;
/**
 * 
 * @param timestamp
 * @param message
 * @param details
 */
	public ErrorDetails(Date timestamp, String message, String details) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;
	}
/**
 * 
 * @return timestamp
 */
	public Date getTimestamp() {
		return timestamp;
	}
/**
 * 
 * @return message
 */
	public String getMessage() {
		return message;
	}
/**
 * 
 * @return details
 */
	public String getDetails() {
		return details;
	}
}
