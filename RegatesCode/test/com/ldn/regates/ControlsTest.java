package com.ldn.regates;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ldn.regates.utlis.Controls;

public class ControlsTest {

	@Test
	public void testIsValidEMail() {
		
		assertEquals(true, Controls.isValidEMail("lionel.duboeuf@gmail.com"));
		
		assertEquals(false, Controls.isValidEMail("lionel.duboeufgmail.com"));
		
		assertEquals(false, Controls.isValidEMail("l$gmail.com"));
		
		assertEquals(false, Controls.isValidEMail("l@gmail.com"));
		
		assertEquals(false, Controls.isValidEMail("l785@gmai@l.com"));
		
		assertEquals(false, Controls.isValidEMail("l785@gmailol.c"));
		
	}
	
	
	@Test
	public void testIsDateValid(){
		
		assertEquals(true, Controls.isValidDate("2004/01/01"));
		
		assertEquals(false, Controls.isValidDate("01/01/2004"));
		
		assertEquals(false, Controls.isValidDate("01/01948/2004"));
		
	}

}
