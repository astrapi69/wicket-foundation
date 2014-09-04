package com.iluwatar.foundation;

import org.apache.wicket.request.resource.CssResourceReference;
import org.apache.wicket.request.resource.JavaScriptResourceReference;
import org.apache.wicket.request.resource.ResourceReference;

public class Foundation {

	private static ResourceReference foundationCssReference;

	private static ResourceReference normalizeCssReference;
	
	private static ResourceReference foundationJsReference;

	private static ResourceReference modernizrJsReference;

	private static ResourceReference fastclickJsReference;
	
	public static ResourceReference getFoundationCssReference() {
		if (foundationCssReference == null) {
			foundationCssReference = new CssResourceReference(Foundation.class, "foundation.css");
		}
		return foundationCssReference;
	}

	public static ResourceReference getNormalizeCssReference() {
		if (normalizeCssReference == null) {
			normalizeCssReference = new CssResourceReference(Foundation.class, "normalize.css");
		}
		return normalizeCssReference;
	}
	
	public static ResourceReference getFoundationJsReference() {
		if (foundationJsReference == null) {
			foundationJsReference = new JavaScriptResourceReference(Foundation.class, "foundation.min.js");
		}
		return foundationJsReference;
	}

	public static ResourceReference getModernizrJsReference() {
		if (modernizrJsReference == null) {
			modernizrJsReference = new JavaScriptResourceReference(Foundation.class, "modernizr.js");
		}
		return modernizrJsReference;
	}

	public static ResourceReference getFastclickJsReference() {
		if (fastclickJsReference == null) {
			fastclickJsReference = new JavaScriptResourceReference(Foundation.class, "fastclick.js");
		}
		return fastclickJsReference;
	}	
	
	public static String getFoundationInitScript() {
		return "$(document).foundation();";
	}
}