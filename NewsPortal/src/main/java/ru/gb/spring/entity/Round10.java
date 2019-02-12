package ru.gb.spring.entity;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("Round10")
@Scope("prototype")
public class Round10 implements Ammunition {
	
	private final int calibre = 10;

	public double getCalibre() {
		return calibre;
	}

}
