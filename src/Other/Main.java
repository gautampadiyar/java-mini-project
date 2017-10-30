package Other;

import Core.*;
import java.util.*;

/**
 *
 * @author temutai
 */
public class Main {
    public static ArrayList<Event> events = new ArrayList<>();
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        String admin = "TechFest", password = "TechFest@12345";
        String username,pass;
        int admin_user,eventChoice = 10,create;
        
        System.out.print("1.Admin\n2.Attendee\nEnter your choice: ");
        admin_user = scan.nextInt();
        
        if(admin_user == 1){
            System.out.print("\nUsername: ");
            username = scan.next();
            System.out.print("Password: ");
            pass = scan.next();
            
            if(username.equals(admin) && pass.equals(password)){
                System.out.print("\n1.Create Event\n2.Logout\nEnter your choice: ");
                eventChoice = scan.nextInt();
            
                while(eventChoice!=3){
                    switch(eventChoice){
                        case 1:System.out.print("\n1.Create Hackathon\n2.Create Concert\n3.Create Workshop\nEnter your choice: ");
                               create = scan.nextInt();
                                if(create == 1)
                                    createHackathon(events);
                                else if(create == 2)
                                    createConcert(events);
                                else if(create == 3)
                                    createWorkshop(events);
                                break;
                        case 2:break;
                        default:System.out.println("\nWrong choice!Please choose again.");
                                break;
                    }
                    System.out.print("\n1.Create Event\n3.Logout\nEnter your choice: ");
                    eventChoice = scan.nextInt();
                }
            }
            else
            System.out.println("Invalid username or password. Please try again.");
        }

        else if(admin_user == 2){
            
        }
        else
            System.out.println("Wrong choice!");
    }
    
    static void createHackathon(ArrayList<Event> events){
        Hackathon hackathon = new Hackathon();
        hackathon.getDetails();
        hackathon.additional();
        events.add((Event)hackathon);
    }
    
    static void createConcert(ArrayList<Event> events){
        Concert concert = new Concert();
        concert.getDetails();
        concert.additional();
        events.add((Event)concert);
    }
    
    static void createWorkshop(ArrayList<Event> events){
        Workshop workshop = new Workshop();
        workshop.getDetails();
        workshop.additional();
        events.add((Event)workshop);
    }
    
}
