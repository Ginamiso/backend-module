package academy.everyonecodes.smallbusiness.logic;

public class ShopService {

    private boolean isOpen;

    public ShopService(boolean isOpen) {
        this.isOpen = isOpen;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void open() {
        isOpen = true;
    }

    public void close() {
        isOpen = false;
    }
}
