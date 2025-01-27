package academy.everyonecodes.musicstation;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/songs")
public class MusicStationEndpoint {

    private final MusicStation musicStation;

    public MusicStationEndpoint(MusicStation musicStation) {
        this.musicStation = musicStation;
    }

    @GetMapping
    List<Song> getSongs() {
        return musicStation.findAll();
    }

    @GetMapping("/electronic")
    List<Song> getElectronic() {
        return musicStation.findBy("Electronic");
    }

    @GetMapping("/psychedelic rock")
    List<Song> getPsychedelic() {
        return musicStation.findBy("Psychedelic Rock");
    }

    @GetMapping("/son")
    List<Song> getSon() {
        return musicStation.findBy("Son");
    }

}
