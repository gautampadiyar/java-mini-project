package Core;

import java.util.*;

public class Hackathon extends Event{
   	public String theme,details;
   	public String[] sponsors;
   	long cash1,cash2,cash3,numSpo;

   	public void additional(){
   		Scanner scan = new Scanner(System.in);

   		System.out.print("Enter the theme: ");
   		theme = scan.nextLine();

   		System.out.print("Enter a summary of the hackathon: ");
   		details = scan.nextLine();

   		System.out.print("Enter the number of sponsors: ");
   		numSpo = scan.nextInt();

   		for(int i=0;i<numSpo;++i){
   			System.out.print("Enter sponsor no."+(i+1)+": ");
   			sponsors[i] = new String();
   			sponsors[i] = scan.nextLine();
   		}

   		System.out.println("Enter the cash prize for the winner: ");
   		cash1 = scan.nextLong(); 

   		System.out.println("Enter the cash prize for the first runner up: ");
   		cash2 = scan.nextLong();

   		System.out.println("Enter the cash prize for the second runner up: ");
   		cash2 = scan.nextLong();
   	}
}
