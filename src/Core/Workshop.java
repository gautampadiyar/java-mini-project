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
                long i=1;
                
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
                        System.out.print("Sponsor "+i+": ");
   			temp = scan.nextLine();
   			sponsors.add(temp);
   			System.out.print("Do you wish to continue?(Y/N): ");
   			choice = scan.next().charAt(0);
                        scan.nextLine();
                        i++;
   		}
	}
        
        public void showAdditional(){
            System.out.println("\nWORKSHOP INFORMATION\n"+info);
            
            System.out.println("\nTHEME\n"+theme);
            
            System.out.println("\nSPONSORS");
            for(String x:sponsors)
                System.out.println(x);
            
            System.out.println("\nNUMBER OF SEATS AVAILABLE"+noSeats);
            
            System.out.println("\nNUMBER OF MEMBERS PER GROUP"+groupSize+"\n");
        }
}
