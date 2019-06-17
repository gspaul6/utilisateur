package persistence;


import java.time.LocalDate;
import java.util.List;

import entity.Tickets;

 
public interface ITicketsDao {
	List<Tickets> findAllTickets();

	void saveNewTikects(Tickets ticket);

	void updateTicket(LocalDate date, Tickets Ticket);

	void deleteTicket(LocalDate date);
	
	List<Tickets> findAllTicketsByMonth(String name);

	Tickets findTicketByDate(LocalDate date);

	boolean TicketExistSameDay(LocalDate date);

	
}
