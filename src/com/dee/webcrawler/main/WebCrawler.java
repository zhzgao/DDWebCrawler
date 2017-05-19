package com.dee.webcrawler.main;

import com.dee.webcrawler.bal.Anchor;
import com.dee.webcrawler.bal.Domain;
import com.dee.webcrawler.bal.WebPage;

public class WebCrawler {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			String URLstr = "http://www.imdb.com/title/tt";
            String URLNum = "114709";
            
			Domain dm = new Domain(URLstr + URLNum);
			Anchor ac = new Anchor(dm, URLstr + URLNum);
			WebPage wp = new WebPage(ac);
			
			System.out.println("Start getting web.");
			wp.loadDocumentFromWeb();
			String str;
            str = wp.getTextFrom();
			
			System.out.println(str.substring(12,str.indexOf(".")));
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		System.out.println("App exit.");
		
		
	}

}
