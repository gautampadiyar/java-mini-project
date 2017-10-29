package Core;

import java.util.*;

public class Concert extends Event {
	static long noTickets;
	public long price;
	public String info;
	public ArrayList<String> sponsors,dJ,themes;

	public void additional(){
   		Scanner scan = new Scanner(System.in);
   		char choice = 'Y';
   		String temp;

   		sponsors = new ArrayList<String>();
   		dJ = new ArrayList<String>();
   		themes = new ArrayList<String>();

		System.out.println("Concert information: ");
   		info = scan.nextLine();

		System.out.print("Enter the number of tickets available: ");
   		noTickets = scan.nextLong();

		System.out.print("Enter the price of a ticket: ");
		price = scan.nextLong(); 

   		System.out.println("Themes: ");
   		while(choice!='N'){
   			temp = scan.nextLine();
   			themes.add(temp);
   			System.out.print("Do you wish to continue?(Y/N): ");
   			choice = scan.next().charAt(0);
   		}

   		choice = 'Y';

   		System.out.println("DJ: ");
   		while(choice!='N'){
   			temp = scan.nextLine();
   			dJ.add(temp);
   			System.out.print("Do you wish to continue?(Y/N): ");
   			choice = scan.next().charAt(0);
		}

		choice = 'Y';

		System.out.println("Sponsors: ");
   		while(choice!='N'){
   			temp = scan.nextLine();
   			sponsors.add(temp);
   			System.out.print("Do you wish to continue?(Y/N): ");
   			choice = scan.next().charAt(0);
		}  		
   	}
}
