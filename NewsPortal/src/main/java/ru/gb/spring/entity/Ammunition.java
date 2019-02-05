package ru.gb.spring.entity;

import org.springframework.context.annotation.PropertySource;

@PropertySource("classpath:config.properties")
public interface Ammunition {
	
	/**
	 * Получить калибр патрона
	 * @return калибр
	 */
	public abstract double getCalibre();
	
	
}
