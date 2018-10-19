
/**
 * This class is generated automatically by Katalon Studio and should not be modified or deleted.
 */

import com.kms.katalon.core.testobject.TestObject

import java.lang.String

import java.lang.CharSequence

import com.kms.katalon.core.testcase.TestCase

import com.kms.katalon.core.testdata.TestData


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
