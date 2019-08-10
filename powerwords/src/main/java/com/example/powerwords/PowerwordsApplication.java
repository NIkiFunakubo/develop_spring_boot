package com.example.powerwords;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.powerwords.dao.ReservationDao;
import com.example.powerwords.entity.Reservation;

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

