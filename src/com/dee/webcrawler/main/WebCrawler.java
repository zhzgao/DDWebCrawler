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
			_domain = new Domain(urlstr + urlnum);
			_anchor = new Anchor(_domain, urlstr + urlnum);
			_webpage = new WebPage(_anchor);
			_webpage.loadDocumentFromWeb();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String GetDirectorName(){
		String contents;
		contents = _webpage.getTextFrom();
		_nameDirector = contents.substring(12,contents.indexOf("."));
		return _nameDirector;
	}
	
	
	

}
