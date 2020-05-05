package academy.everyonecodes.smallbusiness.scheduler;

import academy.everyonecodes.smallbusiness.logic.ShopService;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
public class OpeningHoursScheduler {

    private final ShopService shopService;

    public OpeningHoursScheduler(ShopService shopService) {
        this.shopService = shopService;
    }

    @Scheduled(cron = "${shop.opening}")
    public void open() {
        shopService.open();
    }

    @Scheduled(cron = "${shop.closing}")
    public void close() {
        shopService.close();
    }

    @Scheduled(fixedRateString = "${shop.rate}")
    public void openAndClose() {
        if (shopService.isOpen()) {
            shopService.close();
        } else {
            shopService.open();

        }
    }
}
