
/**
 * This class is generated automatically by Katalon Studio and should not be modified or deleted.
 */

import java.lang.String

import com.kms.katalon.core.testobject.TestObject

import java.lang.CharSequence

import com.kms.katalon.core.testcase.TestCase

import com.kms.katalon.core.testdata.TestData


def static "com.kraft.compass.common.RobotX.RoboKeyPress"(
    	String data	) {
    (new com.kraft.compass.common.RobotX()).RoboKeyPress(
        	data)
}

def static "com.kraft.compass.common.RobotX.WebUISendKeys"(
    	TestObject t	
     , 	String data	) {
    (new com.kraft.compass.common.RobotX()).WebUISendKeys(
        	t
         , 	data)
}

def static "com.kraft.compass.common.RobotX.RoboKeyPressSpecial"(
    	String data	) {
    (new com.kraft.compass.common.RobotX()).RoboKeyPressSpecial(
        	data)
}

def static "com.kraft.compass.common.RobotX.type"(
    	CharSequence characters	) {
    (new com.kraft.compass.common.RobotX()).type(
        	characters)
}

def static "com.kraft.compass.common.General.sleep"(
    	int timeInSec	) {
    (new com.kraft.compass.common.General()).sleep(
        	timeInSec)
}

def static "com.kraft.compass.common.General.bindVariables"() {
    (new com.kraft.compass.common.General()).bindVariables()
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
