package dev.getgo.teletegrambot.bot.bean;

import java.util.UUID;

import dev.getgo.teletegrambot.bot.event.IInlineCallbackEvent;
import dev.getgo.teletegrambot.bot.event.IInlineMessageEvent;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

/**
 * @author UnAfraid
 */
public class InlineButton {
	private final InlineContext context;
	private final String name;
	private final int row;
	private final boolean forceNewRow;
	private final IInlineCallbackEvent onQueryCallback;
	private final IInlineMessageEvent onInputMessage;
	private final InlineMenu subMenu;
	private final String uuid = UUID.randomUUID().toString();
	
	/**
	 * Creates new Inline button from builder
	 *
	 * @param builder the builder
	 */
	public InlineButton(InlineButtonBuilder builder) {
		this.context = builder.context;
		this.name = builder.name;
		this.row = builder.row;
		this.forceNewRow = builder.forceNewRow;
		this.onQueryCallback = builder.onQueryCallback;
		this.onInputMessage = builder.onInputMessage;
		this.subMenu = builder.subMenu;
	}
	
	/**
	 * @return the context
	 */
	public InlineContext getContext() {
		return context;
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @return the row
	 */
	public int getRow() {
		return row;
	}
	
	/**
	 * @return the forceNewRow
	 */
	public boolean isForceNewRow() {
		return forceNewRow;
	}
	
	/**
	 * @return the onQueryCallback
	 */
	public IInlineCallbackEvent getOnQueryCallback() {
		return onQueryCallback;
	}
	
	/**
	 * @return the onInputMessage
	 */
	public IInlineMessageEvent getInputMessage() {
		return onInputMessage;
	}
	
	/**
	 * @return the subMenu
	 */
	public InlineMenu getSubMenu() {
		return subMenu;
	}
	
	/**
	 * @return the uuid
	 */
	public String getUUID() {
		return uuid;
	}
	
	/**
	 * @return the {@link InlineKeyboardButton}
	 */
	public InlineKeyboardButton createInlineKeyboardButton() {
		final InlineKeyboardButton inlineKeyboardButton = new InlineKeyboardButton();
		inlineKeyboardButton.setText(name);
		inlineKeyboardButton.setCallbackData(uuid);
		return inlineKeyboardButton;
	}
}