package dev.utilisateur;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import exception.DataAccessException;
import persistence.ITicketsDao;
import persistence.TicketsMemDao;
import service.AddService;
import service.DeleteService;
import service.ListByMonthService;
import service.ListService;
import service.UpdateService;

/**
 * Hello world!
 *
 */
public class App {
	private static final Logger LOG = LoggerFactory.getLogger(App.class);
	public static Scanner scan = new Scanner(System.in);
	public static ITicketsDao ticketDao = new TicketsMemDao();

	public static void showmenu() {
		submenu();
		LOG.info("1. List Tickets" + "\n" + "2. Add Tickets" + "\n" + "3. Modify Tickets" + "\n" + "4. Delete Tickets"
				+ "\n" + "5. Total in a Month" + "\n" +
				// "6. Total in general"+ "\n"+
				"99. Exit");
	}

	public static void submenu() {
		System.out.println("***** Ticket Administration *****");
	}
	
	public static void exitTickets() {
		submenu();
		LOG.info("Au revoir ☹");
	}

	public static void main(String[] args) {
		boolean game = true;
		while (game) {
			try {

				showmenu();
				System.out.println("Enter your choice");
				Integer a = Integer.parseInt(scan.next());
				switch (a) {
				case 1:
					ListService list = new ListService();
					list.executeUC(scan, ticketDao);
					break;

				case 2:
					AddService add = new AddService();
					add.executeUC(scan, ticketDao);
					break;

				case 3:
					UpdateService update = new UpdateService();
					update.executeUC(scan, ticketDao);
					break;

				case 4:
					DeleteService del = new DeleteService();
					del.executeUC(scan, ticketDao);
					break;

				case 5:
					ListByMonthService listByMonth = new ListByMonthService();
					listByMonth.executeUC(scan, ticketDao);
					break;

				case 99:
					exitTickets();
					game = false;
					LOG.info("Les services Ticket ont bien été fermés");
					break;
				}
			} catch (DataAccessException e) {
				LOG.error(e.getMessage());
			} catch (Exception e) {
				LOG.error(e.getMessage());
			}

		}
		scan.close();
	}

}
