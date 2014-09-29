package com.iluwatar.foundation.iconbar;

import java.util.List;

import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.image.Image;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.util.ListModel;

import com.iluwatar.foundation.component.FoundationBasePanel;
import com.iluwatar.foundation.util.Attribute;
import com.iluwatar.foundation.util.StringUtil;

public class FoundationIconBar extends FoundationBasePanel {

	private static final long serialVersionUID = 1L;
	
	private IModel<IconBarOptions> optionsModel;
	private IModel<List<IconBarItem>> itemsModel;

	public FoundationIconBar(String id, List<IconBarItem> items) {
		this(id, new IconBarOptions(), items);
	}
	
	public FoundationIconBar(String id, IconBarOptions options, List<IconBarItem> items) {
		this(id, Model.of(options), new ListModel<>(items));
	}
	
	public FoundationIconBar(String id, IModel<IconBarOptions> optionsModel, IModel<List<IconBarItem>> itemsModel) {
		super(id);
		this.optionsModel = optionsModel;
		this.itemsModel = itemsModel;
		add(new ListView<IconBarItem>("item", itemsModel) {

			private static final long serialVersionUID = 1L;

			@Override
			protected void populateItem(ListItem<IconBarItem> item) {
				if (item.getModelObject().getImageResourceReference() != null) {
					item.add(new Image("img", item.getModelObject().getImageResourceReference()));
					item.add(new WebMarkupContainer("icon").setVisible(false));
				} else {
					item.add(new WebMarkupContainer("img").setVisible(false));
					item.add(new IconFontContainer("icon", item.getModelObject().getFontId()));
				}
				WebMarkupContainer label = new WebMarkupContainer("label");
				item.add(label);
				label.add(new Label("text", item.getModelObject().getLabel()));
			}
		});
	}
	
	@Override
	protected void onComponentTag(ComponentTag tag) {
		Attribute.addClass(tag, "icon-bar");
		IconBarOptions options = optionsModel.getObject();
		if (options.getVerticalStyle() != null) {
			Attribute.addClass(tag, StringUtil.EnumNameToCssClassName(options.getVerticalStyle().name()));
		}
		if (options.isLabelRight()) {
			Attribute.addClass(tag, "label-right");
		}
		switch (itemsModel.getObject().size()) {
			case 1: Attribute.addClass(tag, "one-up"); break;
			case 2: Attribute.addClass(tag, "two-up"); break;
			case 3: Attribute.addClass(tag, "three-up"); break;
			case 4: Attribute.addClass(tag, "four-up"); break;
			case 5: Attribute.addClass(tag, "five-up"); break;
			case 6: Attribute.addClass(tag, "six-up"); break;
		}
		super.onComponentTag(tag);
	}
	
	@Override
	protected void onDetach() {
		optionsModel.detach();
		itemsModel.detach();
		super.onDetach();
	}
	
	private static class IconFontContainer extends WebMarkupContainer {

		private String fontId;

		public IconFontContainer(String id, String fontId) {
			super(id);
			this.fontId = fontId;
		}
		
		@Override
		protected void onComponentTag(ComponentTag tag) {
			Attribute.addClass(tag, fontId);
			super.onComponentTag(tag);
		}
	}
}
