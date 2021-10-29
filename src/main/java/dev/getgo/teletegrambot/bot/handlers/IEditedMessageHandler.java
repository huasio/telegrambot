package dev.getgo.teletegrambot.bot.handlers;

import dev.getgo.teletegrambot.bot.AbstractTelegramBot;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

/**
 * @author UnAfraid
 */
public interface IEditedMessageHandler extends ITelegramHandler {
	/**
	 * Fired whenever user types anything but a command
	 *
	 * @param bot     the bot
	 * @param update  the update
	 * @param message the message
	 * @return {@code true} if edit was successful, aborting notification to other handlers, {@code false} otherwise, continuing to look for handler that would return {@code true}
	 * @throws TelegramApiException the exception
	 */
	boolean onEditMessage(AbstractTelegramBot bot, Update update, Message message) throws TelegramApiException;
}