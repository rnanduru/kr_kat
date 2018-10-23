import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

not_run: CustomKeywords.'common.AccountPlanner_Tabel.EnterValueInTableCell'(findTestObject('Compass/AccountPlaner/tbl_product_costing'), 
    1, 'EDLP Rate/Case', '567')

not_run: CustomKeywords.'common.AccountPlanner_Tabel.EnterValueInTableCell'(findTestObject('Compass/AccountPlaner/tbl_product_costing'), 
    2, 'EDLP Rate/Case', '234')

not_run: CustomKeywords.'common.AccountPlanner_Tabel.EnterDateInTableCell'(findTestObject('Compass/AccountPlaner/tbl_product_costing'), 
    1, 'Start Date', 'Nov/23/2018')

CustomKeywords.'common.AccountPlanner_Tabel.SelectValueInTableCell'(findTestObject('Compass/AccountPlaner/tbl_product_costing'), 
    '1', 'Spend Method', '$ BB Per Unit')

