
/**
 * This class is generated automatically by Katalon Studio and should not be modified or deleted.
 */

import java.lang.String

import com.kms.katalon.core.testobject.TestObject

import java.lang.CharSequence

import com.kms.katalon.core.testcase.TestCase

import com.kms.katalon.core.testdata.TestData


def static "common.RobotX.RoboKeyPress"(
    	String data	) {
    (new common.RobotX()).RoboKeyPress(
        	data)
}

def static "common.RobotX.WebUISendKeys"(
    	TestObject t	
     , 	String data	) {
    (new common.RobotX()).WebUISendKeys(
        	t
         , 	data)
}

def static "common.RobotX.RoboKeyPressSpecial"(
    	String data	) {
    (new common.RobotX()).RoboKeyPressSpecial(
        	data)
}

def static "common.RobotX.type"(
    	CharSequence characters	) {
    (new common.RobotX()).type(
        	characters)
}

def static "common.General.sleep"(
    	int timeInSec	) {
    (new common.General()).sleep(
        	timeInSec)
}

def static "common.General.selectListBox"(
    	TestObject xPath	
     , 	Object value	) {
    (new common.General()).selectListBox(
        	xPath
         , 	value)
}

def static "common.General.dialogBoxAction"(
    	Object dialogTextContains	
     , 	Object action	) {
    (new common.General()).dialogBoxAction(
        	dialogTextContains
         , 	action)
}

def static "common.General.createObject"(
    	Object xPath	) {
    (new common.General()).createObject(
        	xPath)
}

def static "common.General.clickNavigation"(
    	Object navigation	) {
    (new common.General()).clickNavigation(
        	navigation)
}

def static "common.General.runJS"(
    	TestObject to	
     , 	String jsAction	
     , 	int timeout	) {
    (new common.General()).runJS(
        	to
         , 	jsAction
         , 	timeout)
}

def static "common.General.buttonClick"(
    	TestObject to	
     , 	String data	) {
    (new common.General()).buttonClick(
        	to
         , 	data)
}

def static "common.General.handleDialogBox"(
    	TestObject To	
     , 	String idDisplayed	
     , 	String verifyText	
     , 	String buttonToClick	) {
    (new common.General()).handleDialogBox(
        	To
         , 	idDisplayed
         , 	verifyText
         , 	buttonToClick)
}

def static "common.AccountPlanner_Tabel.EnterValueInTableCell"(
    	TestObject tb	
     , 	String rowNo	
     , 	String column	
     , 	String data	) {
    (new common.AccountPlanner_Tabel()).EnterValueInTableCell(
        	tb
         , 	rowNo
         , 	column
         , 	data)
}

def static "common.AccountPlanner_Tabel.EnterDateInTableCell"(
    	TestObject tb	
     , 	String rowNo	
     , 	String column	
     , 	String date	) {
    (new common.AccountPlanner_Tabel()).EnterDateInTableCell(
        	tb
         , 	rowNo
         , 	column
         , 	date)
}

def static "common.AccountPlanner_Tabel.SelectValueInTableCell"(
    	TestObject tb	
     , 	String rowNo	
     , 	String column	
     , 	String data	) {
    (new common.AccountPlanner_Tabel()).SelectValueInTableCell(
        	tb
         , 	rowNo
         , 	column
         , 	data)
}

def static "common.AccountPlanner_Tabel.ActionOnTableCell"(
    	TestObject tb	
     , 	int rowNo	
     , 	String column	
     , 	String action	) {
    (new common.AccountPlanner_Tabel()).ActionOnTableCell(
        	tb
         , 	rowNo
         , 	column
         , 	action)
}

def static "framework.Framework.CallPageObject"(
    	TestCase testCase	
     , 	TestData testData	
     , 	String DID	) {
    (new framework.Framework()).CallPageObject(
        	testCase
         , 	testData
         , 	DID)
}

def static "framework.Framework.GetTestDataMap"(
    	TestData td	
     , 	String dataId	) {
    (new framework.Framework()).GetTestDataMap(
        	td
         , 	dataId)
}

def static "framework.Framework.GetValue"(
    	String data1	) {
    (new framework.Framework()).GetValue(
        	data1)
}

def static "framework.Framework.SetValue"(
    	String variable	
     , 	String value	) {
    (new framework.Framework()).SetValue(
        	variable
         , 	value)
}
