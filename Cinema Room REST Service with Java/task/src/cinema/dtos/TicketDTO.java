package cinema.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class TicketDTO {

    private UUID token;
    private SeatDTO ticket;

    public TicketDTO(UUID token, SeatDTO ticket) {
        this.token = token;
        this.ticket = ticket;
    }

    public UUID getToken() {
        return token;
    }

    public SeatDTO getTicket() {
        return ticket;
    }
}
