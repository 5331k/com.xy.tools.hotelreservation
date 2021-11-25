package com.xy.tools.hotelreservation.menu;

import java.util.Scanner;

import org.springframework.stereotype.Component;

import com.xy.tools.hotelreservation.process.ReservationProcessor;
import com.xy.tools.hotelreservation.reserve.ReserveEntity;

@Component
public class MenuScreen {

	public void reservationMenu() {
		System.out.println("*** Welcome to hotel reservation ***");

		ReservationProcessor reservationProcessor = new ReservationProcessor();
		boolean isRoomsCreated = false;
		while (!isRoomsCreated) {
			isRoomsCreated = reservationProcessor.createNewRooms(createRoomsMenu());
		}

		int choice = 0;
		while (choice != 3) {
			choice = mainMenu();
			switch (choice) {
			case 1:
				ReserveEntity reserveEntity = reserveMenu();
				boolean result = reservationProcessor.reserveRoom(reserveEntity);
				break;
			case 2:
				reservationProcessor.createNewRooms(createRoomsMenu());
				break;
			case 3:
				break;
			default:
				System.out.println("Invalid input!");
				break;
			}
		}
	}

	public int createRoomsMenu() {
		System.out.print("Please provide total rooms: ");
		Scanner input = new Scanner(System.in);
		return input.nextInt();
	}

	public ReserveEntity reserveMenu() {
		Scanner input = new Scanner(System.in);
		System.out.println("*** Make reservation");

		System.out.println("1 - Make a room reservation");
		System.out.println("2 - To overwrite rooms and create new rooms, (Note:-This will erase all previous data)");
		System.out.println("3 - Exit");

		System.out.print("Please enter start day of reservation (0 - 364): ");
		int startDay = input.nextInt();
		System.out.print("Please enter end day of reservation (0 - 364): ");
		int endDay = input.nextInt();
		return new ReserveEntity(startDay, endDay);
	}

	public int mainMenu() {
		Scanner input = new Scanner(System.in);
		System.out.println("***************************************************************************************");
		System.out.println("1 - Make a room reservation");
		System.out.println("2 - To overwrite rooms and create new rooms, (Note:-This will erase all previous data)");
		System.out.println("3 - Exit");
		System.out.println("***************************************************************************************");
		return input.nextInt();
	}
}
