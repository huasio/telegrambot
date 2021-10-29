package dev.getgo.teletegrambot.controller;

import org.springframework.web.bind.annotation.*;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Update;
import dev.getgo.teletegrambot.services.TelegramBotService;
/**
 * @author UnAfraid
 */
@RestController
public class MainController {
    private final TelegramBotService telegramBotService;

    public MainController(TelegramBotService telegramBotService) {
        this.telegramBotService = telegramBotService;
    }

    @RequestMapping(value = "/callback/${TELEGRAM_TOKEN}", method = RequestMethod.POST)
    @ResponseBody
    public BotApiMethod<?> onUpdateReceived(@RequestBody Update update) {
        return telegramBotService.onWebhookUpdateReceived(update);
    }
}
