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
        while(admin_user != 3) {
            System.out.print("1.Admin\n2.Attendee\n3.Exit\nEnter your choice: ");
            admin_user = scan.nextInt();

            if(admin_user == 1){
                System.out.print("\nUsername: ");
                username = scan.next();
                //TODO password ipnut in *
                System.out.print("Password: ");
                pass = scan.next();

                if(username.equals(admin) && pass.equals(password)){
                    System.out.print("\n1.Create Event\n2.View Events\n3.Logout\nEnter your choice: ");
                    eventChoice = scan.nextInt();
                    while(eventChoice!=3){
                        switch(eventChoice){
                            case 1:
                                System.out.print("\n1.Create Hackathon\n2.Create Concert\n3.Create Workshop\n4.Create general Event\nEnter your choice: ");
                                create = scan.nextInt();
                                if(create == 1)
                                    createHackathon();
                                else if(create == 2)
                                    createConcert();
                                else if(create == 3)
                                    createWorkshop();
                                else if(create == 4) {
                                    createEvent();
                                    addEventInfoToFirebase(new Event("03/12/2017 14:15:00", "03/12/2017 14:55:00"));
                                }
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
                User u = new User("Balaji");
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
    //TODO combine following 4 into one function (something on the lines of contructor overloading)
    //Suggestion, event e. make object inside the if condition. outside call getDetails
    //inside getDetails use instanceOf
    static void createHackathon(){
        Hackathon hackathon = new Hackathon();
        hackathon.getDetails();
        events.add((Event)hackathon);
    }// TODO make this a member function of class Hackathon
    
    static void createConcert(){
        Concert concert = new Concert();
        concert.getDetails();
        events.add((Event)concert);
    }// TODO make this a member function of class Concert
    
    static void createWorkshop(){
        Workshop workshop = new Workshop();
        workshop.getDetails();
        events.add((Event)workshop);
    }// TODO make this a member function of class Workshop
    
    static void createEvent(){
        Event e = new Event();
        e.getDetails();
        events.add(e);
    }// TODO make this a member function of class Event

    static void addEventInfoToFirebase(Event e){
        // make this a member function for each type of event
        // this is only for demonstration of the upload function

        try {
            Gson g = new Gson();
            String rawData = g.toJson(e, Event.class);
            String id = e.getEventID();
            URL u = new URL("https://java-final-proj.firebaseio.com/fests/Breeze/Events/.json");
            HttpURLConnection conn = (HttpURLConnection) u.openConnection();
            System.out.println(conn.toString());
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            OutputStream os = conn.getOutputStream();
            os.write(rawData.getBytes());
            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }
        }catch (MalformedURLException ex1){

        }catch (IOException ex2){

        }

    }
    
    static void viewEvents(){
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
                Set<Map.Entry<String, JsonElement>> ens = ((JsonObject) jObj).entrySet();
                if (ens != null) {
                    // Iterate JSON Elements with Key values
                    for (Map.Entry<String, JsonElement> en : ens) {
                        JsonObject child = en.getValue().getAsJsonObject();
                        Event e = new Event(child.get("start").getAsString(), child.get("end").getAsString());
                        e.setTags(child.get("tags").getAsString());
                        events.add(e);
                    }
                }
            }

            for(Event e: events){
            	e.showEventGist();
            }
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

// Display event schedule with **** for giving indication of duration
// Store the cash prizes in an array list
// Populate the firebase event list along with all relevant details
// rogue input not handled
// add event to firebase linking



//Give organizers a list of the events most people were interested in and suggestions on how to arrange and display events
