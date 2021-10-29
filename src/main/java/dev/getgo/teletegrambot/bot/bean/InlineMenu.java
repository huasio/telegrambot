package dev.getgo.teletegrambot.bot.bean;

import dev.getgo.teletegrambot.bot.layout.IInlineMenuLayout;

import java.util.List;

/**
 * @author UnAfraid
 */
public class InlineMenu {
	private final InlineContext context;
	private final String name;
	private final InlineMenu parentMenu;
	private final List<InlineButton> buttons;
	private final IInlineMenuLayout layout;
	
	/**
	 * Creates new inline menu
	 *
	 * @param builder the builder
	 */
	public InlineMenu(InlineMenuBuilder builder) {
		this.context = builder.context;
		this.name = builder.name;
		this.parentMenu = builder.parentMenu;
		this.buttons = builder.buttons;
		this.layout = builder.layout;
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @return the context
	 */
	public InlineContext getContext() {
		return context;
	}
	
	/**
	 * @return the parentMenu
	 */
	public InlineMenu getParentMenu() {
		return parentMenu;
	}
	
	/**
	 * @return the buttons
	 */
	public List<InlineButton> getButtons() {
		return buttons;
	}
	
	/**
	 * @return the layout
	 */
	public IInlineMenuLayout getLayout() {
		return layout;
	}
}