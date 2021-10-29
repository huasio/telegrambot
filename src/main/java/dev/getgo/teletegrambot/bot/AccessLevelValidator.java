package dev.getgo.teletegrambot.bot;

import dev.getgo.teletegrambot.bot.handlers.IAccessLevelValidator;
import dev.getgo.teletegrambot.bot.handlers.ITelegramHandler;
import dev.getgo.teletegrambot.services.UserService;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.User;

/**
 * @author UnAfraid
 */
@Service
public class AccessLevelValidator implements IAccessLevelValidator {
    private final UserService userService;

    public AccessLevelValidator(UserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean validate(ITelegramHandler handler, User user) {
        return userService.validate(user.getId(), handler.getRequiredAccessLevel());
    }
}