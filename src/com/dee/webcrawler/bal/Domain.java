package com.dee.webcrawler.bal;

import java.sql.Timestamp;

public class Domain {
	
	private String _domainHash;
	private String _domainUrl;
	private boolean _activated;
	private Timestamp _modified;
	private Timestamp _created;
	
	public Domain(String domainUrl) throws Exception{
		_domainHash = Hasher.toSha256(domainUrl);
		_domainUrl = domainUrl;
		_activated = true;
		_modified = CommonBal.GetTimestamp();
		_created = CommonBal.GetTimestamp();
	}
	
	public Domain(String domainHash, String domainUrl){
		_domainHash = domainHash;
		_domainUrl = domainUrl;
	}
	
	/*
	 * Used when populating from database
	 */
	public Domain(String domainHash, String domainUrl, boolean activated, Timestamp modified, Timestamp created){
		_domainHash = domainHash;
		_domainUrl = domainUrl;
		_activated = activated;
		_modified = modified;
		_created = created;
	}
	
	
	public String GetDomainHash(){
		return _domainHash;
	}
	
	public String GetDomainUrl(){
		return _domainUrl;
	}
	
	public boolean IsActivated(){
		return _activated;
	}
	
	public Timestamp GetModified(){
		return _modified;
	}
	
	public Timestamp GetCreated(){
		return _created;
	}
	
	
	
}
