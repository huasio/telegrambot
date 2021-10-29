package dev.getgo.teletegrambot.bot.event;

import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

/**
 * @author UnAfraid
 */
@FunctionalInterface
public interface IInlineCallbackEvent {
	/**
	 * @param event the callback event
	 * @return {@code true} on success, {@code false} otherwise
	 * @throws TelegramApiException in case of an erro
	 */
	boolean onCallbackEvent(InlineCallbackEvent event) throws TelegramApiException;
}