package framework

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseBinding
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import internal.GlobalVariable

public class Framework {

	@Keyword
	def CallPageObject(TestCase testCase,TestData testData, String DID){
		//Open the PageObject excel file
		//Iterate over it find the occurence of DID and put it in Map with mapId,ArrayList<List>
		//Use the Map iterator and call the below mathod for so many times
		//Open the PageObject excel file

		WebUI.callTestCase(testCase, , FailureHandling.STOP_ON_FAILURE)
	}

	@Keyword
	def GetTestDataMap(TestData td, String dataId){
		def mp = [:]
		def mp1 = [:]
		def arl1 = new ArrayList<String>()
		def tableID = ""
		def indexI = 0
		def rowNumbers = td.getRowNumbers()
		def didValue = dataId.toString()
		def val1 = new ArrayList<String>()
		def theValue = ""
		for(int i=1;i<=rowNumbers;i++){
			if(td.getValue("ID", i) != ""){
				tableID = td.getValue("ID", i)
				theValue = ""
				indexI++
				mp1 = [:]
			}
			if(tableID.equalsIgnoreCase(didValue.toString())){
				String[] cols = td.getColumnNames()

				for(int col=1;col<cols.length;col++) {
					if(td.getValue(cols[col], i).toString() != "") {
						if(mp1.containsKey(cols[col])){
							theValue = mp1.get(cols[col])+GlobalVariable.multivalueseperator+td.getValue(cols[col], i).toString()
						}
						else
							theValue =  td.getValue(cols[col], i).toString()
						println "theValue :"+theValue
						theValue = evalString(theValue)
						mp1.put(cols[col],theValue)
					}
				}
				mp.put(indexI, mp1)
			}
		}
		return mp
	}
	def evalString(String data){
		if(data.contains("{")){
			if(data.contains("{store.")){
				String[] data1 = data.split("\\.")
				def varname = data1[1].substring(0, (data1[1].length()-1))
				data = varname
			}
			if(data.contains("{var.")){
				String[] data1 = data.split("\\.")
				def varname = data1[1].substring(0, (data1[1].length()-1))
				println "varname :"+varname
				data = GetValue(varname)
			}
			if(data.contains("{date.")){
				String regString = "\\{(\\s*?.*?)*?\\}";
				Pattern pattern = Pattern.compile(regString)
				Matcher matcher = pattern.matcher(data)
				def data1 = data
				while (matcher.find()){
					def theString = matcher.group(0).substring(1, (matcher.group(0).length()-1)).split("\\.")
					def format
					if(theString.length > 2){
						format = theString[2]
					}
					else if(theString.length == 2){
						format = GlobalVariable.defaultdateformat
					}
					data1 = data1.replace(matcher.group(0), DateFormater(theString[1],format))
				}
				data = data1
			}
		}
		return data
	}
	def DateFormater(String days,String format){
		SimpleDateFormat sdf = new SimpleDateFormat(format)
		Calendar c = Calendar.getInstance()
		//Number of Days to add
		c.add(Calendar.DAY_OF_MONTH, Integer.valueOf(days));
		//Date after adding the days to the given date
		String newDate = sdf.format(c.getTime());
		//Displaying the new Date after addition of Days
		return newDate
	}
	@Keyword
	def GetValue(String data1){
		//check for the text file with data
		//if exists read the content and
		//return the contents
		//data files location /TestData/

		String outputDir = System.getProperty("user.dir")+"\\Data Files\\Outputs"
		if(!new File(outputDir+"\\"+data1+".txt").exists()){
			return data1
		}
		FileReader fileReader =	new FileReader(outputDir+"\\"+data1+".txt")
		//FileReader fileReader =	new FileReader() //"C:\\Users\\DELL\\Katalon Studio\\Kraft_Sample\\Data Files\\Outputs\data1.txt")
		BufferedReader bufferedReader =
				new BufferedReader(fileReader);
		def str = bufferedReader.readLine()
		println "str :"+str
		return str
	}
	@Keyword
	def SetValue(String variable,String value){
		BufferedWriter out = new BufferedWriter(new FileWriter(System.getProperty("user.dir")+"\\Data Files\\Outputs\\" + variable +".txt"));
		out.write(value);
		out.close();
	}
}
