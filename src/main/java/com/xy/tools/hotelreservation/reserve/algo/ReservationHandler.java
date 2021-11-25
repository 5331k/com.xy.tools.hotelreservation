package com.xy.tools.hotelreservation.reserve.algo;

import java.util.List;

import com.xy.tools.hotelreservation.persistence.entity.Reservation;
import com.xy.tools.hotelreservation.reserve.ReserveEntity;

public interface ReservationHandler {

	public final static int RESERVATION_DECLINED = -1;
	public final static int TOTAL_DAYS = 365;
	
	/**
	 * For each possible room where start day is free Check all the respective days
	 * until the end day
	 * 
	 * return a room number which is reserved, other wise return -1
	 * 
	 * @param reserveEntity
	 */
	int performReservation(ReserveEntity reserveEntity);

	boolean areAllDaysFree(int roomNumber, int startDay, int endDay);
	
	void markAllDaysReserved(int roomNumber, int startDay, int endDay);
	
	void loadReservations(List<Reservation> reservations);

}