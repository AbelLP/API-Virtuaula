package com.example.apivirtuaula.schedule;

import com.example.apivirtuaula.repository.ReservasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Component
public class ReservaScheduler {

    @Autowired
    private ReservasRepository reservasRepository;

    @Scheduled(cron = "0 59 23 * * ?")
    public void caducarReservas() {
        LocalDateTime currentDate = LocalDateTime.now();
        reservasRepository.caducarReservas(currentDate);
    }

}
