package com.kdp.junit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class GreetingTest {

	Greeting greeting;

	@BeforeClass
	public static void beforeClass(){
		System.out.println("beforeClass");
	}

	@AfterClass
	public static void afterClass(){
		System.out.println("afterClass");
	}

	
	@Before
	public void setup(){
		System.out.println("Setup");
		greeting = new Greeting();
	}
	
	@After
	public void teardown(){
		System.out.println("Cleanup");
		greeting=null;
	}
	
	@Test
	public void testGreetForValidOutput() {
		String result = greeting.greet("Sam");
		assertNotNull(result);
		assertEquals("Hello Sam", result);
		System.out.println("testGreetForValidOutput");
	}

	@Test(expected=IllegalArgumentException.class)
	public void testGreetForExceptionforNullInput(){
		System.out.println("testGreetForExceptionforNullInput");
		greeting.greet(null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testGreetForExceptionforEmptyInput(){
		System.out.println("testGreetForExceptionforEmptyInput");
		greeting.greet("");
	}
	

	
}
