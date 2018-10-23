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

TestData td = findTestData('TestData/AccountPlanner_ProductCost')

Map Iterator = CustomKeywords.'framework.Framework.GetTestDataMap'(td, DID.toString())

for (def Iteration : Iterator) {
    RunTest(Iteration.getValue())
}

def RunTest(Map DataMap) {
    CustomKeywords.'common.General.buttonClick'(findTestObject('Compass/AccountPlaner/btn_add_new'), DataMap.get('ADD_NEW'))

    CustomKeywords.'common.AccountPlanner_Tabel.EnterValueInTableCell'(findTestObject('Compass/AccountPlaner/tbl_product_costing'), 
        DataMap.get('Row_No'), 'PPG/Group', DataMap.get('PPG_Group'))

    CustomKeywords.'common.AccountPlanner_Tabel.EnterDateInTableCell'(findTestObject('Compass/AccountPlaner/tbl_product_costing'), 
        DataMap.get('Row_No'), 'Start Date', DataMap.get('Start_Date'))

    CustomKeywords.'common.AccountPlanner_Tabel.EnterDateInTableCell'(findTestObject('Compass/AccountPlaner/tbl_product_costing'), 
        DataMap.get('Row_No'), 'End Date', DataMap.get('End_Date'))

    CustomKeywords.'common.AccountPlanner_Tabel.EnterValueInTableCell'(findTestObject('Compass/AccountPlaner/tbl_product_costing'), 
        DataMap.get('Row_No'), 'EDLP Rate/Case', DataMap.get('EDLP_Rate_Case'))

    CustomKeywords.'common.AccountPlanner_Tabel.EnterValueInTableCell'(findTestObject('Compass/AccountPlaner/tbl_product_costing'), 
        DataMap.get('Row_No'), 'EDLP Rate/Unit', DataMap.get('EDLP_Rate_Unit'))

    CustomKeywords.'common.AccountPlanner_Tabel.EnterValueInTableCell'(findTestObject('Compass/AccountPlaner/tbl_product_costing'), 
        DataMap.get('Row_No'), 'Spend Rate EDLP %', DataMap.get('Spend_Rate EDLP %'))

    CustomKeywords.'common.AccountPlanner_Tabel.EnterValueInTableCell'(findTestObject('Compass/AccountPlaner/tbl_product_costing'), 
        DataMap.get('Row_No'), 'Unit Cost Net EDLP', DataMap.get('UnitCostNet_EDLP'))

    CustomKeywords.'common.AccountPlanner_Tabel.EnterValueInTableCell'(findTestObject('Compass/AccountPlaner/tbl_product_costing'), 
        DataMap.get('Row_No'), 'Unit Cost Net Allowances', DataMap.get('Unit_Cost_Net_Allowances'))

    CustomKeywords.'common.AccountPlanner_Tabel.EnterValueInTableCell'(findTestObject('Compass/AccountPlaner/tbl_product_costing'), 
        DataMap.get('Row_No'), 'Non Promo SRP', DataMap.get('Non_Promo_SRP'))

    CustomKeywords.'common.AccountPlanner_Tabel.EnterValueInTableCell'(findTestObject('Compass/AccountPlaner/tbl_product_costing'), 
        DataMap.get('Row_No'), 'Retailer Margin (Base %)', DataMap.get('Retailer_Margin_(Base %)'))

    CustomKeywords.'common.AccountPlanner_Tabel.SelectValueInTableCell'(findTestObject('Compass/AccountPlaner/tbl_product_costing'), 
        DataMap.get('Row_No'), 'Spend Method', DataMap.get('Spend_Method'))

    CustomKeywords.'common.General.buttonClick'(findTestObject('Compass/AccountPlaner/btn_apply_edlp'), DataMap.get('BTN_APPLY_EDLP'))
}

