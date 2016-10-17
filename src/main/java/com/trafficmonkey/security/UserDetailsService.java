

package com.trafficmonkey.security;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsChecker;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.trafficmonkey.DTO.LoginDTO;
import com.trafficmonkey.DTO.ParentChildDTO;
import com.trafficmonkey.DTO.RegistrationDTO;
import com.trafficmonkey.model.ParentChildModel;
import com.trafficmonkey.model.RegistrationModel;
import com.trafficmonkey.service.ParentChildService;
import com.trafficmonkey.service.RegistrationService;

/**
 * Authenticate a user from the database.
 */
@Component("userDetailsService")
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

  /** The log. */
  private final Logger log = LoggerFactory.getLogger(UserDetailsService.class);

  /** The user repository. */
  @Inject
  private ParentChildService parentChildService;

  /*
   * (non-Javadoc)
   * 
   * @see org.springframework.security.core.userdetails.UserDetailsService#loadUserByUsername(java.lang.String)
   */
  @Override
  @Transactional
  public UserDetails loadUserByUsername(final String userNameForAuthentication) {
    //log.debug("Authenticating {}", userNameForAuthentication);
	  
    ParentChildDTO  user=null;
    //Get userNameForAuthentication as the format of email_accountid
    String[] tokens = StringUtils.split(userNameForAuthentication, "_");

    String lowercaseEmailLogin = tokens[0];
   // String publicAccountId = tokens[1];

    //Load user profile from database using account id and email
    ParentChildModel userProfile = parentChildService.findOneByEmail(lowercaseEmailLogin);

   // com.doprocess.dppm.web.api.dto.User user = null;
    if (userProfile != null) {
      
      log.debug("User profile found from database {}" + userNameForAuthentication);
      
      List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();

      // TODO: currently hardcoded ROLE_ADMIN for all user
      grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));

      //Map user account profile from Database into user dto
     user = new ParentChildDTO();
      
      //user.setPasswordSalt(userProfile.getUser().getPasswordSalt());
     /* user.setPassword(userProfile.getLoginModel().getPassword());
      user.setUsername(userProfile.getUser().getEmail());
      user.setAuthorities(grantedAuthorities);
      user.setCustomerAccountName(userProfile.getCustomerAccount().getName());
      user.setPublicAccountId(userProfile.getCustomerAccount().getPublicAccountId());*/
      BeanUtils.copyProperties(userProfile, user);
      LoginDTO loginDTO = new LoginDTO();
      loginDTO.setEmail(userProfile.getRegistration().getLoginModel().getEmail());
      loginDTO.setPassword(userProfile.getRegistration().getLoginModel().getPassword());
      RegistrationDTO registrationDTO=new RegistrationDTO();
      registrationDTO.setId(userProfile.getRegistration().getId());
      registrationDTO.setName(userProfile.getRegistration().getName());
      registrationDTO.setSponsorId(userProfile.getRegistration().getSponsorId());
      registrationDTO.setLogin(loginDTO);
      user.setRegistration(registrationDTO);
      
    } else {
      log.error("Userprofile not found");
      throw new UsernameNotFoundException("User " + lowercaseEmailLogin + " was not found in the " + "database");
    }

    return  user;
  }


}
