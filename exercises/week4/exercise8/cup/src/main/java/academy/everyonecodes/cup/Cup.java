package academy.everyonecodes.cup;

import org.springframework.stereotype.Service;

@Service
public class Cup {

    private boolean hasCoin = false;

    public boolean hasCoin(){
        return hasCoin;
    }
    public void putCoin(){
         hasCoin = true;
    }
    public void removeCoin(){
        hasCoin = false;
    }
}
