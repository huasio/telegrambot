package dev.getgo.teletegrambot.bot.bean;

import java.util.Objects;

import com.github.unafraid.telegrambot.handlers.inline.events.IInlineCallbackEvent;
import com.github.unafraid.telegrambot.handlers.inline.events.IInlineMessageEvent;

/**
 * @author UnAfraid
 */
public class InlineButtonBuilder {
	final InlineContext context;
	String name;
	int row;
	boolean forceNewRow;
	IInlineCallbackEvent onQueryCallback;
	IInlineMessageEvent onInputMessage;
	InlineMenu subMenu;
	
	/**
	 * Creates new Inline Button Builder instance
	 *
	 * @param context context
	 */
	public InlineButtonBuilder(InlineContext context) {
		this.context = context;
	}
	
	/**
	 * Sets name for the button
	 *
	 * @param name the name
	 * @return this builder
	 */
	public InlineButtonBuilder name(String name) {
		this.name = name;
		return this;
	}
	
	/**
	 * Sets the button on particular row
	 *
	 * @param row the row
	 * @return this builder
	 */
	public InlineButtonBuilder row(int row) {
		this.row = row;
		return this;
	}
	
	/**
	 * Forces the button to be on new next row
	 *
	 * @return this builder
	 */
	public InlineButtonBuilder forceOnNewRow() {
		this.forceNewRow = true;
		return this;
	}
	
	/**
	 * Sets on query callback handler
	 *
	 * @param onQueryCallback the on query callback handler
	 * @return this builder
	 */
	public InlineButtonBuilder onQueryCallback(IInlineCallbackEvent onQueryCallback) {
		Objects.requireNonNull(onQueryCallback);
		this.onQueryCallback = onQueryCallback;
		return this;
	}
	
	/**
	 * Sets input message handler
	 *
	 * @param onInputMessage the input message handler
	 * @return this builder
	 */
	public InlineButtonBuilder onInputMessage(IInlineMessageEvent onInputMessage) {
		Objects.requireNonNull(onInputMessage);
		this.onInputMessage = onInputMessage;
		return this;
	}
	
	/**
	 * sets sub menu
	 *
	 * @param subMenu the sub menu
	 * @return this builder
	 */
	public InlineButtonBuilder menu(InlineMenu subMenu) {
		if (this.subMenu != null) {
			throw new IllegalStateException("Menu already set!");
		}
		Objects.requireNonNull(subMenu);
		this.subMenu = subMenu;
		return this;
	}
	
	/**
	 * Builds inline button
	 *
	 * @return the inline button
	 */
	public InlineButton build() {
		return new InlineButton(this);
	}
}