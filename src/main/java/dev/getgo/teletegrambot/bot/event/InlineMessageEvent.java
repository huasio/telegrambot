package dev.getgo.teletegrambot.bot.event;

import com.github.unafraid.telegrambot.handlers.inline.InlineButton;
import com.github.unafraid.telegrambot.handlers.inline.InlineContext;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.bots.AbsSender;

/**
 * @author UnAfraid
 */
public class InlineMessageEvent {
	private final InlineContext context;
	private final InlineButton button;
	private final AbsSender bot;
	private final Update update;
	private final Message message;
	
	/**
	 * @param context the context
	 * @param button  the button
	 * @param bot     the bot
	 * @param update  the update received
	 * @param message the message
	 */
	public InlineMessageEvent(InlineContext context, InlineButton button, AbsSender bot, Update update, Message message) {
		this.context = context;
		this.button = button;
		this.bot = bot;
		this.update = update;
		this.message = message;
	}
	
	/**
	 * @return the context
	 */
	public InlineContext getContext() {
		return context;
	}
	
	/**
	 * @return the button
	 */
	public InlineButton getButton() {
		return button;
	}
	
	/**
	 * @return the bot
	 */
	public AbsSender getBot() {
		return bot;
	}
	
	/**
	 * @return the update
	 */
	public Update getUpdate() {
		return update;
	}
	
	/**
	 * @return the query
	 */
	public Message getMessage() {
		return message;
	}
}