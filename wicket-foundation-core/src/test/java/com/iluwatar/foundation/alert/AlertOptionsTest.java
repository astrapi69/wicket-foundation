package com.iluwatar.foundation.alert;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.iluwatar.foundation.button.ButtonRadius;


public class AlertOptionsTest {

	@Test
	public void testBasic() {
		AlertOptions options = new AlertOptions();
		AlertOptions options2 = new AlertOptions(options);
		options2 = options2.setColor(FoundationAlertColor.SECONDARY).setRadius(ButtonRadius.ROUND);
		AlertOptions options3 = new AlertOptions(FoundationAlertColor.SECONDARY);
		AlertOptions options4 = new AlertOptions(ButtonRadius.ROUND);
		assertEquals(FoundationAlertColor.SECONDARY, options3.getColor());
		assertEquals(ButtonRadius.ROUND, options4.getRadius());
		AlertOptions options5 = new AlertOptions(FoundationAlertColor.SECONDARY, ButtonRadius.ROUND);
	}
}
