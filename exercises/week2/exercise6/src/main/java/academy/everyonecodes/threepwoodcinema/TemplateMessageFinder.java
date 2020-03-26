package academy.everyonecodes.threepwoodcinema;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TemplateMessageFinder {

    private List<Template> templates;
    private String defaultMessage;

    public TemplateMessageFinder(List<Template> templates,
                                 @Value("${cinema.specialoffer.defaultmessage}") String defaultMessage) {
        this.templates = templates;
        this.defaultMessage = defaultMessage;
    }

    public String find(String name) {
        return templates.stream()
                .filter(template -> name.startsWith(template.getKeyword()))
                .map(Template::getMessage)
                .findFirst()
                .orElse(defaultMessage);

    }

}
