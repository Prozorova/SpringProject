package ru.gb.spring.service;

import ru.gb.spring.entity.Ammunition;

public class AmmunitionService {
	
	public static void addAmmo(Rifle rifle, Ammunition newAmmo) {
		rifle.setAmmunition(newAmmo);
		System.out.println("Ammunition round[" + newAmmo.getCalibre() + "] added to rifle " + rifle);
	}
	
}
 