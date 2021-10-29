package dev.getgo.teletegrambot.bot.handlers;

import org.telegram.telegrambots.meta.api.objects.User;

/**
 * @author UnAfraid
 */
public interface IAccessLevelValidator {
	/**
	 * @param user the user to validate
	 * @return {@code true} if {@link User} has sufficient access level, {@code false} otherwise
	 */
	boolean validate(ITelegramHandler handler, User user);
}