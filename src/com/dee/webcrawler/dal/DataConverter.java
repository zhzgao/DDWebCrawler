package com.dee.webcrawler.dal;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class DataConverter {

	private String _dataFileDir;
	private BufferedReader _brSourceData;
	private BufferedWriter _bwNewData;
	
	
	public DataConverter(String dir){
		_dataFileDir = dir; //initialize the source data file directory
	}
	
	public void ConvertToCSV(String saveName){
		
		try{
			
			_brSourceData = new BufferedReader(new FileReader(_dataFileDir)); //read source data file into buffer
			_bwNewData = new BufferedWriter(new FileWriter(saveName + ".csv")); //create new csv file and handled in a buffer
			String line; //used for handling a line from source data buffer
			while((line = _brSourceData.readLine()) != null){ //read a line if not empty from source data buffer
				String[] values = line.split("\\t", -1); //split the line by tab and store each element into an array
				_bwNewData.write(values[0] + "," + values[1] + "," + values[2] + "\n"); //write values in above array into the new csv file
				
			}
			
			_brSourceData.close(); //close buffer
			_bwNewData.close();
			
		}catch(Exception e){
			System.out.println(e.toString());
		}
	}
}
