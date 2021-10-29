package dev.getgo.teletegrambot.bot.handlers;

import dev.getgo.teletegrambot.bot.AbstractTelegramBot;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

/**
 * @author UnAfraid
 */
public interface IChannelPostHandler extends ITelegramHandler {
	/**
	 * Fired whenever someone posts message within a channel
	 *
	 * @param bot     the bot
	 * @param update  the update
	 * @param message the message
	 * @return {@code true} if handler 'consumed' that event, aborting notification to other handlers, {@code false} otherwise, continuing to look for handler that would return {@code true}
	 * @throws TelegramApiException the exception
	 */
	boolean onChannelPost(AbstractTelegramBot bot, Update update, Message message) throws TelegramApiException;
}