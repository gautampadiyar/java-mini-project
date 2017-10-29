package Core;

import java.util.*;

public class Workshop extends Event {
    static long noSeats,groupSize;
	public long numSpo;
	public String theme,details,department;
	public String[] sponsors;

	public void additional(){
		Scanner scan = new Scanner(System.in);

   		System.out.print("Enter the theme of the workshop: ");
   		theme = scan.nextLine();

   		System.out.print("Enter a summary of the workshop: ");
   		details = scan.nextLine();

   		System.out.print("Enter the organising department: ");
   		department = scan.nextLine();

   		System.out.print("Enter the number of seats available: ");
   		noSeats = scan.nextLong();

   		System.out.print("Enter the number number of people required per group: ");
   		groupSize = scan.nextLong();

   		System.out.print("Enter the number of sponsors: ");
   		numSpo = scan.nextInt();

		for(int i=0;i<numSpo;++i){
   			System.out.print("Enter sponsor no."+(i+1)+": ");
   			sponsors[i] = new String();
   			sponsors[i] = scan.nextLine();
   		}
	}
}
