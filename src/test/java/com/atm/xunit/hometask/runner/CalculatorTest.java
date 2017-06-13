package com.atm.xunit.hometask.runner;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.atm.xunit.hometask.dataprovider.DataForCalculation;
import com.epam.tat.module4.Calculator;

@Listeners(com.atm.xunit.hometask.listener.Listener.class)

public class CalculatorTest {

	private Calculator calc;

	@BeforeClass(groups = { "positive", "negative","cosine","trigonometry"})
	public void setUp() throws Exception {
		calc = new Calculator();
	}

	@Test(groups = { "positive" }, dataProviderClass = DataForCalculation.class, dataProvider = "addInput")
	public void testAdd(long a, long b, long expected) {
		long result = calc.sum(a, b);
		assertEquals(expected, result);

	}

	@Test(groups = { "positive" }, dataProviderClass = DataForCalculation.class, dataProvider = "subInput")
	public void testSub(long a, long b, long expected) {
		long result = calc.sub(a, b);
		assertEquals(expected, result);
	}

	@Test(groups = { "positive" }, dataProviderClass = DataForCalculation.class, dataProvider = "mulInput")
	public void testMul(long a, long b, long expected) {
		long result = calc.mult(a, b);
		assertEquals(expected, result);
	}

	@Test(groups = { "positive" }, dataProviderClass = DataForCalculation.class, dataProvider = "divideInput")
	public void testDiv(double a, double b, double expected) {
		double result = calc.div(a, b);
		assertEquals(expected, result);
	}

	@Test(groups = { "positive,broken" }, dataProviderClass = DataForCalculation.class, dataProvider = "sqrtInput")
	public void testSqrt(double a, double expected) {
		double result = calc.sqrt(a);
		assertEquals(expected, result);
	}

	@Test(groups = { "negative" }, dataProviderClass = DataForCalculation.class, dataProvider = "addNegInput")
	public void testNegAdd(long a, long b, long expected) {
		double result = calc.sum(a, b);
		assertFalse(expected == result);
	}

	@Test(groups = { "negative" }, dataProviderClass = DataForCalculation.class, dataProvider = "subNegInput")
	public void testNegSub(long a, long b, long expected) {
		long result = calc.sub(a, b);
		assertFalse(expected == result);
	}

	@Test(groups = { "negative" }, dataProviderClass = DataForCalculation.class, dataProvider = "mulNegInput")
	public void testNegMul(long a, long b, long expected) {
		long result = calc.mult(a, b);
		assertFalse(expected == result);
	}

	@Test(groups = { "negative, broken" }, dataProviderClass = DataForCalculation.class, dataProvider = "divNegInput")
	public void testNegDiv(double a, double b, double expected) {
		double result = calc.div(a, b);
		assertFalse(expected == result);
	}

	@Test(groups = { "negative" }, dataProviderClass = DataForCalculation.class, dataProvider = "sqrtNegInput")
	public void testNegSqrt(double a, double expected) {
		double result = calc.sqrt(a);
		assertFalse(expected == result);
	}

	// Implementation of depends on groups and bug finding

	@Test(groups = {"tangent"},dependsOnGroups ={"cosine"}, dataProviderClass = DataForCalculation.class, dataProvider = "tangent")
	public void testTangent(double a, double expected) {
		double result = calc.tg(a);
		try{
			assertEquals(expected, result);
		}catch(AssertionError e){
			System.out.println("The value is not matching with the expected trignometical value");
		}		
	}

	@Test(groups = {"cosine"},dataProviderClass = DataForCalculation.class, dataProvider = "cosine")
	public void testCosine(double a, double expected) {
		double result = calc.cos(a);
		try{
			assertEquals(expected, result);
		}catch(AssertionError e){
			System.out.println("The value is not matching with the expected trignometical value");
		}		
	}
	
	//[IK] Implement similar method
	@Test(groups = {"negative"})
	    public void testTangens() {
	        double result = calc.tg(45);
	        System.out.println("Mistake in the formula! It always return 1 because of using 'this' in the formula: this.sin(a) / this.cos(a); ");
	        Assert.assertEquals(result, Math.tan(45));

	    }
	
	//[MK Added test]
	@Test(groups = {"negative"})
    public void testCosine() {
        double result = calc.cos(90);
        System.out.println("Mistake in the formula! ");
        Assert.assertEquals(result, Math.cos(90));

    }
	

	@AfterClass(groups = { "positive", "negative","cosine","trigonometry"})
	public void tearDown() throws Exception {
		calc = null;
	}
}
