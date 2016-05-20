package com.kdp.junit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ GreetingParametrizedTest.class, GreetingTest.class })
public class AllTests {

}
