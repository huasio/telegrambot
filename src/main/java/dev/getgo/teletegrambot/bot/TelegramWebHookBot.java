package dev.getgo.teletegrambot.bot;

import dev.getgo.teletegrambot.bot.handlers.ICommandHandler;
import org.springframework.context.ApplicationContext;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.generics.WebhookBot;

import java.util.Map;

/**
 * @author UnAfraid
 */
public abstract class TelegramWebHookBot extends DefaultTelegramBot implements WebhookBot {
    public TelegramWebHookBot(String token, String username, ApplicationContext appContext) {
        super(token, username);

        final Map<String, ICommandHandler> handlers = appContext.getBeansOfType(ICommandHandler.class);
        handlers.values().forEach(this::addHandler);
    }

    @Override
    public final BotApiMethod<?> onWebhookUpdateReceived(Update update) {
        if (update != null) {
            onUpdateReceived(update);
        }
        return null;
    }
}
