package service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import entity.Tickets;
import persistence.ITicketsDao;

public class AddService extends MenuService {

	@Override
	public void executeUC(Scanner scanner, ITicketsDao dao) {
		String intitule;
		String price;
		System.out.println("Enter the date in the given format yyyy-MM-dd ");
		String getTicket = scanner.next();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate localDate = LocalDate.parse(getTicket, formatter);
		System.out.println("enter a string stating the title");
		intitule = scanner.next();
		System.out.println("enter price ");
		price = scanner.next();
		double montant = Double.parseDouble(price);
		Tickets newTicket = new Tickets(localDate,intitule,montant);
		dao.saveNewTikects(newTicket);
	}

}
