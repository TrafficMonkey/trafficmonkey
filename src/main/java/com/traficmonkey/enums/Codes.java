package com.traficmonkey.enums;

public enum Codes {
	/** The invalid credentials. */
	  INVALID_CREDENTIALS("app.invalidateCreditial"),
	  
	  /** The system error. */
	  SYSTEM_ERROR("System.error"),

	  ACCESS_DENIED("app.accessDenied"),
	ALREADY_EXISTS_EMAIL("app.already.exist");
	  
	  /** The error code. */
	  private String errorCode;

	  /**
	   * Gets the error code.
	   *
	   * @return the error
	   */
	  public String getErrorCode() {
	    return errorCode;
	  }

	  /**
	   * Instantiates a new codes.
	   *
	   * @param error
	   *          the error
	   */
	  private Codes(String error) {
	    this.errorCode = error;
	  }
}
