package dev.getgo.teletegrambot.bot.bean;

import dev.getgo.teletegrambot.bot.layout.IInlineMenuLayout;
import dev.getgo.teletegrambot.bot.layout.InlineRowDefinedLayout;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;


/**
 * @author UnAfraid
 */
public class InlineMenuBuilder {
	final InlineContext context;
	String name;
	InlineMenu parentMenu;
	final List<InlineButton> buttons = new ArrayList<>();
	IInlineMenuLayout layout = InlineRowDefinedLayout.DEFAULT;
	
	/**
	 * Creates new inline menu builder
	 *
	 * @param context the context
	 */
	public InlineMenuBuilder(InlineContext context) {
		this(context, null);
	}
	
	/**
	 * Creates new inline menu builder
	 *
	 * @param context    the inline context
	 * @param parentMenu the parent menu
	 */
	public InlineMenuBuilder(@NotNull InlineContext context, InlineMenu parentMenu) {
		Objects.requireNonNull(context);
		
		this.context = context;
		this.parentMenu = parentMenu;
	}
	
	/**
	 * Sets parent menu
	 *
	 * @param parentMenu the parent menu to set
	 * @return this builder
	 */
	public InlineMenuBuilder parentMenu(@NotNull InlineMenu parentMenu) {
		Objects.requireNonNull(parentMenu);
		
		this.parentMenu = parentMenu;
		return this;
	}
	
	/**
	 * Sets name
	 *
	 * @param name the name to set
	 * @return this builder
	 */
	public InlineMenuBuilder name(@NotNull String name) {
		Objects.requireNonNull(name);
		
		this.name = name;
		return this;
	}
	
	/**
	 * Adds button
	 *
	 * @param button the button to add
	 * @return this builder
	 */
	public InlineMenuBuilder button(@NotNull InlineButton button) {
		Objects.requireNonNull(button);
		
		buttons.add(button);
		return this;
	}
	
	/**
	 * Adds collection of buttons
	 *
	 * @param buttons the buttons to add
	 * @return this builder
	 */
	public InlineMenuBuilder buttons(@NotNull Collection<InlineButton> buttons) {
		Objects.requireNonNull(buttons);
		
		this.buttons.addAll(buttons);
		return this;
	}
	
	/**
	 * Sets layout to generate the menu with
	 *
	 * @param layout the layout
	 * @return this builder
	 */
	public InlineMenuBuilder layout(@NotNull IInlineMenuLayout layout) {
		Objects.requireNonNull(layout);
		
		this.layout = layout;
		return this;
	}
	
	/**
	 * @return the built inline menu
	 */
	public InlineMenu build() {
		return new InlineMenu(this);
	}
}