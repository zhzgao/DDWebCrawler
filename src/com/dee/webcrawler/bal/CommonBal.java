package com.dee.webcrawler.bal;

import java.sql.Timestamp;

public class CommonBal {

	public static Timestamp GetTimestamp(){
		java.util.Date date = new java.util.Date();
		return new Timestamp(date.getTime());
	}
}
