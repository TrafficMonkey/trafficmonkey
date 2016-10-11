package com.trafficmonkey.controller;

import java.util.Properties;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.trafficmonkey.DTO.LoginDTO;
import com.trafficmonkey.DTO.RegistrationDTO;
import com.trafficmonkey.exception.TrafficMonkeyException;
import com.trafficmonkey.exception.UnauthorizedException;
import com.trafficmonkey.security.jwt.JWTConfigurer;
import com.trafficmonkey.security.jwt.TokenProvider;
import com.trafficmonkey.service.RegistrationService;
import com.traficmonkey.enums.Codes;
import com.traficmonkey.enums.ResponseKeyName;
@RestController
public class RegistrationController extends BaseRestController {

	@Inject
	private RegistrationService registrationService;
	 /** The token provider. */
	  @Inject
	  private TokenProvider tokenProvider;

	  /** The authentication manager. */
	  @Inject
	  private AuthenticationManager authenticationManager;
	  
	  /** The error properties. */
	  @Autowired
	  @Qualifier("errorProperties")
	  private Properties errorProperties;
	
	 @RequestMapping(value = "/signUp/", method = RequestMethod.POST)
	    public ResponseEntity<Void> createUser(@RequestBody RegistrationDTO registration) throws TrafficMonkeyException{
	        System.out.println("Creating User " + registration.getName());
	 
	        /*if (userService.isUserExist(user)) {
	            System.out.println("A User with name " + user.getUsername() + " already exist");
	            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
	        }*/
	 
	        registrationService.saveUser(registration);
	 
	        HttpHeaders headers = new HttpHeaders();
	       // headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(user.getId()).toUri());
	        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	    }
	 
	 
	 @RequestMapping(value = "/login/", method = RequestMethod.POST)
	    public ResponseEntity<Object> authenticateUser(@RequestBody LoginDTO loginDTO,     HttpServletResponse response) throws TrafficMonkeyException {
	        System.out.println("Authenticate user " + loginDTO.getEmail());
	 System.out.println(Codes.INVALID_CREDENTIALS);


	        String userNameForAuthentication = null;

	        // Checking whether the email and public account id are exists in the login object or not
	        if (!StringUtils.isEmpty(loginDTO.getEmail())) {
	          userNameForAuthentication = loginDTO.getEmail().trim() ;
	        }

	        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
	            userNameForAuthentication, loginDTO.getPassword());

	        try {
	        	

	          // Authenticating with authentication token
	          Authentication authentication = this.authenticationManager.authenticate(authenticationToken);
	         // log.error("got authentication object from user details service");
	    
	          RegistrationDTO registration =  (RegistrationDTO) authentication.getPrincipal();

	          boolean rememberMe = (loginDTO.isRememberMe() == null) ? false : loginDTO.isRememberMe();

	        //  log.error("Going to create JWT token");

	          // Creating token
	          String jwt = tokenProvider.createToken(authentication, rememberMe, registration.getLogin());

	          //log.error("Token sucessfully created");

	          response.addHeader(JWTConfigurer.AUTHORIZATION_HEADER, "Bearer " + jwt);

	         // log.debug("User logged successfully - " + user);
	          return ResponseEntity.ok(createSuccessResponse(ResponseKeyName.USER, registration));
	        } catch (AuthenticationException exception) {
	          exception.printStackTrace();
	          throw new UnauthorizedException(Codes.INVALID_CREDENTIALS);

	        }
	      
	    }
	 
	 
	 
}
