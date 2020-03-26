package academy.everyonecodes.interactions;

import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/colors")
public class ColorsEndpoint {

    private Set<String> colors = new HashSet<>();

    @GetMapping
    Set<String> getAll() {
        return colors;
    }

    @GetMapping("/{name}")
    String getOne(@PathVariable String name) {
        return colors.stream()
                .filter(color -> color.equalsIgnoreCase(name))
                .findFirst()
                .orElse("The color is not available in the app");
    }

    @PostMapping
    String post(@RequestBody String color) {
        colors.add(color);
        return color;
    }

    @PutMapping("/{target}")
    String put(@PathVariable String target, @RequestBody String newColor) {
        colors.remove(target);
        colors.add(newColor);
        return newColor;
    }

    @DeleteMapping
    void deleteAll() {
        colors.clear();
    }

    @DeleteMapping("/{name}")
    void deleteOne(@PathVariable String name) {
        colors.remove(name);
    }
}
