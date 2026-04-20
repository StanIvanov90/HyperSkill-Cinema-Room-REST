package cinema.repositories;

import cinema.models.Seat;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class CinemaRepository {

    private final Set<Seat> purchasedSeats = ConcurrentHashMap.newKeySet();
    private final Map<UUID, Seat> purchasedTickets = new ConcurrentHashMap<>();

    public boolean isSeatPurchased(Seat seat) {
        return purchasedSeats.contains(seat);
    }

    public void purchaseSeat(Seat seat) {
        purchasedSeats.add(seat);
    }

    public void removeSeat(Seat seat) {
        purchasedSeats.remove(seat);
    }

    public void purchaseTicket(UUID token, Seat seat) {
        purchasedTickets.put(token, seat);
    }

    public void removeTicket(UUID token) {
        purchasedTickets.remove(token);
    }

    public boolean isTicketPurchased(UUID token) {
        return purchasedTickets.containsKey(token);
    }

    public Seat getTicket(UUID token) {
        return purchasedTickets.get(token);
    }

}