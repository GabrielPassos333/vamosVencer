package com.fatec.vamosVencer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * Classe VamosVencerApplication
 */
@SpringBootApplication
public class VamosVencerApplication {

	/**
	 * Método main
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(VamosVencerApplication.class, args);
	}

	 // Método para imprimir mensagem no console a cada 13 minutos
    @Scheduled(fixedRate = 780000) // 780000 ms = 13 minutos
    public void keepAlive() {
        System.out.println("O servidor está ativo - " + java.time.LocalTime.now());
    }

}
