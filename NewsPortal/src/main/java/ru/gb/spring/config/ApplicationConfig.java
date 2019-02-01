package ru.gb.spring.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import ru.gb.spring.entity.*;
import ru.gb.spring.service.AmmunitionService;
import ru.gb.spring.service.Rifle;

@Configuration
@ComponentScan("ru.gb.spring.entity")
public class ApplicationConfig {
	
	@Autowired
	@Qualifier("Round10")
	Round10 round10;
	
	@Autowired
	@Qualifier("Round20")
	Round20 round20; 
	
	@Autowired
	@Qualifier("Round56")
	Round56 round56; 

	@Bean("rifRound10")
	public Rifle getRifle10() {
		
		Rifle rifle = new Rifle();
		AmmunitionService.addAmmo(rifle, round10);
		return rifle;
	}
	
	@Bean("rifRound20")
	public Rifle getRifle20() {
		
		Rifle rifle = new Rifle();
		AmmunitionService.addAmmo(rifle, round20);
		return rifle;
	}
	
	@Bean("rifRound5.6")
	public Rifle getRifle56() {
		
		Rifle rifle = new Rifle();
		AmmunitionService.addAmmo(rifle, round56);
		return rifle;
	}
}
