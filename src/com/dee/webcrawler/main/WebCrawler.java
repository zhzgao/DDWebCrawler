package com.dee.webcrawler.main;

import com.dee.webcrawler.bal.Anchor;
import com.dee.webcrawler.bal.Domain;
import com.dee.webcrawler.bal.WebPage;

public class WebCrawler {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Domain dm = new Domain("http://www.imdb.com/title/tt3530896/");
			Anchor ac = new Anchor(dm, "http://www.imdb.com/title/tt3530896/");
			WebPage wp = new WebPage(ac);
			
			System.out.println("Start getting web.");
			wp.loadDocumentFromWeb();
			System.out.println(wp.getTextFrom());
			
			//Elements docas = _document.select("div");
			
			//for(Element e : docas){
			//	System.out.println(e.attr("class"));
			//}
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		System.out.println("App exit.");
		
		
	}

}
