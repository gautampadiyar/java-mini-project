package Core;

import java.util.*;

public class Hackathon extends Event{
   	public String info;
   	public ArrayList<String> sponsors,themes;
   	long cash1,cash2,cash3;

   	public void additional(){
   		Scanner scan = new Scanner(System.in);
   		String temp;
   		char choice = 'Y';
                long i=1;

   		sponsors = new ArrayList<String>();
   		themes = new ArrayList<String>();

   		System.out.print("Hackathon information: ");
   		info = scan.nextLine();

   		System.out.println("Themes: ");
   		while(choice!='N'){
                        System.out.print("Theme "+i+": ");
   			temp = scan.nextLine();
   			themes.add(temp);
   			System.out.print("Do you wish to continue?(Y/N): ");
   			choice = scan.next().charAt(0);
                        scan.nextLine();
                        i++;
   		}

   		choice = 'Y';
                i=1;

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

   		System.out.println("Enter the cash prize for the winner: ");
   		cash1 = scan.nextLong(); 

   		System.out.println("Enter the cash prize for the first runner up: ");
   		cash2 = scan.nextLong();

   		System.out.println("Enter the cash prize for the second runner up: ");
   		cash3 = scan.nextLong();
   	}
        
        public void showAdditional(){
            System.out.println("HACKATHON INFORMATION\n"+info);
            
            System.out.println("\nTHEMES");
            for(String x:themes)
                System.out.println(x);
            
            System.out.println("\nSPONSORS");
            for(String x:sponsors)
                System.out.println(x);
            
            System.out.println("\nCASH PRIZE 1: "+cash1+"\nCASH PRIZE 2: "+cash2+"\nCASH PRIZE 3: "+cash3+"\n");
        }
}
