package common

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.text.SimpleDateFormat

import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

public class General {
	@Keyword
	def sleep(int timeInSec){
		Thread.sleep(timeInSec*1000);
	}
	@Keyword
	def selectListBox(TestObject xPath, value){
		if((value.toString() == "") || (value.toString() == "<null>") || (value.toString() == "null"))
			return
			
		WebUI.waitForElementNotVisible(findTestObject('Object Repository/Compass/WaitFor/Spinner'), GlobalVariable.spinnerwaittime, FailureHandling.STOP_ON_FAILURE)
		
		WebUI.waitForElementNotVisible(findTestObject('Object Repository/Compass/WaitFor/PageLoading'), GlobalVariable.spinnerwaittime, FailureHandling.STOP_ON_FAILURE)
		
		WebUI.waitForElementClickable(xPath, 40, FailureHandling.STOP_ON_FAILURE)
		
		WebUI.click(xPath)
		
		TestObject to = new TestObject().addProperty('xpath', ConditionType.EQUALS,"//app-root/kendo-popup//kendo-list[@class='ng-star-inserted']//ul[@role='listbox']/li[contains(.,'"+value+"')]",true)
		
		WebUI.waitForElementClickable(to, 40, FailureHandling.STOP_ON_FAILURE)
		
		WebUI.waitForElementNotVisible(findTestObject('Object Repository/Compass/WaitFor/PageLoading'), 100, FailureHandling.STOP_ON_FAILURE)
		
		WebUI.click(to)
	}
	@Keyword
	def dialogBoxAction(dialogTextContains,action){
		//div[@class='k-content k-window-content k-dialog-content' and contains(.,'No PPGs found for selected criteria')]/following-sibling::kendo-dialog-actions/button[contains(.,"Ok")]
		TestObject TestObj  = new common.General().createObject("//body/kendo-dialog[2]//kendo-dialog-actions/button[@class='k-button k-primary ng-star-inserted']' and contains(.,'"+dialogTextContains+"')]/following-sibling::kendo-dialog-actions/button[contains(.,'"+action+"')]")
		if(WebUI.verifyElementPresent(TestObj, 30))
			WebUI.click(TestObj)
		//WebUI.waitForElementPresent(TestObj, 20, FailureHandling.STOP_ON_FAILURE)
	}
	@Keyword
	def createObject(xPath){
		return new TestObject().addProperty('xpath', ConditionType.EQUALS,xPath,true)
	}
	@Keyword
	def clickNavigation(navigation){
		WebUI.waitForElementPresent(findTestObject("Object Repository/Compass/Hamburg/btn_hamburg"), 60, FailureHandling.STOP_ON_FAILURE)
		WebUI.click(findTestObject("Object Repository/Compass/Hamburg/btn_hamburg"))
		TestObject TestObj  = new common.General().createObject("//div[@id='sidebar-wrapper']/ul[@class='sidebar-nav']//a[contains(., '"+navigation+"')]")
		WebUI.waitForElementPresent(TestObj, 60, FailureHandling.STOP_ON_FAILURE)
		WebUI.click(TestObj)
	}
	@Keyword
	static runJS (TestObject to, String jsAction, int timeout) {
		WebUI.waitForElementVisible(to, timeout)
		try {

			WebDriver driver = DriverFactory.getWebDriver()
			WebElement element = WebUiCommonHelper.findWebElement(to, timeout)
			JavascriptExecutor executor = ((driver) as JavascriptExecutor)
			def oPut = executor.executeScript(''+jsAction+'', element) //arguments[0].click()
			return oPut
		}
		catch (Exception e) {
			e.printStackTrace()
		}
	}
	@Keyword
	def buttonClick(TestObject to,String data){
		if((!data.equalsIgnoreCase(""))||(!data.equalsIgnoreCase("<null>"))) {
			//WebUI.waitForElementClickable(to,40)
			WebUI.delay(10)
			WebUI.click(to)
		}
	}
	@Keyword
	def handleDialogBox(TestObject To,String idDisplayed,String verifyText,String buttonToClick) {
		TestObject tb = To

		def dialog_pls_confirm = tb.findPropertyValue("xpath")

		def tb1 = ""

		ArrayList<WebElement> wes = WebUiCommonHelper.findWebElements(tb, 20)

		println "For loop"

		int index = 1

		for(WebElement we:wes) {
			if(we.isDisplayed()){
				tb1 = "("+dialog_pls_confirm+")["+index+"]"
				break;
			}
			index++
		}

		if((tb1.equalsIgnoreCase("")) && (idDisplayed.equalsIgnoreCase("true")))
			KeywordUtil.markFailedAndStop("Dialog box is not displayed")
		else if((!tb1.equalsIgnoreCase("")) && (idDisplayed.equalsIgnoreCase("false")))
			KeywordUtil.markFailedAndStop("Dialog box is displayed")
		//verify the text message

		if(tb1.equalsIgnoreCase(""))
			return

		def messagePath = tb1+"/parent::kendo-dialog-titlebar/following-sibling::div[@class='k-content k-window-content k-dialog-content']"

		TestObject messObj = new TestObject().addProperty("xpath",ConditionType.EQUALS,messagePath)

		if(!verifyText.equalsIgnoreCase(""))
			WebUI.verifyElementAttributeValue(messObj, "text", verifyText, 10, FailureHandling.STOP_ON_FAILURE)

		def buttonPath = tb1+"/parent::kendo-dialog-titlebar/following-sibling::kendo-dialog-actions//button[contains(.,"+buttonToClick+")]"

		TestObject buttonObj = new TestObject().addProperty("xpath",ConditionType.EQUALS,buttonPath)

		WebUI.click(buttonObj)
	}
}
