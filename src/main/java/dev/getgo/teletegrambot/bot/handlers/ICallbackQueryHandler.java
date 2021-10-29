package dev.getgo.teletegrambot.bot.handlers;

import com.github.unafraid.telegrambot.bots.AbstractTelegramBot;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

/**
 * @author UnAfraid
 */
public interface ICallbackQueryHandler extends ITelegramHandler {
	/**
	 * Fired whenever bot receives a callback query
	 *
	 * @param bot    the bot
	 * @param update the update
	 * @param query  the query
	 * @return {@code true} whenever this even has to be consumed, {@code false} to continue notified other handlers
	 * @throws TelegramApiException the exception
	 */
	boolean onCallbackQuery(AbstractTelegramBot bot, Update update, CallbackQuery query) throws TelegramApiException;
}