/******************************************************************
 *  
 * This code is for the Do Process Practice Management (DPPM) project.
 *
 * 
 * © 2016, Do Process Practice Management All rights reserved. 
 * 
 * 
 ******************************************************************/

package com.trafficmonkey.security;

/**
 * Constants for Spring Security authorities.
 */
public final class AuthoritiesConstants {

  /** The Constant ADMIN. */
  public static final String ADMIN = "ROLE_ADMIN";

  /** The Constant USER. */
  public static final String USER = "ROLE_USER";

  /** The Constant ANONYMOUS. */
  public static final String ANONYMOUS = "ROLE_ANONYMOUS";

  /**
   * Instantiates a new authorities constants.
   */
  private AuthoritiesConstants() {
  }
}
