package dev.getgo.teletegrambot.bot.bean;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author UnAfraid
 */
public class InlineContext {
	private final Map<Long, InlineUserData> usersData = new ConcurrentHashMap<>();
	
	/**
	 * Returns user data by user id
	 *
	 * @param id user id
	 * @return the inline user data
	 */
	public InlineUserData getUserData(long id) {
		return usersData.computeIfAbsent(id, InlineUserData::new);
	}
	
	/**
	 * Removes data by user id
	 *
	 * @param id the user id
	 * @return whether the user data was removed or not
	 */
	public boolean clear(long id) {
		return usersData.remove(id) != null;
	}
}