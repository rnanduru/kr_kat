package com.kraft.compass.common

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
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import internal.GlobalVariable

public class RobotX {

	public Robot robot;

	@Keyword
	def RoboKeyPress(String data){
		robot = new Robot();
		Thread.sleep(1000);
		type(data);
	}
	@Keyword
	def WebUISendKeys(TestObject t,String data){
		datas = data.split(GlobalVariable.multivalueseperator)
		for(String value:datas)
			WebUI.setText(t, value)
	}
	@Keyword
	def RoboKeyPressSpecial(String data){
		robot = new Robot();
		Thread.sleep(500);
		if (data.equalsIgnoreCase("f6"))
			robot.keyPress(KeyEvent.VK_F6)
		else if(data.equalsIgnoreCase("ENTER"))
			robot.keyPress(KeyEvent.VK_ENTER)
		else if(data.equalsIgnoreCase("TAB"))
			robot.keyPress(KeyEvent.VK_TAB)
		else
			robot.keyPress(KeyEvent.VK_CLEAR)
	}
	@Keyword
	def type(CharSequence characters) {
		int length = characters.length();
		for (int i = 0; i < length; i++) {
			char character = characters.charAt(i);
			println "The Character is "+character
			type(character);
			Thread.sleep(500);
		}
	}
	def doType(int[] keyCodes, int offset, int length) {
		if (length == 0)
			return;

		println "code is "+keyCodes[offset]
		robot.keyPress(keyCodes[offset]);
		doType(keyCodes, offset + 1, length - 1);
		robot.keyRelease(keyCodes[offset]);
	}
	def type(char character) {
		switch (character) {

			case 'a': doType(KeyEvent.VK_A); break;
			case 'b': doType(KeyEvent.VK_B); break;
			case 'c': doType(KeyEvent.VK_C); break;
			case 'd': doType(KeyEvent.VK_D); break;
			case 'e': doType(KeyEvent.VK_E); break;
			case 'f': doType(KeyEvent.VK_F); break;
			case 'g': doType(KeyEvent.VK_G); break;
			case 'h': doType(KeyEvent.VK_H); break;
			case 'i': doType(KeyEvent.VK_I); break;s
			case 'j': doType(KeyEvent.VK_J); break;
			case 'k': doType(KeyEvent.VK_K); break;
			case 'l': doType(KeyEvent.VK_L); break;
			case 'm': doType(KeyEvent.VK_M); break;
			case 'n': doType(KeyEvent.VK_N); break;
			case 'o': doType(KeyEvent.VK_O); break;
			case 'p': doType(KeyEvent.VK_P); break;
			case 'q': doType(KeyEvent.VK_Q); break;
			case 'r': doType(KeyEvent.VK_R); break;
			case 's': doType(KeyEvent.VK_S); break;
			case 't': doType(KeyEvent.VK_T); break;
			case 'u': doType(KeyEvent.VK_U); break;
			case 'v': doType(KeyEvent.VK_V); break;
			case 'w': doType(KeyEvent.VK_W); break;
			case 'x': doType(KeyEvent.VK_X); break;
			case 'y': doType(KeyEvent.VK_Y); break;
			case 'z': doType(KeyEvent.VK_Z); break;
			case 'A': doType(KeyEvent.VK_SHIFT, KeyEvent.VK_A); break;
			case 'B': doType(KeyEvent.VK_SHIFT, KeyEvent.VK_B); break;
			case 'C': doType(KeyEvent.VK_SHIFT, KeyEvent.VK_C); break;
			case 'D': doType(KeyEvent.VK_SHIFT, KeyEvent.VK_D); break;
			case 'E': doType(KeyEvent.VK_SHIFT, KeyEvent.VK_E); break;
			case 'F': doType(KeyEvent.VK_SHIFT, KeyEvent.VK_F); break;
			case 'G': doType(KeyEvent.VK_SHIFT, KeyEvent.VK_G); break;
			case 'H': doType(KeyEvent.VK_SHIFT, KeyEvent.VK_H); break;
			case 'I': doType(KeyEvent.VK_SHIFT, KeyEvent.VK_I); break;
			case 'J': doType(KeyEvent.VK_SHIFT, KeyEvent.VK_J); break;
			case 'K': doType(KeyEvent.VK_SHIFT, KeyEvent.VK_K); break;
			case 'L': doType(KeyEvent.VK_SHIFT, KeyEvent.VK_L); break;
			case 'M': doType(KeyEvent.VK_SHIFT, KeyEvent.VK_M); break;
			case 'N': doType(KeyEvent.VK_SHIFT, KeyEvent.VK_N); break;
			case 'O': doType(KeyEvent.VK_SHIFT, KeyEvent.VK_O); break;
			case 'P': doType(KeyEvent.VK_SHIFT, KeyEvent.VK_P); break;
			case 'Q': doType(KeyEvent.VK_SHIFT, KeyEvent.VK_Q); break;
			case 'R': doType(KeyEvent.VK_SHIFT, KeyEvent.VK_R); break;
			case 'S': doType(KeyEvent.VK_SHIFT, KeyEvent.VK_S); break;
			case 'T': doType(KeyEvent.VK_SHIFT, KeyEvent.VK_T); break;
			case 'U': doType(KeyEvent.VK_SHIFT, KeyEvent.VK_U); break;
			case 'V': doType(KeyEvent.VK_SHIFT, KeyEvent.VK_V); break;
			case 'W': doType(KeyEvent.VK_SHIFT, KeyEvent.VK_W); break;
			case 'X': doType(KeyEvent.VK_SHIFT, KeyEvent.VK_X); break;
			case 'Y': doType(KeyEvent.VK_SHIFT, KeyEvent.VK_Y); break;
			case 'Z': doType(KeyEvent.VK_SHIFT, KeyEvent.VK_Z); break;
			case '`': doType(KeyEvent.VK_BACK_QUOTE); break;
			case '0': doType(KeyEvent.VK_0); break;
			case '1': doType(KeyEvent.VK_1); break;
			case '2': doType(KeyEvent.VK_2); break;
			case '3': doType(KeyEvent.VK_3); break;
			case '4': doType(KeyEvent.VK_4); break;
			case '5': doType(KeyEvent.VK_5); break;
			case '6': doType(KeyEvent.VK_6); break;
			case '7': doType(KeyEvent.VK_7); break;
			case '8': doType(KeyEvent.VK_8); break;
			case '9': doType(KeyEvent.VK_9); break;
			case '-': doType(KeyEvent.VK_MINUS); break;
			case '=': doType(KeyEvent.VK_EQUALS); break;
			case '~': doType(KeyEvent.VK_SHIFT, KeyEvent.VK_BACK_QUOTE); break;
			case '!': doType(KeyEvent.VK_EXCLAMATION_MARK); break;
			case '@': doType(KeyEvent.VK_SHIFT,KeyEvent.VK_2); break;
			case '#': doType(KeyEvent.VK_NUMBER_SIGN); break;
			case '$': doType(KeyEvent.VK_DOLLAR); break;
			case '%': doType(KeyEvent.VK_SHIFT, KeyEvent.VK_5); break;
			case '^': doType(KeyEvent.VK_CIRCUMFLEX); break;
			case '&': doType(KeyEvent.VK_AMPERSAND); break;
			case '*': doType(KeyEvent.VK_ASTERISK); break;
			case '(': doType(KeyEvent.VK_LEFT_PARENTHESIS); break;
			case ')': doType(KeyEvent.VK_RIGHT_PARENTHESIS); break;
			case '_': doType(KeyEvent.VK_UNDERSCORE); break;
			case '+': doType(KeyEvent.VK_PLUS); break;
			case '\t': doType(KeyEvent.VK_TAB); break;
			case '\n': doType(KeyEvent.VK_ENTER); break;
			case '[': doType(KeyEvent.VK_OPEN_BRACKET); break;
			case ']': doType(KeyEvent.VK_CLOSE_BRACKET); break;
			case '\\': doType(KeyEvent.VK_BACK_SLASH); break;
			case '{': doType(KeyEvent.VK_SHIFT, KeyEvent. VK_OPEN_BRACKET); break;
			case '}': doType(KeyEvent.VK_SHIFT, KeyEvent. VK_CLOSE_BRACKET); break;
			case '|': doType(KeyEvent.VK_SHIFT, KeyEvent. VK_BACK_SLASH); break;
			case ';': doType(KeyEvent.VK_SEMICOLON); break;
			case ':': doType(KeyEvent.VK_SHIFT, KeyEvent.VK_SEMICOLON); break;
			case '\'': doType(KeyEvent.VK_QUOTE); break;
			case '"': doType(KeyEvent.VK_QUOTEDBL); break;
			case ',': doType(KeyEvent.VK_COMMA); break;
			case '<': doType(KeyEvent.VK_LESS); break;
			case '.': doType(KeyEvent.VK_PERIOD); break;
			case '>': doType(KeyEvent.VK_GREATER); break;
			case '/': doType(KeyEvent.VK_SLASH); break;
			case '?': doType(KeyEvent.VK_SHIFT, KeyEvent.VK_SLASH); break;
			case ' ': doType(KeyEvent.VK_SPACE); break;
			default:
				throw new IllegalArgumentException("Cannot type character " + character);
		}
	}
	def doType(int... keyCodes) {
		doType(keyCodes, 0, keyCodes.length);
	}
}
