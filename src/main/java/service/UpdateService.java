package service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import entity.Tickets;
import persistence.ITicketsDao;

public class UpdateService extends MenuService {

	@Override
	public void executeUC(Scanner scanner, ITicketsDao dao) {
		List<Tickets> ticket = dao.findAllTickets();
		Iterator<Tickets> tickNew = ticket.iterator();
		{
			while (tickNew.hasNext()) {

				System.out.println(" " + tickNew.next());
			}
		}
		System.out.println("Enter the date in yyyy-MM-dd of the Ticket you wanna delete");
		String getTicket = scanner.next();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate localDate = LocalDate.parse(getTicket, formatter);
		String intitule;
		String price;
		System.out.println("enter a string stating the title");
		intitule = scanner.next();
		System.out.println("enter price ");
		price = scanner.next();
		double montant = Double.parseDouble(price);
		Tickets updateTicket = new Tickets(localDate,intitule,montant);
		dao.updateTicket(localDate, updateTicket);
		
	}
}
