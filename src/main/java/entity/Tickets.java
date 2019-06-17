package entity;

import java.time.LocalDate;
import java.util.Date;

public class Tickets {
	
	private LocalDate date;
	private String intitule;
	private double montant;
	
		
	public Tickets() {}

	public Tickets(LocalDate date, String intitule, double montant) {
		this.date = date;
		this.intitule = intitule;
		this.montant = montant;
	}
// getters and setters
	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getIntitule() {
		return intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}
	@Override
	public String toString() {
		
		return this.date + "|" + this.intitule + "|" + this.montant ;
	}
	
}
