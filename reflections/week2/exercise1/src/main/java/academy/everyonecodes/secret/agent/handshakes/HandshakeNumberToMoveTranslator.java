package academy.everyonecodes.secret.agent.handshakes;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@ConfigurationProperties("secretagent")
public class HandshakeNumberToMoveTranslator {

    private List<Handshake> handshakes;

    public void setHandshakes(List<Handshake> handshakes) {
        this.handshakes = handshakes;
    }

    public Optional<String> translate(int number) {
        return handshakes.stream()
                .filter(handshake -> handshake.getNumber() == number)
                .map(Handshake::getMove)
                .findFirst();
    }
}
