import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
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

TestData td = findTestData('TestData/Login')

Map Iterator = CustomKeywords.'framework.Framework.GetTestDataMap'(td, DID.toString())

for(Iteration in Iterator){
	RunTest(Iteration.getValue())
}

def RunTest(Map DataMap) {
	
	CustomKeywords.'framework.Framework.SetValue'(DataMap.get('ROLE'), "testRole1")
	
	/*println CustomKeywords.'framework.Framework.GetValue'(DataMap.get('RECEP'))
	
    CustomKeywords.'com.kraft.compass.common.General.sleep'(10)
	
    CustomKeywords.'com.kraft.compass.common.RobotX.RoboKeyPress'()

    CustomKeywords.'com.kraft.compass.common.RobotX.RoboKeyPressSpecial'(DataMap.get('KHPG_PPG'))
	
    CustomKeywords.'com.kraft.compass.common.RobotX.RoboKeyPress'(password)

    CustomKeywords.'com.kraft.compass.common.RobotX.RoboKeyPressSpecial'('ENTER')*/
	
}

