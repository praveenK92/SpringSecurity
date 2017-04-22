package com.mkyong.learn.ignore;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

@Ignore
public class JunitTestExample {

	public String message = "Guru99";

	JUnitMessage junitMessage = new JUnitMessage(message);

	@Test
	//@Ignore("not yet ready , Please ignore.")
	public void testJUnitMessage() {
		System.out.println("Junit Message is printing");
		assertEquals(message, junitMessage.printMessage());

	}

	@Test
	public void testJUnitHiMessage() {
		message = "Hi!" + message;
		System.out.println("Junit Hi Message is printing ");
		assertEquals(message, junitMessage.printHiMessage());

	}
}