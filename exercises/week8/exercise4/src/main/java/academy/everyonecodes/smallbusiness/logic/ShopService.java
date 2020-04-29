package academy.everyonecodes.smallbusiness.logic;

import org.springframework.stereotype.Service;

@Service
public class ShopService {

    private boolean isOpen = false;

    public boolean isOpen() {
        return isOpen;
    }

    public void open(){
        isOpen = true;
    }

    public void close() {
        isOpen = false;
    }
}
