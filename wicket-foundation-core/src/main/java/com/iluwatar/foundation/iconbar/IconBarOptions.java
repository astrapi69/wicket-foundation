package com.iluwatar.foundation.iconbar;

import java.io.Serializable;

public class IconBarOptions implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private IconBarVerticalStyle verticalStyle;
	private boolean labelRight;

	public IconBarOptions() {
	}
	
	public IconBarOptions(IconBarVerticalStyle verticalStyle) {
		this.verticalStyle = verticalStyle;
	}

	public IconBarOptions(boolean labelRight) {
		this.labelRight = labelRight;
	}
	
	public IconBarVerticalStyle getVerticalStyle() {
		return verticalStyle;
	}
	
	public IconBarOptions setVerticalStyle(IconBarVerticalStyle verticalStyle) {
		this.verticalStyle = verticalStyle;
		return this;
	}
	
	public boolean isLabelRight() {
		return labelRight;
	}
	
	public IconBarOptions setLabelRight(boolean labelRight) {
		this.labelRight = labelRight;
		return this;
	}
}
