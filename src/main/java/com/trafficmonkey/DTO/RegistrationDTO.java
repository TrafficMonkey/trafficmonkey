package com.trafficmonkey.DTO;

import java.io.Serializable;
import java.util.Collection;
import java.util.Comparator;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import org.springframework.security.core.CredentialsContainer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.SpringSecurityCoreVersion;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.Assert;



public class RegistrationDTO implements UserDetails, CredentialsContainer {
	
	private static final long serialVersionUID = -740730286795643372L;
	private Long id;
	private String name;
	
	private String contact;
	
	private String panCardFlag;
	private String panCard;
	private String nominee;
	private String sponsorId;
	private String sponsorName;
	private String position;
	private String planType;
	private LoginDTO login;
	private String termsAndCondition;
	//private Long parentId;
	private ParentChildDTO  parentChild;
	
	 private Set<GrantedAuthority> authorities;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	
	
	public String getPanCardFlag() {
		return panCardFlag;
	}
	public void setPanCardFlag(String panCardFlag) {
		this.panCardFlag = panCardFlag;
	}
	public String getPanCard() {
		return panCard;
	}
	public void setPanCard(String panCard) {
		this.panCard = panCard;
	}
	public String getSponsorName() {
		return sponsorName;
	}
	public void setSponsorName(String sponsorName) {
		this.sponsorName = sponsorName;
	}
	public String getNominee() {
		return nominee;
	}
	public void setNominee(String nominee) {
		this.nominee = nominee;
	}
	public String getSponsorId() {
		return sponsorId;
	}
	public void setSponsorId(String sponsorId) {
		this.sponsorId = sponsorId;
	}
	
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getPlanType() {
		return planType;
	}
	public void setPlanType(String planType) {
		this.planType = planType;
	}
	
	public String getTermsAndCondition() {
		return termsAndCondition;
	}
	public void setTermsAndCondition(String termsAndCondition) {
		this.termsAndCondition = termsAndCondition;
	}
	public LoginDTO getLogin() {
		return login;
	}
	public void setLogin(LoginDTO login) {
		this.login = login;
	}
	@Override
	public void eraseCredentials() {
		 //password = null;
		login.setPassword(null);
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}
	
	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return login.getEmail();
	}
	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return login.getPassword();
	}
	
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	
	
	private static SortedSet<GrantedAuthority> sortAuthorities(
		      Collection<? extends GrantedAuthority> authorities) {
		    Assert.notNull(authorities, "Cannot pass a null GrantedAuthority collection");
		    // Ensure array iteration order is predictable (as per
		    // UserDetails.getAuthorities() contract and SEC-717)
		    SortedSet<GrantedAuthority> sortedAuthorities = new TreeSet<GrantedAuthority>(
		        new AuthorityComparator());

		    for (GrantedAuthority grantedAuthority : authorities) {
		      Assert.notNull(grantedAuthority, "GrantedAuthority list cannot contain any null elements");
		      sortedAuthorities.add(grantedAuthority);
		    }

		    return sortedAuthorities;
		  }
	
	  private static class AuthorityComparator implements Comparator<GrantedAuthority>, Serializable {

	    /** The Constant serialVersionUID. */
	    private static final long serialVersionUID = SpringSecurityCoreVersion.SERIAL_VERSION_UID;

	    /*
	     * (non-Javadoc)
	     * 
	     * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	     */
	    public int compare(GrantedAuthority g1, GrantedAuthority g2) {
	      // Neither should ever be null as each entry is checked before adding it to
	      // the set.
	      // If the authority is null, it is a custom authority and should precede
	      // others.
	      if (g2.getAuthority() == null) {
	        return -1;
	      }

	      if (g1.getAuthority() == null) {
	        return 1;
	      }

	      return g1.getAuthority().compareTo(g2.getAuthority());
	    }
	  }

	public ParentChildDTO getParentChild() {
		return parentChild;
	}
	public void setParentChild(ParentChildDTO parentChild) {
		this.parentChild = parentChild;
	}
}
