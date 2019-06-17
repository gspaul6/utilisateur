package service;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import entity.Tickets;
import persistence.ITicketsDao;

public class ListService extends MenuService {

	@Override
	public void executeUC(Scanner scanner, ITicketsDao dao) {
		List<Tickets> ticketList = dao.findAllTickets();
		Iterator<Tickets> ticket = ticketList.iterator();
		{
			while (ticket.hasNext()) {

				System.out.println(" " + ticket.next());
			}
		}

	}
		
	}


