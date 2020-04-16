package academy.everyonecodes.mongorockscissorspaper.logic;

import academy.everyonecodes.mongorockscissorspaper.domain.GameResult;
import academy.everyonecodes.mongorockscissorspaper.repository.GameResultRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameResultManager {

    private final GameResultRepository gameResultRepository;


    public GameResultManager(GameResultRepository gameResultRepository) {
        this.gameResultRepository = gameResultRepository;
    }

    public void saveResult(String result) {
        GameResult gameResult = new GameResult(result);
        gameResultRepository.save(gameResult);
    }

    public List<GameResult> findAll() {
        return gameResultRepository.findAll();
    }
    public void deleteAll(){
        gameResultRepository.deleteAll();
    }

}
