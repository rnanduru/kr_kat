package common

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.text.SimpleDateFormat
import framework.Framework

import org.junit.After
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

public class AccountPlanner_Tabel {

	def BuildTableColumns(TestObject tb){
		//get the columns and indexs into a Map
		def baseXPath = tb.findPropertyValue("xpath")+"/div/div"
		tb.addProperty("xpath", ConditionType.EQUALS, baseXPath) //"//kendo-tabstrip/div[1]/product-costing[@class='ng-star-inserted']/div[1]/div[@class='no-right header-panel']/div/div")
		ArrayList<WebElement> wes = WebUiCommonHelper.findWebElements(tb, 0)
		def columnsIndexes = [:]
		int index = 0
		def column = ""
		TestObject twe;

		WebDriver driver = DriverFactory.getWebDriver()

		WebElement element;

		JavascriptExecutor executor;

		for(WebElement we:wes){
			twe = tb.addProperty("xpath",ConditionType.EQUALS,baseXPath+"["+String.valueOf((Integer.valueOf(index)+1))+"]")
			element = WebUiCommonHelper.findWebElement(twe, 10)
			executor = ((driver) as JavascriptExecutor)
			column = executor.executeScript('return arguments[0].innerText;', element).toString()
			//column = new General().runJS(twe,"return arguments[0].innerText;", 20).toString() //we.getAttribute("innerText").trim()//we.getText().trim()
			if((column.equalsIgnoreCase(""))||(column.equalsIgnoreCase(" ")))
				column = "column"+index
			columnsIndexes.put(column,index)
			index++
		}
		return columnsIndexes
	}
	@Keyword
	def EnterValueInTableCell(TestObject tb, String rowNo,String column,String data){
		
		if((data.equalsIgnoreCase(""))||(data.equalsIgnoreCase("<null>")))
			return
		
		println "In COlumn "+column
			
		def columns = [:]

		columns = BuildTableColumns(tb)

		def colNo = Integer.valueOf(columns.get(column.toString()))+1
		
		if((rowNo.equalsIgnoreCase(""))||(rowNo.equalsIgnoreCase("<null>"))){
			def rowCount = tb.findPropertyValue("xpath")+"/following-sibling::div/div/div"
			tb.addProperty("xpath", ConditionType.EQUALS, rowCount) //"//kendo-tabstrip/div[1]/product-costing[@class='ng-star-inserted']/div[1]/div[@class='no-right header-panel']/div/div")
			ArrayList<WebElement> wes = WebUiCommonHelper.findWebElements(tb, 0)
			rowNo = wes.size
		}

		TestObject tbd = new General().createObject(tb.findPropertyValue('xpath')+"/following-sibling::div/div/div["+rowNo+"]/div/div["+String.valueOf(colNo)+"]//input")
		
		WebUI.click(tbd)

		WebUI.setText(tbd, data)
	}
	@Keyword
	def EnterDateInTableCell(TestObject tb,String rowNo,String column,String date){
		
		if((date.equalsIgnoreCase(""))||(date.equalsIgnoreCase("<null>")))
			return
		
		println "In COlumn "+column
			
		def columns = [:]

		columns = BuildTableColumns(tb)

		def colNo = Integer.valueOf(columns.get(column.toString()))+1
		
		if((rowNo.equalsIgnoreCase(""))||(rowNo.equalsIgnoreCase("<null>"))){
			def rowCount = tb.findPropertyValue("xpath")+"/following-sibling::div/div/div"
			tb.addProperty("xpath", ConditionType.EQUALS, rowCount) //"//kendo-tabstrip/div[1]/product-costing[@class='ng-star-inserted']/div[1]/div[@class='no-right header-panel']/div/div")
			ArrayList<WebElement> wes = WebUiCommonHelper.findWebElements(tb, 0)
			rowNo = wes.size
		}
		
		TestObject tbd = new General().createObject(tb.findPropertyValue('xpath')+"/following-sibling::div/div/div["+rowNo+"]/div/div["+String.valueOf(colNo)+"]//span[@class='k-icon k-i-calendar']")

		WebUI.click(tbd)

		String[] dates = date.split("/")

		def monthEx = dates[0]

		String monthString = """//kendo-calendar//span[(text() = '
                    ${monthEx}
                ' or . = '
                    ${monthEx}
                ')]"""
		
		WebUI.delay(1)
		
		TestObject calMonth = new General().createObject(monthString)

		WebUI.click(calMonth)

		WebUI.delay(4)

		println "Clicked Month"

		def monthName = new Framework().FormatDate(date, "MMM/dd/yyyy", "EEEE, MMMM dd, yyyy")

		TestObject da = new General().createObject("//kendo-calendar//table/tbody/tr/td[contains(@title, '${monthName}')]/span")

		WebUI.click(da)

	}
	@Keyword
	def SelectValueInTableCell(TestObject tb,String rowNo,String column,String data){

		def columns = [:]

		columns = BuildTableColumns(tb)

		def colNo = Integer.valueOf(columns.get(column.toString()))+1
		
		if((rowNo.equalsIgnoreCase(""))||(rowNo.equalsIgnoreCase("<null>"))){
			def rowCount = tb.findPropertyValue("xpath")+"/following-sibling::div/div/div"
			tb.addProperty("xpath", ConditionType.EQUALS, rowCount) //"//kendo-tabstrip/div[1]/product-costing[@class='ng-star-inserted']/div[1]/div[@class='no-right header-panel']/div/div")
			ArrayList<WebElement> wes = WebUiCommonHelper.findWebElements(tb, 0)
			rowNo = wes.size
		}
		
		TestObject tbd = new General().createObject(tb.findPropertyValue('xpath')+"/following-sibling::div/div/div["+rowNo+"]/div/div["+String.valueOf(colNo)+"]//span[@class='k-i-arrow-s k-icon']")

		new General().selectListBox(tbd, data)
	}
	@Keyword
	def ActionOnTableCell(TestObject tb,int rowNo,String column,String action){



	}
}
