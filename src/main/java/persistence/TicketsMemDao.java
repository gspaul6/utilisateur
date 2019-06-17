package persistence;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dev.utilisateur.App;
import entity.Tickets;
import exception.NoPermissionException;


public class TicketsMemDao implements ITicketsDao {
	private static final Logger LOG = LoggerFactory.getLogger(TicketsMemDao.class);
	private List <Tickets> ticket;
	
	public TicketsMemDao(){
	List<Tickets> listTicket = new ArrayList<Tickets>();
	listTicket.add(new Tickets (LocalDate.of(2019,01, 15),"Paul",12.30));
	listTicket.add(new Tickets (LocalDate.of(2019, 02, 18),"Stella",22.30));
	listTicket.add(new Tickets (LocalDate.of(2019, 03, 12),"Hugo",10.60));
	listTicket.add(new Tickets (LocalDate.of(2019, 04, 16),"Nicolas",13.22));
	this.ticket = listTicket;
	}

	
	public List<Tickets> findAllTickets() {
		// TODO Auto-generated method stub
		return this.ticket;
	}


	public void saveNewTikects(Tickets ticket)throws NoPermissionException {
		try{
			boolean exist= this.TicketExistSameDay(ticket.getDate());
			if (!exist){
				this.ticket.add(ticket);
			}
		}
		catch(NoPermissionException e){
			LOG.info("you dont have the permission to entre two tickets for same day");
			LOG.error(e.getMessage());
		}
		
	}


	public List<Tickets> getTicket() {
		return ticket;
	}


	public void setTicket(List<Tickets> ticket) {
		this.ticket = ticket;
	}


	public void updateTicket(LocalDate date, Tickets ticket) {
		for (int i = 0; i < this.ticket.size(); i++) {
			if (this.ticket.get(i).getDate().compareTo(date)==0) {
				this.ticket.set(i, ticket);
			}
		}
		
	}


	public void deleteTicket(LocalDate date) {
		Iterator<Tickets> ticket = this.ticket.iterator();
		while (ticket.hasNext()) {
			Tickets tickNew = ticket.next();
			if (tickNew.getDate().compareTo(date)==0) {
				ticket.remove();
			}
		}		
	}

	public List<Tickets> findAllTicketsByMonth(String name){
		List<Tickets> tickNew = new ArrayList<Tickets>();
		Iterator<Tickets> ticket = this.ticket.iterator();
		while (ticket.hasNext()) {
			Tickets tickets = ticket.next();
			if (tickets.getDate().getMonth().name().equals(name)) {
				tickNew.add(tickets);
			}
		}
		return tickNew;
	}
	public Tickets findTicketByDate(LocalDate date){
		Tickets tickNew = null;
	    for (int i = 0; i < this.ticket.size(); i++)
			if (this.ticket.get(i) != null && this.ticket.get(i).getDate().compareTo(date)==0) {
				tickNew = this.ticket.get(i);
				System.out.println("The pizza you are searching for, is here-->" + this.ticket.get(i).toString());
			}
		return tickNew;
	}
	
	public boolean TicketExistSameDay(LocalDate date) {
		for (int i = 0; i < this.ticket.size(); i++)
			if (this.ticket.get(i) != null && this.ticket.get(i).getDate().compareTo(date)==0) {
				return true;
			}
		return false;
	}
	
	

	

}
