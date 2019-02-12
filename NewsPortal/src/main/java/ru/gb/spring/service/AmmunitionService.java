package ru.gb.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import ru.gb.spring.entity.Ammunition;
import ru.gb.spring.entity.Round56;

@Component
public class AmmunitionService {
	
	@Autowired
	private ApplicationContext appContext;
	
	public enum AmmoTypes {
		ROUND10,
		ROUND20,
		ROUND56
	}
	
	//считаем, что Round20 нет в наличии, вместо него берем Round10
	private int amountRound10;
	private int amountRound56;
	
	
	@Value( "${amountRound10}" )
	private void setAmountRound10(String amountRound10) {
		this.amountRound10 = Integer.parseInt(amountRound10);
		System.out.println("Ammunition Round10 available: " + amountRound10);
	}
	
	@Value( "${amountRound56}" )
	private void setAmountRound56(String amountRound56) {
		this.amountRound56 = Integer.parseInt(amountRound56);
		System.out.println("Ammunition Round5.6 available: " + amountRound56);
	}
	
	
	public void addAmmo(Rifle rifle, AmmoTypes type) throws Exception {
		
		Ammunition newAmmo = null;
		int currentAmount = 0;
		
		switch (type) {
			case ROUND10:
				if (amountRound10 > 0) {
					amountRound10--;
					newAmmo = appContext.getBean("Round10", Ammunition.class);
					currentAmount = amountRound10;
				} else
					throw new Exception("no required ammunition is available");
				break;
			case ROUND20:
				if (amountRound10 > 0) {
					amountRound10--;
					newAmmo = appContext.getBean("Round20", Ammunition.class);
					currentAmount = amountRound10;
				} else
					throw new Exception("no required ammunition is available");
				break;
			case ROUND56:
				if (amountRound56 > 0) {
					amountRound56--;
					newAmmo = appContext.getBean(Round56.class);
					currentAmount = amountRound56;
				} else
					throw new Exception("no required ammunition is available");
				break;
			default:
				throw new Exception("unknown ammunition in request");
		}
		
		System.out.println("Round[" + newAmmo.getCalibre() + "] left: " + currentAmount);
		rifle.setAmmunition(newAmmo);
		System.out.println("Round[" + newAmmo.getCalibre() + "] added to rifle " + rifle);
	}
	
}
 