package com.atm.xunit.hometask.runner;

import java.util.Collection;
import java.util.List;

import org.testng.IClassListener;
import org.testng.IInvokedMethodListener;
import org.testng.ISuite;
import org.testng.ITestRunnerFactory;
import org.testng.TestNG;
import org.testng.TestRunner;
import org.testng.internal.ClassHelper;
import org.testng.reporters.JUnitXMLReporter;
import org.testng.reporters.TestHTMLReporter;
import org.testng.xml.XmlTest;

public class CustomRunner extends TestNG{

	private ITestRunnerFactory m_customTestRunnerFactory; 
	
	protected ITestRunnerFactory buildTestRunnerFactory() 
	  { 
	    //################### PATCH STARTS 
	    if (System.getProperty("testrunfactory") != null) { 
	      m_customTestRunnerFactory = (ITestRunnerFactory) ClassHelper.newInstance( 
	          ClassHelper.fileToClass( 
	              System.getProperty( 
	                  "testrunfactory" 
	              ) 
	          ) 
	      ); 
	      //################## PATCH ENDS 
	    } else if (null == m_customTestRunnerFactory) { 
	      m_customTestRunnerFactory = new ITestRunnerFactory() 
	      { 
	    		@Override
				public TestRunner newTestRunner(ISuite suite, XmlTest test, Collection<IInvokedMethodListener> listeners,
						List<IClassListener> classListeners) {
	          TestRunner runner = 
	              new TestRunner( 
	                  getConfiguration(), suite, test, 
	                  false /*skipFailedInvocationCounts */, 
	                  listeners, null 
	              ); 
	          if (m_useDefaultListeners) { 
	            runner.addListener(new TestHTMLReporter()); 
	            runner.addListener(new JUnitXMLReporter()); 
	          } 
	 
	          return runner; 
	        }				
	      }; 
	    } 
	 
	    return m_customTestRunnerFactory; 
	  } 
	

}
