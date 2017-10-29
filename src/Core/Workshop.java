package Core;

import java.util.*;

public class Workshop extends Event {
        static long noSeats,groupSize;
	public String theme,info;
	public ArrayList<String> sponsors;

	public void additional(){
		Scanner scan = new Scanner(System.in);
		String temp;
		char choice = 'Y';
                
                sponsors = new ArrayList<String>();

   		System.out.print("Theme of the workshop: ");
   		theme = scan.nextLine();

   		System.out.print("Workshop information: ");
   		info = scan.nextLine();

   		System.out.print("Number of seats available: ");
   		noSeats = scan.nextLong();

   		System.out.print("Number of people required per group: ");
   		groupSize = scan.nextLong();

   		System.out.println("Sponsors: ");
   		while(choice!='N'){
   			temp = scan.nextLine();
   			sponsors.add(temp);
   			System.out.print("Do you wish to continue?(Y/N): ");
   			choice = scan.next().charAt(0);
   		}
	}
}
