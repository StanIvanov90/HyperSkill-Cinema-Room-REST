package cinema.configurations;

import cinema.models.CinemaRoom;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CinemaConfiguration {

    @Bean
    public CinemaRoom cinemaRoom() {
        return new CinemaRoom(9, 9);
    }
}
