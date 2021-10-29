package dev.getgo.teletegrambot.bot;

/**
 * Default Telegram bot implementation, handles all updates and sends notification to registered handlers.
 *
 * @author UnAfraid
 */
public class DefaultTelegramBot extends AbstractTelegramBot {
	public DefaultTelegramBot(String token, String username) {
		super(token, username);
	}
}