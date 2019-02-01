package ru.gb.spring.entity;

import org.springframework.stereotype.Component;

@Component("Round56")
public class Round56 implements Ammunition{
	
	private final double calibre = 5.6;

	public double getCalibre() {
		return calibre;
	}

}
