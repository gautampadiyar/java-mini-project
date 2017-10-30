package Core;

import java.util.*;

public class Workshop extends Event {
    static long noSeats,groupSize;
    public String theme,info;
    public ArrayList<String> sponsors;

    @Override
    public void getDetails(){
        super.getDetails();
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
        while(choice == 'y'){
            System.out.print("Sponsor "+i+": ");
            temp = scan.nextLine();
            sponsors.add(temp);
            System.out.print("Do you wish to continue?(y/n): ");
            choice = scan.next().charAt(0);
            scan.nextLine();
            i++;
        }
    }
}
