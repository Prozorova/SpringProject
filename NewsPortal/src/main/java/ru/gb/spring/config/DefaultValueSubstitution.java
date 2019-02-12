package ru.gb.spring.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import ru.gb.spring.entity.UnproducableAmmunition;

@Component
@PropertySource("classpath:config.properties")
public class DefaultValueSubstitution implements BeanFactoryPostProcessor {
	

	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		
		String[] beanDefinitionNames = beanFactory.getBeanDefinitionNames();
		
		for (String name: beanDefinitionNames) {
			
			BeanDefinition beanDef = beanFactory.getBeanDefinition(name);
			String clazz = beanDef.getBeanClassName();
			
			if (clazz != null) {
				try {
					Class<?> beanClass = Class.forName(clazz);
					UnproducableAmmunition annotation = beanClass.getAnnotation(UnproducableAmmunition.class);
					
					if (annotation != null) {
						beanDef.setBeanClassName(annotation.defaultAmmo().getName());
						System.out.println(beanClass.getSimpleName() + " is not available any more, replacing with " + 
											annotation.defaultAmmo().getSimpleName());
					}
					
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
