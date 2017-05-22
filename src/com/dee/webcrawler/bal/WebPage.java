package com.dee.webcrawler.bal;

import java.io.IOException;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class WebPage {

	private Anchor _anchor;
	private String _webPageHash;
	private int _anchorParseStatus;
	private int _emailParseStatus;
	private Document _document;
	
	private int _socketExpCounter;
	
	public WebPage(Anchor anchor) throws Exception{
		_anchor = anchor;
		_webPageHash = Hasher.toSha256(anchor.GetAnchorHash() + CommonBal.GetTimestamp().toString());
		_anchorParseStatus = 0;
		_emailParseStatus = 0;
		
		_socketExpCounter = 0;
	}
	
	public String GetWebPageHash(){
		return _webPageHash;
	}
	
	public int GetAnchorParseStatus(){
		return _anchorParseStatus;
	}
	
	public int GetEmailParseStatus(){
		return _emailParseStatus;
	}
	
	public Document GetDocument(){
		return _document;
	}
	
	/*
	 * Use Jsoup to get html
	 */
	public void loadDocumentFromWeb(){
		
		try {
			try{
				_document = Jsoup.connect(_anchor.GetAnchorUrl()).get();
			}catch (SocketException se){ //handle socket exception, may cuz caused by TCP reset
				_socketExpCounter++;
				System.out.println("\nSocketException! Times: " + _socketExpCounter);
				se.printStackTrace();
				try {
					Thread.sleep(10000);
					
					loadDocumentFromWeb();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		} catch (IOException e) {
			Logger.getLogger(WebPage.class.getName()).log(Level.SEVERE, null, e);
		} 
	}
	
	public String getTextFrom(){
		Elements docas = _document.select("meta");
		String targetText = null;
		
		//System.out.println("Elements scaning!");
		for(Element e : docas){
			if(e.attr("name").toString().equals("description")){
				targetText = e.attr("content").toString();
			}
		}
		
		return targetText;
	}
	
}
