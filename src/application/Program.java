package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		
		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Room number: ");
		int roomNumber = sc.nextInt();
		System.out.print("Check-in date (dd/MM/yyyyy): ");
		Date checkIn = sdf.parse(sc.next());
		System.out.print("Check-out date (dd/MM/yyyyy): ");
		Date checkOut = sdf.parse(sc.next());
		
		if(checkIn.after(checkOut)) {
			System.out.println("Error in reservation: Check-out date must be after check-in date.");
		}
		else {
			Reservation reservation = new Reservation(roomNumber, checkIn, checkOut);
			System.out.println(reservation);
			System.out.println();
			System.out.println("Enter data to update the reservation: ");
			System.out.print("Check-in date (dd/MM/yyyyy): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Check-out date (dd/MM/yyyyy): ");
			checkOut = sdf.parse(sc.next());
			System.out.println(reservation.getCheckIn());
			System.out.println(checkIn);
			
			if(!reservation.getCheckIn().before(checkIn) || reservation.getCheckOut().before(checkOut)) {
				System.out.println("Error in reservation: Reservation dates for update must be future dates.");
			} 
			else if(!checkIn.after(reservation.getCheckIn()) && !checkOut.after(reservation.getCheckOut())) {
				System.out.println("Error in reservation: Check-out date must be after check-in date.");
			}
			else {
				reservation.updateDates(checkIn, checkOut);
				System.out.print(reservation);
			}
		sc.close();
		}

	}
}