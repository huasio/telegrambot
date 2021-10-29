package dev.getgo.teletegrambot.bot.layout;

import java.util.List;

import com.github.unafraid.telegrambot.handlers.inline.InlineButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;

/**
 * @author UnAfraid
 */
public interface IInlineMenuLayout {
	/**
	 * @param buttons the buttons to generate the menu with
	 * @return the generated markup
	 */
	InlineKeyboardMarkup generateLayout(List<InlineButton> buttons);
}