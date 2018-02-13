package ru.myproject.firstaidkit.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@Configuration
@ComponentScan(basePackages = "ru.myproject.firstaidkit")
public class AppConfig {

    @Bean
    public EntityManagerFactory getEmf() {
        return Persistence.createEntityManagerFactory("TestUnitH2");
    }

    @Bean
    public EntityManager getEm(EntityManagerFactory emf) {
        return emf.createEntityManager();
    }


    @Bean
    public ViewResolver getViewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/");
        resolver.setSuffix(".jsp");
        resolver.setViewClass(JstlView.class);

        return resolver;
    }

}
