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

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import com.trafficmonkey.utils.SecurityUtils;


/**
 * Implementation of AuditorAware based on Spring Security.
 */
@Component
public class SpringSecurityAuditorAware implements AuditorAware<String> {

  /*
   * (non-Javadoc)
   * 
   * @see org.springframework.data.domain.AuditorAware#getCurrentAuditor()
   */
  @Override
  public String getCurrentAuditor() {
    // Get the current user email based on the login user profile
    String userName = SecurityUtils.getCurrentUserLogin();
    return userName != null ? userName : "system";
  }
}
