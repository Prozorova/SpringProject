package ru.gb.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ru.gb.spring.config.ApplicationConfig;
import ru.gb.spring.entity.Ammunition;
import ru.gb.spring.service.AmmunitionService;
import ru.gb.spring.service.Rifle;


public class Application {
	
	public static void main(String[] args) throws Exception {
		
		ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		
		System.out.println("Start shooting");
		
		Rifle rifle = context.getBean("rifRound10", Rifle.class);
		rifle.checkAmmunitionCalibre();
		rifle.shoot();
		
		
		rifle = context.getBean("rifRound5.6", Rifle.class);
		rifle.checkAmmunitionCalibre();
		rifle.shoot();
		
		AmmunitionService.addAmmo(rifle, context.getBean("Round20", Ammunition.class));
		rifle.checkAmmunitionCalibre();
		rifle.shoot();
	}

}
