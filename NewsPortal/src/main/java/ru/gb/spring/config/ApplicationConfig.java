package ru.gb.spring.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import ru.gb.spring.service.AmmunitionService;
import ru.gb.spring.service.AmmunitionService.AmmoTypes;
import ru.gb.spring.service.Rifle;

@Configuration
@ComponentScan("ru.gb.spring")
public class ApplicationConfig {
	
	@Autowired
	private AmmunitionService service;
	
	@Autowired
	@Bean("rifRound20")
	public Rifle getRifle20(@Qualifier("Rifle") Rifle rifle) throws Exception {
		return getRifleWithAmmo(rifle, AmmoTypes.ROUND20);
	}
	
	@Autowired
	@Bean("rifRound5.6")
	public Rifle getRifle56(@Qualifier("Rifle") Rifle rifle) throws Exception {
		return getRifleWithAmmo(rifle, AmmoTypes.ROUND56);
	}
	
	private Rifle getRifleWithAmmo(Rifle rifle, AmmoTypes type) throws Exception {
		service.addAmmo(rifle, type);
		return rifle;
	}
}
