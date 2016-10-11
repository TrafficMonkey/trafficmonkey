package com.trafficmonkey.exception;

import com.traficmonkey.enums.Codes;

public class TrafficMonkeyException  extends Exception{
	/** The Constant serialVersionUID. */
	  private static final long serialVersionUID = 1L;

	  /** The code. */
	  private Codes code;

	  /**
	   * 
	   * The Java compiler automatically inserts a call to the no-argument constructor of the superclass.
	   * 
	   */
	  public TrafficMonkeyException() {

	  }

	  /**
	   * Instantiates a new dppm exception.
	   *
	   * @param message
	   *          the message
	   */
	  public TrafficMonkeyException(String message) {
	    super(message);

	  }

	  /**
	   * Constructor new exception with with error code.
	   *
	   * @param errorCode
	   *          the error code
	   */
	  public TrafficMonkeyException(Codes errorCode) {
	    this.code = errorCode;
	  }

	  /**
	   * Constructs a new exception with the error code and specified detail message .
	   *
	   * @param code
	   *          the code
	   * @param message
	   *          the message
	   */
	  public TrafficMonkeyException(Codes code, String message) {
	    super(message);
	    this.code = code;

	  }

	  /**
	   * Instantiates a new dppm exception.
	   *
	   * @param cause
	   *          the cause
	   */
	  public TrafficMonkeyException(Throwable cause) {
	    super(cause);

	  }

	  /**
	   * Constructs a new exception with the specified detail message and cause.
	   *
	   * @param message
	   *          the message
	   * @param cause
	   *          the cause
	   */
	  public TrafficMonkeyException(String message, Throwable cause) {
	    super(message, cause);

	  }

	  /**
	   * Constructs a new exception with the error code , specified detail message and cause.
	   *
	   * @param code
	   *          the code
	   * @param message
	   *          the message
	   * @param cause
	   *          the cause
	   */
	  public TrafficMonkeyException(Codes code, String message, Throwable cause) {
	    super(message, cause);
	    this.code = code;

	  }

	  /**
	   * Constructs a new exception with the specified detail message, cause, suppression enabled or disabled, and writable
	   * stack trace enabled or disabled.
	   *
	   * @param message
	   *          the message
	   * @param cause
	   *          the cause
	   * @param enableSuppression
	   *          the enable suppression
	   * @param writableStackTrace
	   *          the writable stack trace
	   */
	  public TrafficMonkeyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
	    super(message, cause, enableSuppression, writableStackTrace);

	  }

	  /**
	   * Return error code to caller.
	   * 
	   * @return the errorCode
	   */
	  public Codes getCode() {
	    return code;
	  }

}
