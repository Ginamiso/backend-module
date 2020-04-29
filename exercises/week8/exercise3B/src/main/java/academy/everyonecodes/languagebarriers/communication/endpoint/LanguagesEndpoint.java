package academy.everyonecodes.languagebarriers.communication.endpoint;

import academy.everyonecodes.languagebarriers.logic.InteractionsService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class LanguagesEndpoint {

    private final String everyone;
    private final String languages;
    private final String german;
    private final String english;
    private final InteractionsService interactionsService;

    public LanguagesEndpoint(@Value("${messages.everyone}") String everyone,
                             @Value("${messages.languages}") String languages,
                             @Value("${messages.german}") String german,
                             @Value("${messages.english}") String english,
                             InteractionsService interactionsService) {
        this.everyone = everyone;
        this.languages = languages;
        this.german = german;
        this.english = english;
        this.interactionsService = interactionsService;
    }

    @GetMapping
    String get() {
        return everyone;
    }

    @GetMapping("/languages")
    @Secured("ROLE_USER")
    String getLanguages() {
        interactionsService.increaseInteractions();
        return languages;
    }

    @GetMapping("/languages/german")
    @Secured("ROLE_LANGUAGE_GERMAN")
    String getGerman() {
        interactionsService.increaseInteractions();
        return german;
    }

    @GetMapping("/languages/english")
    @Secured("ROLE_LANGUAGE_ENGLISH")
    String getEnglish() {
        interactionsService.increaseInteractions();
        return english;
    }

    @GetMapping("/interactions")
    @Secured("ROLE_ADMIN")
    int getInteractions() {
        return interactionsService.getInteractions();
    }

}