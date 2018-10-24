import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.util.concurrent.TimeUnit

import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebDriver.Timeouts
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.FluentWait

import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.NotFoundException
import org.openqa.selenium.support.ui.Wait

WebUI.waitForElementNotVisible(null, 0, FailureHandling.STOP_ON_FAILURE)


/*public class WaitHelper{
	
	WebUI
	
	public static waitforprocessing(WebElement element,String seconds){
		WebElement element = WebUI
		WebDriver driver=DriverFactory.getWebDriver();
		FluentWait<WebDriver> wait = new FluentWait<>(driver)
				.withMessage("Waiting for... "+element)
				.withTimeout(seconds, TimeUnit.SECONDS)
				.pollingEvery(1, TimeUnit.SECONDS)
				.ignoring(NotFoundException.class)
		wait.until(ExpectedConditions.invisibilityOf(element))
	}
}*/