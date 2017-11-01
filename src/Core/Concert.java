package Core;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

public class Concert extends Event {
    public long noTickets;
    public long price;
    public String info;
    public ArrayList<String> sponsors, artists, genres;

    @Override
    public void getDetails(){
        super.getDetails();
        Scanner scan = new Scanner(System.in);
        char choice = 'y';
        String temp;
        long i=1;

        sponsors = new ArrayList<String>();
        artists = new ArrayList<String>();
        genres = new ArrayList<String>();

        System.out.print("Concert information: ");
        info = scan.nextLine();

        System.out.println("Enter the genre of the concert ");
        while(choice=='y'){
            System.out.print("Theme " +i+ ": ");
            temp = scan.nextLine();
            genres.add(temp);
            System.out.print("Do you wish to add another genre?(y/n) : ");
            choice = scan.next().charAt(0);
            scan.nextLine();
            i++;
        }

        choice = 'y';
        i=1;

        System.out.println("Artists: ");
        while(choice=='y'){
            System.out.print("Artists "+i+": ");
            temp = scan.nextLine();
            artists.add(temp);
            System.out.print("Do you wish to add another Artist?(y/n) : ");
            choice = scan.next().charAt(0);
            scan.nextLine();
            i++;
        }

        choice = 'y';
        i=1;

        System.out.println("Sponsors: ");
        while(choice=='y'){
            System.out.print("Sponsor "+i+": ");
            temp = scan.nextLine();
            sponsors.add(temp);
            System.out.print("Do you wish to add another Sponsor?(y/n): ");
            choice = scan.next().charAt(0);
            scan.nextLine();
            i++;
        }

        System.out.print("Enter the number of tickets available: ");
        noTickets = scan.nextLong();

        System.out.print("Enter the price of a ticket: ");
        price = scan.nextLong();

    }

    public void addEventInfoToFirebase() {

        try {
            Gson g = new Gson();
            StringBuilder t = new StringBuilder();
            Iterator<String> iter = this.tags.iterator();
            do{
                t.append(iter.next());
                t.append(",");
            }while (iter.hasNext());

            // Try the json element method
            HashMap<String, Object> map = new HashMap();
            map.put("start", this.getStart());
            map.put("end", this.getEnd());
            map.put("tags", t.toString());
            map.put("noTickets", this.noTickets);
            map.put("price", this.price);
            map.put("info", this.info);
            map.put("eventName", this.eventName);
            // sponsors eve
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

}
