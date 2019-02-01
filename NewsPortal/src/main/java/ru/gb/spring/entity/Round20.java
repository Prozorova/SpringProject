package ru.gb.spring.entity;

import org.springframework.stereotype.Component;

@Component("Round20")
public class Round20 implements Ammunition{
	
	private final int calibre = 20;

	public double getCalibre() {
		return calibre;
	}

}
