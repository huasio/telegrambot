package dev.getgo.teletegrambot.bot.event;

import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

/**
 * @author UnAfraid
 */
@FunctionalInterface
public interface IInlineMessageEvent {
	/**
	 * @param event the inline message event
	 * @return {@code true} on success, {@code false} otherwise
	 * @throws TelegramApiException in case of an error
	 */
	boolean onCallbackEvent(InlineMessageEvent event) throws TelegramApiException;
}