package dev.getgo.teletegrambot.bot.handlers;

import com.github.unafraid.telegrambot.bots.AbstractTelegramBot;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

/**
 * @author UnAfraid
 */
public interface ICancelHandler extends ITelegramHandler {
	/**
	 * Fired whenever user types in /cancel command to cancel the current action
	 *
	 * @param bot     the bot
	 * @param update  the update
	 * @param message the message
	 * @throws TelegramApiException the exception
	 */
	void onCancel(AbstractTelegramBot bot, Update update, Message message) throws TelegramApiException;
}