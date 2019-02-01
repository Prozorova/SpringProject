package ru.gb.spring.entity;

import org.springframework.stereotype.Component;

@Component("Round10")
public class Round10 implements Ammunition {
	
	private final int calibre = 10;

	public double getCalibre() {
		return calibre;
	}

}
