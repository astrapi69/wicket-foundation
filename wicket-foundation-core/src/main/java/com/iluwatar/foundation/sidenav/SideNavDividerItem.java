package com.iluwatar.foundation.sidenav;

public class SideNavDividerItem implements SideNavItem {

	private static final long serialVersionUID = 1L;

	@Override
	public boolean isDivider() {
		return true;
	}

	@Override
	public boolean isHeader() {
		return false;
	}

	@Override
	public boolean isActive() {
		return false;
	}

	@Override
	public String getTitle() {
		return "";
	}

}
