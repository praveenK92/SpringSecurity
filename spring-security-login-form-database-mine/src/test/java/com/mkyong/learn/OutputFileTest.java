package com.mkyong.learn;

import java.io.File;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class OutputFileTest {
	private File output;
	
	@BeforeClass
	public static void Method_Name(){
		System.out.println("I come BeforeClass!");
	}	
	@AfterClass
	public static void Method_Name1(){
		System.out.println("I come AfterClass!");
	}

	@Before
	public void createOutputFile(){
		output = new File("./src/main/resources/application.properties");
		System.out.println("Before Method!");
	}

	@After
	public void deleteOutputFile() {
		output.delete();
		System.out.println("After Method!");
	}

	@Test
	public void testFile1() {
		System.out.println("testFile1 Method!");
	}

	@Test
	public void testFile2() {
		System.out.println("testFile2 Method!");
	}
}