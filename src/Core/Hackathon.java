package Core;

import java.util.*;

public class Hackathon extends Event{
    public String info;
    public ArrayList<String> sponsors,themes;
    long cash1,cash2,cash3;

    @Override
    public void getDetails(){
        Scanner scan = new Scanner(System.in);
        String temp;
        char choice = 'Y';
        long i=1;

        sponsors = new ArrayList<String>();
        themes = new ArrayList<String>();

        System.out.print("Hackathon information: ");
        info = scan.nextLine();

        System.out.println("Themes: ");
        while(choice == 'y'){
            System.out.print("Theme "+i+": ");
            temp = scan.nextLine();
            themes.add(temp);
            System.out.print("Do you wish to continue?(y/n) : ");
            choice = scan.next().charAt(0);
            scan.nextLine();
            i++;
        }

        choice = 'y';
        i=1;

        System.out.println("Sponsors: ");
        while(choice == 'y'){
            System.out.print("Sponsor "+i+": ");
            temp = scan.nextLine();
            sponsors.add(temp);
            System.out.print("Do you wish to continue?(y/n) : ");
            choice = scan.next().charAt(0);
            scan.nextLine();
            i++;
        }

        System.out.print("Enter the cash prize for the winner: ");
        cash1 = scan.nextLong(); 

        System.out.print("Enter the cash prize for the first runner up: ");
        cash2 = scan.nextLong();

        System.out.print("Enter the cash prize for the second runner up: ");
        cash3 = scan.nextLong();
    }
}
