package api.utilities;



import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviderS {
	
	@DataProvider(name="Data")
	public String[][] getAllData() throws IOException
	{
		String path=System.getProperty("user.dir")+"//testData//testdata.xlsx";
		XLUtility xl=new XLUtility(path);
		
		int rownum=xl.getRowCount("USER");
		int colcount=xl.getCellCount("USER",1);
		
		String apidata[][]=new String[rownum][colcount];
		
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				apidata[i-1][j]=xl.getCellData("USER", i, j);
			}
		}
		return apidata;
	}
	

	@DataProvider(name="UserNames")
	public String[] getUserNames() throws IOException
	{
		String path=System.getProperty("user.dir")+"//testData//testdata.xlsx";
		XLUtility xl=new XLUtility(path);
		
		int rownum=xl.getRowCount("USER");
		
		String apidata[]=new String[rownum];
		for(int i=1;i<=rownum;i++)
		{
			apidata[i-1]=xl.getCellData("USER", i, 1);
		}

		return apidata;

	}
	
	
	@DataProvider(name="PetData")
	public String[][] getAllDataPet() throws IOException
	{
		String path=System.getProperty("user.dir")+"//testData//testdata.xlsx";
		XLUtility xl=new XLUtility(path);
		
		int rownum=xl.getRowCount("PET");
		int colcount=xl.getCellCount("PET",1);
		
		String apidata[][]=new String[rownum][colcount];
		
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				apidata[i-1][j]=xl.getCellData("PET", i, j);
			}
		}
		return apidata;
	}
	
	@DataProvider(name="PetId")
	public String[] getPetids() throws IOException
	{
		String path=System.getProperty("user.dir")+"//testData//testdata.xlsx";
		XLUtility xl=new XLUtility(path);
		
		int rownum=xl.getRowCount("PET");
		
		String apidata[]=new String[rownum];
		for(int i=1;i<=rownum;i++)
		{
			apidata[i-1]=xl.getCellData("PET", i, 0);
		}

		return apidata;

	}
	
	
	
	
	
}