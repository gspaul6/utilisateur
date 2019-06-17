package service;

import java.util.Scanner;

import persistence.ITicketsDao;



public abstract class MenuService {
	public abstract void executeUC(Scanner scanner, ITicketsDao dao);
}
