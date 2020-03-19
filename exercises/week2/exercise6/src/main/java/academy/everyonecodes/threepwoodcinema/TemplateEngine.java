package academy.everyonecodes.threepwoodcinema;

import org.springframework.stereotype.Service;

@Service
public class TemplateEngine {

    private final TemplateMessageFinder finder;

    public TemplateEngine(TemplateMessageFinder finder) {
        this.finder = finder;
    }
    public String customise(String name){
        return finder.find(name).replace("--name--", name);
    }
}
