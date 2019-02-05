package ru.gb.spring.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import ru.gb.spring.entity.Ammunition;

@Component("Rifle")
@Scope("prototype")
public class Rifle {
	
	private static final String NAME_CONSTRUCTOR = "Rifle_%d";
	private static int INDEX = 1;

	private Ammunition ammunition;
	private final String name;
	
	public Rifle() {
		this.name = String.format(NAME_CONSTRUCTOR, INDEX++);
	}

	@Override
	public String toString() {
		return name;
	}

	public void checkAmmunitionCalibre() {
		System.out.println("Ammunition in " + this.toString() + ": round " + ammunition.getCalibre());
	}

	void setAmmunition(Ammunition ammunition) {
		this.ammunition = ammunition;
	}
	
	public void shoot() throws Exception {
		
		if (ammunition != null)
			System.out.println(this.toString() + " shoot");
		else
			throw new Exception("No ammunition!");
	}
	
}
