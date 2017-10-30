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

   		sponsors = new ArrayList<String>();
   		themes = new ArrayList<String>();

   		System.out.print("Hackathon information: ");
   		info = scan.nextLine();

   		System.out.println("Themes: ");
   		while(choice!='N'){
   			temp = scan.nextLine();
   			themes.add(temp);
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

   		System.out.println("Enter the cash prize for the winner: ");
   		cash1 = scan.nextLong(); 

   		System.out.println("Enter the cash prize for the first runner up: ");
   		cash2 = scan.nextLong();

   		System.out.println("Enter the cash prize for the second runner up: ");
   		cash2 = scan.nextLong();
   	}
}
