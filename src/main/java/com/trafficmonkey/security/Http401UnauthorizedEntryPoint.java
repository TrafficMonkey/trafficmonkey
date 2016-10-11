
package com.trafficmonkey.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

/**
 * Returns a 401 error code (Unauthorized) to the client.
 */
@Component
public class Http401UnauthorizedEntryPoint implements AuthenticationEntryPoint {

  /** The log. */
  private final Logger log = LoggerFactory.getLogger(Http401UnauthorizedEntryPoint.class);

  /**
   * Always returns a 401 error code to the client.
   *
   * @param request
   *          the request
   * @param response
   *          the response
   * @param arg2
   *          the arg2
   * @throws IOException
   *           Signals that an I/O exception has occurred.
   * @throws ServletException
   *           the servlet exception
   */
  @Override
  public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException arg2)
      throws IOException, ServletException {

    log.debug("Pre-authenticated entry point called. Rejecting access");
    // Setting 401 as the response status code
    response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Access Denied");
  }
}
