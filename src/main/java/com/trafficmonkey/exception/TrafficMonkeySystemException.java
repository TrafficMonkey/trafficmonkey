package com.trafficmonkey.exception;

public class TrafficMonkeySystemException extends RuntimeException {


	  /** The Constant serialVersionUID. */
	  private static final long serialVersionUID = 1L;

	  /**
	   * Instantiates a new dppm system exception.
	   */
	  public TrafficMonkeySystemException() {

	  }

	  /**
	   * Instantiates a new dppm system exception.
	   *
	   * @param message
	   *          the message
	   */
	  public TrafficMonkeySystemException(String message) {
	    super(message);

	  }

	  /**
	   * Instantiates a new dppm system exception.
	   *
	   * @param cause
	   *          the cause
	   */
	  public TrafficMonkeySystemException(Throwable cause) {
	    super(cause);

	  }

	  
	  public TrafficMonkeySystemException(String message, Throwable cause) {
	    super(message, cause);

	  }

	 
	  public TrafficMonkeySystemException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
	    super(message, cause, enableSuppression, writableStackTrace);

	  }


}
