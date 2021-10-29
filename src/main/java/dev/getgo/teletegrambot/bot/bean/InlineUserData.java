package dev.getgo.teletegrambot.bot.bean;

import javax.validation.constraints.NotNull;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import dev.getgo.teletegrambot.bot.layout.IInlineMenuLayout;
import dev.getgo.teletegrambot.bot.util.BotUtil;
import dev.getgo.teletegrambot.bot.util.MapUtil;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.bots.AbsSender;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

/**
 * This class is thread-safe
 *
 * @author UnAfraid
 */
public class InlineUserData {
	private final long id;
	private final MapUtil params = new MapUtil(new ConcurrentHashMap<>());
	private InlineMenu activeMenu;
	private InlineButton activeButton;
	private final AtomicInteger state = new AtomicInteger();
	private final ReentrantReadWriteLock activeLock = new ReentrantReadWriteLock();
	
	/**
	 * Creates new inline user data instance
	 *
	 * @param id user id
	 */
	public InlineUserData(long id) {
		this.id = id;
	}
	
	/**
	 * @return the user id
	 */
	public long getId() {
		return id;
	}
	
	/**
	 * @return the state
	 */
	public int getState() {
		return state.get();
	}
	
	/**
	 * @param state the state to set
	 */
	public void setState(int state) {
		this.state.set(state);
	}
	
	/**
	 * @param expectedState the expected state
	 * @param newState      the new state to set
	 * @return {@code true} if atomic operation succeeded, {@code false} otherwise
	 */
	public boolean setCompareAndSetState(int expectedState, int newState) {
		return this.state.compareAndSet(expectedState, newState);
	}
	
	/**
	 * @return the activeMenu
	 */
	public InlineMenu getActiveMenu() {
		activeLock.readLock().lock();
		try {
			return activeMenu;
		} finally {
			activeLock.readLock().unlock();
		}
	}
	
	/**
	 * @param activeMenu the activeMenu to set
	 */
	public void setActiveMenu(InlineMenu activeMenu) {
		activeLock.writeLock().lock();
		try {
			this.activeMenu = activeMenu;
		} finally {
			activeLock.writeLock().unlock();
		}
	}
	
	/**
	 * @return the activeButton
	 */
	public InlineButton getActiveButton() {
		activeLock.readLock().lock();
		try {
			return activeButton;
		} finally {
			activeLock.readLock().unlock();
		}
	}
	
	/**
	 * @param activeButton the activeButton to set
	 */
	public void setActiveButton(InlineButton activeButton) {
		activeLock.writeLock().lock();
		try {
			this.activeButton = activeButton;
		} finally {
			activeLock.writeLock().unlock();
		}
	}
	
	/**
	 * @return the params
	 */
	public MapUtil getParams() {
		return params;
	}
	
	/**
	 * Sends the InlineMenu to message's chat
	 *
	 * @param bot     the bot instance
	 * @param message the update message
	 * @param text    the text
	 * @param layout  the layout of the menu
	 * @param menu    the menu
	 * @throws TelegramApiException in case of an error
	 */
	public void sendMenu(@NotNull AbsSender bot, @NotNull Message message, @NotNull String text, @NotNull IInlineMenuLayout layout, @NotNull InlineMenu menu) throws TelegramApiException {
		Objects.requireNonNull(bot);
		Objects.requireNonNull(message);
		Objects.requireNonNull(text);
		Objects.requireNonNull(layout);
		Objects.requireNonNull(menu);
		
		activeMenu = menu;
		final InlineKeyboardMarkup markup = layout.generateLayout(activeMenu.getButtons());
		BotUtil.sendMessage(bot, message, text, false, true, markup);
	}
	
	/**
	 * Edits current message with the new text and menu
	 *
	 * @param bot     the bot instance
	 * @param message the update message
	 * @param text    the text
	 * @param layout  the layout of the menu
	 * @param menu    the menu
	 * @throws TelegramApiException in case of an error
	 */
	public void editCurrentMenu(@NotNull AbsSender bot, @NotNull Message message, @NotNull String text, @NotNull IInlineMenuLayout layout, @NotNull InlineMenu menu) throws TelegramApiException {
		Objects.requireNonNull(bot);
		Objects.requireNonNull(message);
		Objects.requireNonNull(text);
		Objects.requireNonNull(layout);
		Objects.requireNonNull(menu);
		
		if (text.trim().isEmpty()) {
			throw new IllegalStateException("Menu's name should be non empty!");
		}
		
		activeMenu = menu;
		final InlineKeyboardMarkup markup = layout.generateLayout(activeMenu.getButtons());
		BotUtil.editMessage(bot, message, text, true, markup);
	}
	
	/**
	 * Edits the message sets menu.getName as text of the message and renders the menu specified
	 *
	 * @param bot     the bot instance
	 * @param message the update message
	 * @param layout  the layout of the menu
	 * @param menu    the menu
	 * @throws TelegramApiException in case of an error
	 */
	public void editCurrentMenu(AbsSender bot, Message message, IInlineMenuLayout layout, InlineMenu menu) throws TelegramApiException {
		Objects.requireNonNull(bot);
		Objects.requireNonNull(message);
		Objects.requireNonNull(layout);
		Objects.requireNonNull(menu);
		
		editCurrentMenu(bot, message, menu.getName(), layout, menu);
	}
}