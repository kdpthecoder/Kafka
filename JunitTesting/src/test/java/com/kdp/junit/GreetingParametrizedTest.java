package com.kdp.junit;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)				// <<<<<<<< Marker for Parameterized Test Class
public class GreetingParametrizedTest {

	Greeting greeting;
	private String input;
	private String expectedOutput;

	public GreetingParametrizedTest(String input, String expectedOutput) {
		super();
		this.input = input;
		this.expectedOutput = expectedOutput;
	}

	
	@Parameters
	public static Collection<String[]> testConditions(){
		String expectedOutputs[][]={{"Sam","Hello Sam"},{"Junit","Hello Junit"}};
		return Arrays.asList(expectedOutputs);
	}

	
	@Test
	public void testGreetForValidOutput() {
		greeting= new Greeting();
		assertEquals(expectedOutput,greeting.greet(input));
		System.out.println("testGreetForValidOutput");
	}

	
	


	public String getInput() {
		return input;
	}

	public void setInput(String input) {
		this.input = input;
	}

	public String getExpectedOutput() {
		return expectedOutput;
	}

	public void setExpectedOutput(String expectedOutput) {
		this.expectedOutput = expectedOutput;
	}
}
