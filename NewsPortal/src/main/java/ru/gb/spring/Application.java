package ru.gb.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ru.gb.spring.config.ApplicationConfig;
import ru.gb.spring.service.AmmunitionService;
import ru.gb.spring.service.AmmunitionService.AmmoTypes;
import ru.gb.spring.service.Rifle;


public class Application {
	
	
	public static void main(String[] args) throws Exception {

		ApplicationContext appContext = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		AmmunitionService service = appContext.getBean(AmmunitionService.class);
		
		System.out.println("Start shooting");
		
		Rifle rifle = appContext.getBean("rifRound20", Rifle.class);
		rifle.checkAmmunitionCalibre();
		rifle.shoot();
		
		rifle = appContext.getBean("rifRound5.6", Rifle.class);
		rifle.checkAmmunitionCalibre();
		rifle.shoot();
		
		service.addAmmo(rifle, AmmoTypes.ROUND10);
		rifle.checkAmmunitionCalibre();
		rifle.shoot();
		
		service.addAmmo(rifle, AmmoTypes.ROUND20);
		rifle.checkAmmunitionCalibre();
		rifle.shoot();
	}

}
