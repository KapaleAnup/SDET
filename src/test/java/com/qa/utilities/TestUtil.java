package com.qa.utilities;

import java.util.ArrayList;

import com.Excel.Utility.Xls_Reader;

public class TestUtil {

static Xls_Reader reader;
	
	
	public static ArrayList<Object[]> getDataFromExcel()
	{
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		
		try {
			reader = new Xls_Reader("/Users/anupkapale/eclipse-workspace/SDET/src/test/java/com/qa/TestData/TDD.xlsx");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(int rownum=2; rownum <=reader.getRowCount("LoginData"); rownum++)
		{
			String username= reader.getCellData("LoginData", "username", rownum);
			String password= reader.getCellData("LoginData", "password", rownum);
			
			
			Object ob[]= {username, password };
			myData.add(ob);
		}
		
		return myData;

	}
}
