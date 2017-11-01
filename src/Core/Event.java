package Core;

/**
 * Created by gautam on 23/10/17.
 */

import com.google.gson.Gson;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.time.*;

public class Event implements Comparable<Event>{
    private Date startDate,endDate;
    private String start,end;
    Location loc;
    static Date currDate = new Date();
    protected String eventID = UUID.randomUUID().toString().substring(0, 5), eventName;
    private int priority = 3;
    protected ArrayList<String> tags = new ArrayList<>();

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

    public void setTags(String tags){
        String values[] = tags.split(",");
        for(String s: values)
            this.tags.add(s);
    }
    
    public void getDetails(){
        //TODO also input for tags
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

        System.out.print("Enter name of the event : ");
        eventName = scan.nextLine();

        System.out.print("Enter the start date and time of the event(dd/mm/yyyy HH:mm:ss): ");
        start = scan.nextLine();

        stringToStartDate(start);
        
        System.out.print("Enter the end date and time of the event(dd/mm/yyyy HH:mm:ss): ");
        end = scan.nextLine();

        stringToEndDate(end);

        System.out.println("Enter event tags/categories separated by commas :");
        String tag = scan.nextLine();
        String t[] = tag.split(",");
        for(String s: t)
            tags.add(s);
    }

    public void addEventInfoToFirebase() {

        try {
            Gson g = new Gson();
            StringBuilder t = new StringBuilder();
            Iterator<String> iter = tags.iterator();
            do{
                t.append(iter.next());
                t.append(",");
            }while (iter.hasNext());

            // Try the json element method
            HashMap<String, Object> map = new HashMap();
            map.put("start", this.getStart());
            map.put("end", this.getEnd());
            map.put("tags", t.toString());
            map.put("eventName", this.eventName);
            //convert holder object to JSONObject directly and return as string as follows
            String rawData = g.toJson(map).toString();

            String id = this.getEventID();
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
        } catch (MalformedURLException ex1) {

        } catch (IOException ex2) {

        }
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

        System.out.print(this.eventID + " " + this.eventName + " " + start + " - " + end + " ");
        for(String s: this.tags)
            System.out.print(s + ", ");
        System.out.print("\n");
    }
    
    public Date getStartDate() {
        return startDate;
    }
    
    public String getEventID() {
        return eventID;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public Date getEndDate() {
        return endDate;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
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