import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.junit.After as After
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

boolean Test = WebUI.waitForElementVisible(findTestObject('Object Repository/Compass/WaitFor/Spinner'), 40, FailureHandling.STOP_ON_FAILURE)

not_run: WebUI.verifyElementPresent(findTestObject('Compass/Generic/DialogBox_PleaseConfirm'), 5)

WebUI.callTestCase(findTestCase('PageObjects/AccountPlanner/AccountPlanner_Product_Selection'), [('DID') : '1'], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('PageObjects/AccountPlanner/AccountPlaner_ProductCosting_Table'), [('DID') : '1'], FailureHandling.STOP_ON_FAILURE)

