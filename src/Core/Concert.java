package Core;

import java.util.*;

public class Concert extends Event {
    static long noTickets;
    public long price;
    public String info;
    public ArrayList<String> sponsors,dJ,themes;

    @Override
    public void getDetails(){
        super.getDetails();
        Scanner scan = new Scanner(System.in);
        char choice = 'Y';
        String temp;
        long i=1;

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
            System.out.print("Theme "+i+": ");
            temp = scan.nextLine();
            themes.add(temp);
            System.out.print("Do you wish to continue?(y/n) : ");
            choice = scan.next().charAt(0);
            scan.nextLine();
            i++;
        }

        choice = 'Y';
        i=1;

        System.out.println("DJ: ");
        while(choice!='N'){
            System.out.print("DJ "+i+": ");
            temp = scan.nextLine();
            dJ.add(temp);
            System.out.print("Do you wish to continue?(y/n) : ");
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
    }
}
