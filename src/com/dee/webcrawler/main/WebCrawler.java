package com.dee.webcrawler.main;

import com.dee.webcrawler.bal.Anchor;
import com.dee.webcrawler.bal.Domain;
import com.dee.webcrawler.bal.WebPage;

public class WebCrawler {

	private Domain _domain;
	private Anchor _anchor;
	private WebPage _webpage;
	private String _nameDirector;
	
	public WebCrawler(){
		
	}
	
	public void UpdatePage(String urlstr, String urlnum){
		try {
			System.out.println("[Tracing]Crawler page updating...");
			_domain = new Domain(urlstr + urlnum);
			System.out.println("[Tracing]Domain has been created to: " + _domain.GetDomainUrl());
			_anchor = new Anchor(_domain, urlstr + urlnum);
			System.out.println("[Tracing]Anchor has been created to: " + _anchor.GetAnchorUrl());
			_webpage = new WebPage(_anchor);
			System.out.println("[Tracing]WebPage has been created.");
			_webpage.loadDocumentFromWeb();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String GetDirectorName(){
		String contents;
		contents = _webpage.getTextFrom();
		
		if(contents!=null){
			_nameDirector = contents.substring(12,contents.indexOf("."));
		}else{
			_nameDirector = "Error";
		}
		
		return _nameDirector;
	}
	
	
	

}
