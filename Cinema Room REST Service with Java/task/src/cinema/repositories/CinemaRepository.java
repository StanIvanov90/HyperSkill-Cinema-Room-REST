package cinema.repositories;

import cinema.models.Seat;
import org.springframework.stereotype.Repository;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class CinemaRepository {

    private final Set<Seat> purchasedSeats = ConcurrentHashMap.newKeySet();

    public boolean isSeatPurchased(Seat seat) {
        return purchasedSeats.contains(seat);
    }

    public void purchaseSeat(Seat seat) {
        purchasedSeats.add(seat);
    }
}
