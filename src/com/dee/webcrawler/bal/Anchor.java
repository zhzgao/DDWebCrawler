package com.dee.webcrawler.bal;

import java.sql.Timestamp;

public class Anchor {

	private Domain _domain;
	private String _anchorHash;
	private String _anchorUrl;
	private int _scanStatus;
	private boolean _activated;
	private Timestamp _modified;
	private Timestamp _created;
	
	public Anchor(Domain domain, String anchorUrl) throws Exception{
		_domain = domain;
		_anchorHash = Hasher.toSha256(anchorUrl);
		_anchorUrl = anchorUrl;
		_scanStatus = 0;
		_activated = true;
		_modified = CommonBal.GetTimestamp();
		_created = CommonBal.GetTimestamp();
	}
	
	public Anchor(Domain domain, String anchorHash, String anchorUrl){
		_domain = domain;
		_anchorHash = anchorHash;
		_anchorUrl = anchorUrl;
	}
	
	
	/*
	 * 
	 */
	public Anchor(Domain domain, String anchorHash, String anchorUrl, int scanStatus, boolean activated, Timestamp modified, Timestamp created){
		_domain = domain;
		_anchorHash = anchorHash;
		_anchorUrl = anchorUrl;
		_scanStatus = scanStatus;
		_activated = activated;
		_modified = modified;
		_created = created;
	}
	
	public Domain GetDomain(){
		return _domain;
	}
	
	public String GetAnchorHash(){
		return _anchorHash;
	}
	
	public String GetAnchorUrl(){
		return _anchorUrl;
	}
	
	public int GetScanStatus(){
		return _scanStatus;
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
