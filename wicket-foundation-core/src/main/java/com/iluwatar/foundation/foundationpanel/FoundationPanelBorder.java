package com.iluwatar.foundation.foundationpanel;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.model.IModel;

import com.iluwatar.foundation.border.FoundationBaseBorder;

/**
 * A panel is a simple, helpful Foundation component that enables you to outline sections of your page easily.
 * http://foundation.zurb.com/docs/components/panels.html
 * @author ilkka
 *
 */
public class FoundationPanelBorder extends FoundationBaseBorder {

	private static final long serialVersionUID = 1L;
	
	private IModel<FoundationPanelType> typeModel;

	/**
	 * Create FoundationPanelBorder.
	 * @param id - Wicket id.
	 * @param typeModel - Model for the panel type.
	 */
	public FoundationPanelBorder(String id, IModel<FoundationPanelType> typeModel) {
		super(id);
		this.typeModel = typeModel;
		initComponents();
	}

	/**
	 * Create FoundationPanel.
	 * @param id - Wicket id.
	 * @param model - Model for the panel.
	 * @param typeModel - Model for the panel type.
	 */
	public FoundationPanelBorder(String id, IModel<?> model, IModel<FoundationPanelType> typeModel) {
		super(id, model);
		this.typeModel = typeModel;
		initComponents();
	}
	
	private void initComponents() {
		WebMarkupContainer wrapper = new WebMarkupContainer("wrapper");
		FoundationPanelType type = typeModel.getObject();
		if (type.equals(FoundationPanelType.NORMAL)) {
			wrapper.add(new AttributeModifier("class", "panel"));
		} else if (type.equals(FoundationPanelType.CALLOUT)) {
			wrapper.add(new AttributeModifier("class", "panel callout radius"));
		}
		this.addToBorder(wrapper);
	}
	
	@Override
	protected void onDetach() {
		this.typeModel.detach();
		super.onDetach();
	}
}
