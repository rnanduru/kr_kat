package internal

import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.testobject.ObjectRepository as ObjectRepository
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
import com.kms.katalon.core.testcase.TestCaseFactory as TestCaseFactory
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase

/**
 * This class is generated automatically by Katalon Studio and should not be modified or deleted.
 */
public class GlobalVariable {
     
    /**
     * <p></p>
     */
    public static Object app_url
     
    /**
     * <p></p>
     */
    public static Object username
     
    /**
     * <p></p>
     */
    public static Object password
     
    /**
     * <p></p>
     */
    public static Object landingpagetitle
     
    /**
     * <p></p>
     */
    public static Object multivalueseperator
     
    /**
     * <p></p>
     */
    public static Object defaultdateformat
     

    static {
        def allVariables = [:]        
        allVariables.put('default', ['app_url' : 'https://compassDev.myit.kraftheinz.com', 'username' : 'secregst376', 'password' : 'Kraft@2016', 'landingpagetitle' : 'KraftHeinz Compass', 'multivalueseperator' : ';', 'defaultdateformat' : 'dd/MM/yyyy'])
        allVariables.put('prahlada', allVariables['default'] + ['app_url' : 'https://compassDev.myit.kraftheinz.com', 'username' : 'secregst376', 'password' : 'Kraft@2016', 'landingpagetitle' : 'KraftHeinz Compass', 'multivalueseperator' : ';'])
        allVariables.put('prashanth', allVariables['default'] + [:])
        
        String profileName = RunConfiguration.getExecutionProfile()
        
        def selectedVariables = allVariables[profileName]
        app_url = selectedVariables['app_url']
        username = selectedVariables['username']
        password = selectedVariables['password']
        landingpagetitle = selectedVariables['landingpagetitle']
        multivalueseperator = selectedVariables['multivalueseperator']
        defaultdateformat = selectedVariables['defaultdateformat']
        
    }
}
