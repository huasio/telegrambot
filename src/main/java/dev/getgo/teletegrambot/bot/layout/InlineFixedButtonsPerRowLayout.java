package dev.getgo.teletegrambot.bot.layout;

import java.util.ArrayList;
import java.util.List;

import dev.getgo.teletegrambot.bot.bean.InlineButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

/**
 * @author UnAfraid
 */
public class InlineFixedButtonsPerRowLayout implements IInlineMenuLayout {
	private final int maxButtonsPerRow;
	
	/**
	 * Creates new Inline Fixed Buttons per row layout
	 *
	 * @param maxButtonsPerRow buttons per row
	 */
	public InlineFixedButtonsPerRowLayout(int maxButtonsPerRow) {
		this.maxButtonsPerRow = maxButtonsPerRow;
	}
	
	@Override
	public InlineKeyboardMarkup generateLayout(List<InlineButton> buttons) {
		final InlineKeyboardMarkup markup = new InlineKeyboardMarkup();
		markup.setKeyboard(new ArrayList<>());
		final List<List<InlineKeyboardButton>> keyboard = markup.getKeyboard();
		buttons.forEach(uiButton ->
		{
			final InlineKeyboardButton button = uiButton.createInlineKeyboardButton();
			if (keyboard.isEmpty() || uiButton.isForceNewRow() || (keyboard.get(markup.getKeyboard().size() - 1).size() >= maxButtonsPerRow)) {
				keyboard.add(new ArrayList<>());
			}
			keyboard.get(keyboard.size() - 1).add(button);
		});
		return markup;
	}
}