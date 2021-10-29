package dev.getgo.teletegrambot.bot.handlers;

/**
 * @author UnAfraid
 */
public interface ITelegramHandler {
	/**
	 * @return The access level required to execute this command
	 */
	default int getRequiredAccessLevel() {
		return 0;
	}
}