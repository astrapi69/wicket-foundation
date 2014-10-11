package com.iluwatar.foundation.subnav;

import java.util.List;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.AbstractLink;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.util.ListModel;

import com.iluwatar.foundation.component.FoundationBasePanel;
import com.iluwatar.foundation.util.Attribute;

/**
 * This simple sub nav is great for moving between different states of a page. We use these 
 * frequently to show iterations of something, typically by date, but they're also handy for filters like these.
 * http://foundation.zurb.com/docs/components/subnav.html
 * @author ilkka
 *
 */
public abstract class FoundationSubNav extends FoundationBasePanel {

	private static final long serialVersionUID = 1L;

	public FoundationSubNav(String id, String title, List<SubNavItem> items) {
		this(id, Model.of(title), new ListModel<>(items));
	}
	
	public FoundationSubNav(String id, IModel<String> titleModel, IModel<List<SubNavItem>> itemsModel) {
		super(id);
		SubNavContainer subNavContainer = new SubNavContainer("subNavContainer");
		add(subNavContainer);
		subNavContainer.add(new Label("subNavTitle", titleModel));
		subNavContainer.add(new ListView<SubNavItem>("subNavItem", itemsModel) {

			private static final long serialVersionUID = 1L;

			@Override
			protected void populateItem(ListItem<SubNavItem> item) {
				SubNavItem subNavItem = item.getModelObject();
				if (subNavItem.isActive()) {
					item.add(new AttributeModifier("class", "active"));
				}
				AbstractLink subNavItemLink = createLink("subNavItemLink", item.getIndex());
				item.add(subNavItemLink);
				subNavItemLink.add(new Label("subNavItemText", subNavItem.getTitle()));
			}
		});
	}
	
	public abstract AbstractLink createLink(String id, int idx);
	
	private static class SubNavContainer extends WebMarkupContainer {

		private static final long serialVersionUID = 1L;

		public SubNavContainer(String id) {
			super(id);
		}
		
		@Override
		protected void onComponentTag(ComponentTag tag) {
			Attribute.setClass(tag, "sub-nav");
			super.onComponentTag(tag);
		}
	}
}
