package ru.gb.spring.entity;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("Round20")
@Scope("prototype")
@UnproducableAmmunition(defaultAmmo=Round10.class)
public class Round20 implements Ammunition {
	
	private final int calibre = 20;

	public double getCalibre() {
		return calibre;
	}
	
}
