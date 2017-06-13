package com.atm.xunit.hometask.runner;

import java.util.ArrayList;

import org.testng.TestNG;
import org.testng.xml.XmlSuite;

import com.atm.xunit.hometask.listener.Listener;

public class CustomRunner {

    @SuppressWarnings({ "deprecation", "serial" })
	public static void main(String[] args) {
	TestNG testNG = new TestNG();
	testNG.addListener(new Listener());

	final XmlSuite xmlSuite = new XmlSuite();
	xmlSuite.setName("Calculator suite");
	xmlSuite.setSuiteFiles(new ArrayList<String>() {
	    {
		add("./resources/Calculator.xml");
	    }
	});
	testNG.setXmlSuites(new ArrayList<XmlSuite>() {
	    {
		add(xmlSuite);
	    }
	});
	testNG.run();
    }

}
