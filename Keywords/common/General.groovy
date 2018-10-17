package common

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
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

public class General {
	@Keyword
	def sleep(int timeInSec){
		Thread.sleep(timeInSec*1000);
	}
	@Keyword
	def selectListBox(TestObject xPath, value){
		WebUI.delay(5)
		WebUI.waitForElementClickable(xPath, 50, FailureHandling.STOP_ON_FAILURE)
		WebUI.click(xPath)
		//WebUI.waitForAngularLoad(50)
		TestObject to = new TestObject().addProperty('xpath', ConditionType.EQUALS,"//app-root/kendo-popup//kendo-list[@class='ng-star-inserted']//ul[@role='listbox']/li[contains(.,'"+value+"')]",true)
		WebUI.waitForElementClickable(to, 50, FailureHandling.STOP_ON_FAILURE)
		//WebUI.waitForAngularLoad(50)
		WebUI.click(to)
	}
	@Keyword
	def dialogBoxAction(dialogTextContains,action){
		//div[@class='k-content k-window-content k-dialog-content' and contains(.,'No PPGs found for selected criteria')]/following-sibling::kendo-dialog-actions/button[contains(.,"Ok")]
		TestObject TestObj  = new common.General().createObject("//body/kendo-dialog[2]//kendo-dialog-actions/button[@class='k-button k-primary ng-star-inserted']' and contains(.,'"+dialogTextContains+"')]/following-sibling::kendo-dialog-actions/button[contains(.,'"+action+"')]")
		if(WebUI.verifyElementPresent(TestObj, 20))
			WebUI.click(TestObj)
		//WebUI.waitForElementPresent(TestObj, 20, FailureHandling.STOP_ON_FAILURE)
	}
	@Keyword
	def createObject(xPath){
		return new TestObject().addProperty('xpath', ConditionType.EQUALS,xPath,true)
	}
	@Keyword
	def clickNavigation(navigation){
		WebUI.waitForElementPresent(findTestObject("Object Repository/Compass/Hamburg/btn_hamburg"), 20, FailureHandling.STOP_ON_FAILURE)
		WebUI.click(findTestObject("Object Repository/Compass/Hamburg/btn_hamburg"))
		TestObject TestObj  = new common.General().createObject("//div[@id='sidebar-wrapper']/ul[@class='sidebar-nav']//a[contains(., '"+navigation+"')]")
		WebUI.waitForElementPresent(TestObj, 20, FailureHandling.STOP_ON_FAILURE)
		WebUI.click(TestObj)
	}
}
