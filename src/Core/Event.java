package Core;

/**
 * Created by gautam on 23/10/17.
 */

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.time.*;

public class Event implements Comparable<Event>{
    private Date startDate,endDate;
    private String start,end;
    Location loc;
    static Date currDate = new Date();
    private String eventID = UUID.randomUUID().toString().substring(0, 5), eventName;
    private int priority = 3;
    private ArrayList<String> tags = new ArrayList<>();

    public ArrayList<String> getTags() {
        return tags;
    }

    public Event(String start, String end){
        this.start = start;
        this.end = end;
        stringToStartDate(start);
        stringToEndDate(end);
    }

    public Event() {}

    public void stringToStartDate(String start) {

        SimpleDateFormat sdf = new SimpleDateFormat();
        sdf.applyPattern("dd/MM/yyyy HH:mm:ss");
        sdf.setLenient(false);

        startDate = new Date();
        try {
            startDate = sdf.parse(start);
        } catch (ParseException e) {
            System.out.println("Parse error!");
        } finally {
            if (!startDate.after(currDate)) {
                System.out.println("Invalid start date entered");
                System.out.println("Enter a valid date after " + sdf.format(currDate));
            }
        }
    }

    public void stringToEndDate(String end) {

        SimpleDateFormat sdf = new SimpleDateFormat();
        sdf.applyPattern("dd/MM/yyyy HH:mm:ss");
        sdf.setLenient(false);

        endDate = new Date();
        try {
            endDate = sdf.parse(end);
        }catch (ParseException e){
            //TODO somehow get back to point of the error?
            System.out.println("Parse error!");
        }
        finally{
            if(!currDate.before(endDate) || !startDate.before(endDate)){
                System.out.println("Invalid end date entered");
                System.out.println("Enter a valid date after "+sdf.format(startDate));
            }
        }
    }


    
    public void getDetails(){
        //TODO also input for tags
        String l_name;
        double lat,lon;
        
        Scanner scan = new Scanner(System.in);


        /*
        System.out.print("Enter the event location: ");
        l_name = scan.nextLine();
        System.out.print("Enter the latitude of the location: ");
        lat = scan.nextDouble();
        System.out.print("Enter the longitude of the location: ");
        lon = scan.nextDouble();
        scan.nextLine();

        loc = new Location(l_name,lat,lon);
        */
        System.out.print("Enter the start date and time of the event(dd/mm/yyyy HH:mm:ss): ");
        start = scan.nextLine();

        stringToStartDate(start);
        
        System.out.print("Enter the end date and time of the event(dd/mm/yyyy HH:mm:ss): ");
        end = scan.nextLine();

        stringToEndDate(end);
    }

    public void printDates(){
        System.out.println(start+end);
    }

    @Override
    public int compareTo(Event t) {
        if(this.startDate.equals(t.startDate)) {
            return this.endDate.compareTo(t.endDate);
        }
        else {
            return this.startDate.compareTo(t.endDate);
        }
    }

    public void setEndDate(String endDate) {
        SimpleDateFormat sdf = new SimpleDateFormat();
        sdf.applyPattern("dd/MM/yyyy HH:mm:ss");
        sdf.setLenient(false);
        try {
            this.endDate = sdf.parse(endDate);
        }catch (ParseException e){
            System.out.println("Parse error!");
        }
    }
    
    public void showEventGist() {
        System.out.println(this.eventID + " " + this.eventName);
    }
    
    public Date getStartDate() {
        return startDate;
    }
    
    public String getEventID() {
        return eventID;
    }

    public Date getEndDate() {
        return endDate;
    }

    public int getPriority() {
        return priority;
    }

    public String getEventName() {
        return eventName;
    }
}

class Location { 
    public String name;
    public double longitude;
    public double latitude;   
   
    // create and initialize a point with given name and
    // (latitude, longitude) specified in degrees
    public Location(String name, double latitude, double longitude) {
        this.name = name;
        this.latitude  = latitude;
        this.longitude = longitude;
    }

    // TODO id eventID is null, generate a new event ID and store it back in firebase
}