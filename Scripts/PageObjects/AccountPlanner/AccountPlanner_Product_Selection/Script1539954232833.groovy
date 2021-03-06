import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import java.util.Map as Map
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

TestData td = findTestData('TestData/AccountPlanner')

Map Iterator = CustomKeywords.'framework.Framework.GetTestDataMap'(td, DID.toString())

for (def Iteration : Iterator) {
    RunTest(Iteration.getValue())
}

def RunTest(Map DataMap) {
    CustomKeywords.'common.General.selectListBox'(findTestObject('Compass/AccountPlaner/ddb_product_selection'), DataMap.get(
            'PRODUCT_SELECTION'))

    CustomKeywords.'common.General.handleDialogBox'(findTestObject('Compass/Generic/DialogBox_PleaseConfirm'), DataMap.get(
            'DIALOG_BOX'), DataMap.get('DIALOG_MSG'), DataMap.get('DIALOG_ACTION'))

    CustomKeywords.'common.General.handleDialogBox'(findTestObject('Compass/Generic/DialogBox_Error'), 
		DataMap.get('ERROR_DIALOG'), DataMap.get('ERROR_MSG'), DataMap.get('ERROR_ACTION'))

    CustomKeywords.'common.General.selectListBox'(findTestObject('Compass/AccountPlaner/ddb_units'), 
		DataMap.get('UNITS'))
}

