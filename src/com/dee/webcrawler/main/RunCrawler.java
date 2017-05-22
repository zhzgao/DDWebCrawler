package com.dee.webcrawler.main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class RunCrawler {

	public static void main(String[] args) {

		WebCrawler myCrawler = new WebCrawler();
		int jobCounter = 0;
		
		try {
			BufferedReader SourceData = new BufferedReader(new FileReader("data/samplelinks.csv"));
			BufferedWriter NewData = new BufferedWriter(new FileWriter("data/result.csv"));
			String temp = null;
			SourceData.readLine();//skip first line
	        while ((temp = SourceData.readLine()) != null){
                String[] Elments = temp.split(",");
                String URLstr = "http://www.imdb.com/title/tt";
                String URLNum = Elments[1];
                myCrawler.UpdatePage(URLstr, URLNum);
                String str;
                str = myCrawler.GetDirectorName();
                NewData.write(Elments[1] + ',' + str + "\n");
                jobCounter++;
                System.out.println("[Tracing]Job " + jobCounter + " is done!");
	        }
	        SourceData.close();
	        NewData.close();
	        System.out.println("[Crawler]All works finished!");
	        
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
        
        
	}

}
