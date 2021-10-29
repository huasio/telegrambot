package dev.getgo.teletegrambot.bot.util;

import dev.getgo.teletegrambot.bot.handlers.ICommandHandler;
import org.telegram.telegrambots.meta.api.methods.ActionType;
import org.telegram.telegrambots.meta.api.methods.send.SendChatAction;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;
import org.telegram.telegrambots.meta.bots.AbsSender;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

/**
 * @author UnAfraid
 */
public class BotUtil {
	public static <T extends AbsSender> void sendAction(T bot, Message message, ActionType actionType) throws TelegramApiException {
		final SendChatAction sendAction = new SendChatAction();
		sendAction.setChatId(Long.toString(message.getChat().getId()));
		sendAction.setAction(actionType);
		bot.execute(sendAction);
	}
	
	public static <T extends AbsSender> void sendUsage(T bot, Message message, ICommandHandler handler) throws TelegramApiException {
		final SendMessage msg = new SendMessage();
		msg.setChatId(Long.toString(message.getChat().getId()));
		msg.setText(handler.getUsage());
		bot.execute(msg);
	}
	
	public static <T extends AbsSender> Message sendMessage(T bot, Message message, String text, boolean replyToMessage, boolean useMarkDown, ReplyKeyboard replayMarkup) throws TelegramApiException {
		final SendMessage msg = new SendMessage();
		msg.setChatId(Long.toString(message.getChat().getId()));
		msg.setText(text);
		msg.enableMarkdown(useMarkDown);
		if (replyToMessage) {
			msg.setReplyToMessageId(message.getMessageId());
		}
		if (replayMarkup != null) {
			msg.setReplyMarkup(replayMarkup);
		}
		return bot.execute(msg);
	}
	
	public static <T extends AbsSender> void sendHtmlMessage(T bot, Message message, String text, boolean replyToMessage, ReplyKeyboard replayMarkup) throws TelegramApiException {
		final SendMessage msg = new SendMessage();
		msg.setChatId(Long.toString(message.getChat().getId()));
		msg.setText(text);
		msg.enableHtml(true);
		if (replyToMessage) {
			msg.setReplyToMessageId(message.getMessageId());
		}
		if (replayMarkup != null) {
			msg.setReplyMarkup(replayMarkup);
		}
		bot.execute(msg);
	}
	
	public static <T extends AbsSender> void editMessage(T bot, Message message, String text, boolean useMarkDown, InlineKeyboardMarkup inlineMarkup) throws TelegramApiException {
		final EditMessageText msg = new EditMessageText();
		msg.setChatId(Long.toString(message.getChat().getId()));
		msg.setMessageId(message.getMessageId());
		msg.setText(text);
		msg.enableMarkdown(useMarkDown);
		msg.setReplyMarkup(inlineMarkup);
		bot.execute(msg);
	}
	
	public static <T extends AbsSender> void editMessage(T bot, CallbackQuery query, String text, boolean useMarkDown, InlineKeyboardMarkup inlineMarkup) throws TelegramApiException {
		final EditMessageText msg = new EditMessageText();
		msg.setChatId(Long.toString(query.getMessage().getChat().getId()));
		msg.setMessageId(query.getMessage().getMessageId());
		msg.setInlineMessageId(query.getInlineMessageId());
		msg.setText(text);
		msg.enableMarkdown(useMarkDown);
		msg.setReplyMarkup(inlineMarkup);
		bot.execute(msg);
	}
}