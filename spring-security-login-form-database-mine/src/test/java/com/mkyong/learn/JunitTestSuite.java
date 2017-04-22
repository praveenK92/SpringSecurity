package com.mkyong.learn;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({ JunitAnnotationsExample.class, Junit4AssertionTest.class, OutputFileTest.class })
public class JunitTestSuite {

}