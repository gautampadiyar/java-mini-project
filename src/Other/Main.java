package Other;

import Core.*;
import com.google.gson.*;
import java.io.*;
import java.net.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author temutai
 */

public class Main {
    public static ArrayList<Event> events = new ArrayList<>();
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        String admin = "TechFest", password = "TechFest@12345";
        //TODO non-hardcoded logins?
        String username, pass;
        int admin_user = 1, eventChoice = 10,create;
        fetchEvents();
        while(admin_user != 3) {
            System.out.print("1.Admin\n2.Attendee\n3.Exit\nEnter your choice: ");
            admin_user = scan.nextInt();

            if(admin_user == 1){
                System.out.print("\nUsername: ");
                username = scan.next();
                System.out.print("Password: ");
                pass = scan.next();

                if(username.equals(admin) && pass.equals(password)){
                    System.out.print("\n1.Create Event\n2.View Events\n3.Logout\nEnter your choice: ");
                    eventChoice = scan.nextInt();
                    while(eventChoice!=3){
                        Event event;
                        switch(eventChoice){
                            case 1:
                                System.out.print("\n1.Create Hackathon\n2.Create Concert\n3.Create Workshop\n4.Create generic Event\nEnter your choice: ");
                                create = scan.nextInt();
                                if(create == 1)
                                    event = new Hackathon();
                                else if(create == 2)
                                    event = new Concert();
                                else if(create == 3)
                                    event = new Workshop();
                                else {
                                    event = new Event();
                                }
                                event.getDetails();
                                events.add(event);
                                event.addEventInfoToFirebase();
                                break;
                            case 2:
                                viewEvents();
                                break;
                            case 3: 
                                break;
                            default:
                                System.out.println("\nWrong choice!Please choose again.");
                                break;
                        }
                        System.out.print("\n1.Create Event\n2.View Events\n3.Logout\nEnter your choice: ");
                        eventChoice = scan.nextInt();
                    }
                }
                else
                System.out.println("Invalid username or password. Please try again.");
            }

            else if(admin_user == 2){
                User u = new User("singleton");
                u.setPref1();
                //refresh main.events before refresh schedule
                u.refreshSchedule();
                u.showSchedule();
            }
            else {
                System.out.println("Invalid input!");
            }
        }
    }

    static void fetchEvents(){
        // fetch the events from firebase and display it

        try {
            URL url = new URL("https://java-final-proj.firebaseio.com/fests/Breeze/Events.json");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            Gson sd = new Gson();

            //System.out.println(conn.toString());

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));

            String output;
            StringBuilder sb = new StringBuilder();
            System.out.println("Output from Server .... \n");
            while ((output = br.readLine()) != null) {
                //System.out.println(output);
                sb.append(output);
            }
            JsonParser parser = new JsonParser();
            JsonObject jObj = parser.parse(sb.toString()).getAsJsonObject();

            if (jObj.isJsonObject()) {
                Set<Map.Entry<String, JsonElement>> ens = jObj.entrySet();
                if (ens != null) {
                    // Iterate JSON Elements with Key values
                    for (Map.Entry<String, JsonElement> en : ens) {
                        JsonObject child = en.getValue().getAsJsonObject();
                        Event e = new Event(child.get("start").getAsString(), child.get("end").getAsString());
                        e.setTags(child.get("tags").getAsString());
                        e.setEventName(child.get("eventName").getAsString());
                        events.add(e);
                    }
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    static void viewEvents(){
        for(Event e: events){
            e.showEventGist();
        }
    }
}

// Display event schedule with **** for giving indication of duration
// handle input exceptions like string for long

//Give organizers a list of the events most people were interested in and suggestions on how to arrange and display events
// To make inputs quicker
/*
1
TechFest
TechFest@12345

04/12/2017 17:10:00
04/12/2017 17:50:00

*/