package com.xy.tools.hotelreservation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.xy.tools.hotelreservation.menu.MenuScreen;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext appContext = SpringApplication.run(Application.class, args);
		System.out.println("Hello World!");
		MenuScreen reservationMenu = appContext.getBean(MenuScreen.class);
		reservationMenu.reservationMenu();
	}

}
