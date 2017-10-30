package Other;

import Core.*;
import java.util.*;

/**
 *
 * @author temutai
 */
public class Main {
    public static ArrayList<Event> events = new ArrayList<>();
    public static ArrayList<Hackathon> hackathons = new ArrayList<>();
    public static ArrayList<Concert> concerts = new ArrayList<>();
    public static ArrayList<Workshop> workshops = new ArrayList<>();
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        String admin = "TechFest", password = "TechFest@12345";
        String username,pass;
        int admin_user,eventChoice = 10,create;
        
        System.out.print("1.Admin\n2.Attendee\nEnter your choice: ");
        admin_user = scan.nextInt();
        
        if(admin_user == 1){
            System.out.print("Username: ");
            username = scan.next();
            System.out.print("Password: ");
            pass = scan.next();
            
            if(username.equals(admin) && pass.equals(password)){
                System.out.print("1.View Events\n2.Create Event\n3.Logout\nEnter your choice: ");
                eventChoice = scan.nextInt();
            
                while(eventChoice!=3){
                    switch(eventChoice){
                        case 1:viewEvents(hackathons,concerts,workshops);
                               break;
                        case 2:System.out.print("1.Create Hackathon\n2.Create Concert\n3.Create Workshop\nEnter your choice: ");
                               create = scan.nextInt();
                                if(create == 1)
                                    createHackathon(events,hackathons);
                                else if(create == 2)
                                    createConcert(events,concerts);
                                else if(create == 3)
                                    createWorkshop(events,workshops);
                                break;
                        case 3:break;
                        default:System.out.println("Wrong choice!Please choose again.");
                                break;
                    }
                    System.out.print("1.View Events\n2.Create Event\n3.Logout\nEnter your choice: ");
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
    
    static void createHackathon(ArrayList<Event> events, ArrayList<Hackathon> hackathons){
        Hackathon hackathon = new Hackathon();
        hackathon.getDetails();
        hackathon.additional();
        events.add(hackathon);
        hackathons.add(hackathon);
    }
    
    static void createConcert(ArrayList<Event> events, ArrayList<Concert> concerts){
        Concert concert = new Concert();
        concert.getDetails();
        concert.additional();
        events.add(concert);
        concerts.add(concert);
    }
    
    static void createWorkshop(ArrayList<Event> events, ArrayList<Workshop> workshops){
        Workshop workshop = new Workshop();
        workshop.getDetails();
        workshop.additional();
        events.add(workshop);
        workshops.add(workshop);
    }
    
    static void viewEvents(ArrayList<Hackathon> hackathons, ArrayList<Concert> concerts, ArrayList<Workshop> workshops){
        for(Hackathon h:hackathons){
            h.showAdditional();
            h.showInfo();
        }
        for(Concert c:concerts){
            c.showAdditional();
            c.showInfo();
        }
        for(Workshop w:workshops){
            w.showAdditional();
            w.showInfo();
        }
    }
}
