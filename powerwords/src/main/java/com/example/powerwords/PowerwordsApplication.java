package com.example.powerwords;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class PowerwordsApplication {

	public static void main(String[] args) {
		SpringApplication.run(PowerwordsApplication.class, args);
	}
	
	/*
    @Autowired
    ReservationDao reservationDao;

    // Insert data at initailizing phase using ReservationDao#insert
    @Bean
    CommandLineRunner runner() {
        return args -> Arrays.asList("spring", "spring boot", "spring cloud", "doma").forEach(s -> {
            Reservation r = new Reservation();
            r.name = s;
            reservationDao.insert(r);
        });
    }

    @RequestMapping(path = "/")
    List<Reservation> all() {
        return reservationDao.selectAll();
    }
    */
    
}

