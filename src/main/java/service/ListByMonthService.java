package service;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import entity.Tickets;
import persistence.ITicketsDao;

public class ListByMonthService extends MenuService {

	@Override
	public void executeUC(Scanner scanner, ITicketsDao dao) {
		System.out.println("Enter the the name of the month in english");
		String getListByName = scanner.next().toUpperCase();
		List<Tickets> ticketList = dao.findAllTicketsByMonth(getListByName);
		Iterator<Tickets> ticket = ticketList.iterator();
		{
			while (ticket.hasNext()) {

				System.out.println(" " + ticket.next());
			}
		}

	}
		
	}