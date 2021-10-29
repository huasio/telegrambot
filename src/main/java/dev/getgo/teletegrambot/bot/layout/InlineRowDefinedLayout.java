package dev.getgo.teletegrambot.bot.layout;

import java.util.ArrayList;
import java.util.List;

import dev.getgo.teletegrambot.bot.bean.InlineButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

/**
 * @author UnAfraid
 */
public class InlineRowDefinedLayout implements IInlineMenuLayout {
	/**
	 * The default Inline Row Defined layout
	 */
	public static final InlineRowDefinedLayout DEFAULT = new InlineRowDefinedLayout();
	
	private InlineRowDefinedLayout() {
	}
	
	@Override
	public InlineKeyboardMarkup generateLayout(List<InlineButton> buttons) {
		final InlineKeyboardMarkup markup = new InlineKeyboardMarkup();
		markup.setKeyboard(new ArrayList<>());
		buttons.forEach(uiButton ->
		{
			final InlineKeyboardButton button = uiButton.createInlineKeyboardButton();
			if ((markup.getKeyboard().size() <= uiButton.getRow()) || uiButton.isForceNewRow()) {
				markup.getKeyboard().add(new ArrayList<>());
			}
			markup.getKeyboard().get(uiButton.isForceNewRow() ? (markup.getKeyboard().size() - 1) : uiButton.getRow()).add(button);
		});
		return markup;
	}
}