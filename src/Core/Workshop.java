package Core;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
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
        char choice = 'y';
        long i=1;

        sponsors = new ArrayList<String>();

        System.out.print("Theme of the workshop: ");
        theme = scan.nextLine();

        System.out.print("Workshop information: ");
        info = scan.nextLine();

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

        System.out.print("Number of seats available: ");
        noSeats = scan.nextLong();

        System.out.print("Number of people required per group: ");
        groupSize = scan.nextLong();
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
}
