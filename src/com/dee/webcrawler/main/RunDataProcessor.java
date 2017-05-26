package com.dee.webcrawler.main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class RunDataProcessor {

	public static void main(String[] args) {
		
		
		int jobCounter = 0;
		String contents, nameDirector;
		
		try{
			
			BufferedReader SourceData = new BufferedReader(new FileReader("data/rogresult-all.csv"));
			BufferedWriter NewData = new BufferedWriter(new FileWriter("data/directorResult.csv"));
			String temp = null;
			SourceData.readLine();//skip first line
	        while ((temp = SourceData.readLine()) != null){
	        	System.out.println("\n\n======= Job " + (jobCounter+1) + " processing =======");
                String[] Elements = temp.split(",");
                contents = Elements[1];
                
                int Judge = contents.indexOf("With");
                System.out.println("[Tracing]Judge value <indexOf(\"With\")>: " + Judge);
                if(Judge == -1){
                	System.out.println("[Tracing]Judge is -1, Substring of contents from 12 to " + (contents.lastIndexOf("A")-2));
                	nameDirector = "*" + contents.substring(12, contents.lastIndexOf("A")-2);
                }else if(contents.indexOf("With")!=0){
                	System.out.println("[Tracing]Judge is not 0, Substring of contents begin with " + (contents.indexOf("y")+2));
                	contents = contents.substring(contents.indexOf("y")+2);
                	System.out.println("[Tracing]Judge is not 0, Substring of contents from 0 to " + (contents.indexOf("With")-3));
                	nameDirector = contents.substring(0, contents.indexOf("With")-3);
                }else{
                	nameDirector = "No director";
                }

                NewData.write(Elements[1] + ',' + nameDirector + "\n");
                jobCounter++;
                System.out.println("[Tracing]Job " + jobCounter + " is done!");
	        }
	        SourceData.close();
	        NewData.close();
	        System.out.println("[Crawler]All works finished!");
	        
		}catch(IOException e){
			
		}

	}

}
