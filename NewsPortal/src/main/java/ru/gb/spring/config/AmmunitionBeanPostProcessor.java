package ru.gb.spring.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import ru.gb.spring.entity.Ammunition;

@Component
public class AmmunitionBeanPostProcessor implements BeanPostProcessor {

	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		
		if (bean instanceof Ammunition) {
			Ammunition round = (Ammunition) bean;
			System.out.println("Getting round[" + round.getCalibre() + "]");
		}
		return bean;
	}


}
