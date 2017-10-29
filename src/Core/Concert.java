package Core;

import java.util.*;

public class Concert extends Event {
	static long noTickets;
	public long price,numSpo,numDj;
	public String theme,details;
	public String[] sponsors,dJ;

	public void additional(){
   		Scanner scan = new Scanner(System.in);

   		System.out.print("Enter the theme of the concert: ");
   		theme = scan.nextLine();

   		System.out.print("Enter a summary of the concert: ");
   		details = scan.nextLine();

   		System.out.print("Enter the number of DJ's performing: ");
   		numDj = scan.nextInt();

   		for(int i=0;i<numDj;++i){
   			System.out.print("Enter the name of DJ no."+(i+1)+": ");
   			dJ[i] = new String();
   			dJ[i] = scan.nextLine();
   		}

   		System.out.print("Enter the number of sponsors: ");
   		numSpo = scan.nextInt();

   		for(int i=0;i<numSpo;++i){
   			System.out.print("Enter sponsor no."+(i+1)+": ");
   			sponsors[i] = new String();
   			sponsors[i] = scan.nextLine();
   		}

   		System.out.print("Enter the number of tickets available: ");
   		noTickets = scan.nextLong();

		System.out.print("Enter the price of a ticket: ");
		price = scan.nextLong();   		
   	}
}
