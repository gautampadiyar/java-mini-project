import java.util.*;
import java.time.*;
import java.text.SimpleDateFormat;
import java.lang.Object;
import java.text.ParseException;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author naijoesrinivasan
 */
public class Event {
    private Date startDate,endDate;
    private String start,end;
    static Date currDate = new Date();
    
    //get user input for start and end date and time
    public void getDetails(){
        Scanner scan = new Scanner(System.in);
        
        SimpleDateFormat sdf = new SimpleDateFormat();
        sdf.applyPattern("dd/MM/yyyy HH:mm:ss");
        sdf.setLenient(false);
        
        System.out.println("Enter the start date and time of the event(dd/mm/yyyy HH:mm:ss): ");
        start = scan.nextLine();
        
        startDate = new Date();
        try {
            startDate = sdf.parse(start);
        }catch (ParseException e){
        	System.out.println("Parse error!");
        }
        finally{
            if(!startDate.after(currDate)){
        	System.out.println("Invalid start date entered");
                System.out.println("Enter a valid date after "+sdf.format(currDate));
            }
        }
        
        System.out.println("Enter the end date and time of the event(dd/mm/yyyy HH:mm:ss): ");
        end = scan.nextLine();
        
        endDate = new Date();
        try {
            endDate = sdf.parse(end);
        }catch (ParseException e){
            System.out.println("Parse error!");
        }
        finally{
            if(!currDate.before(endDate) || !startDate.before(endDate)){
        	System.out.println("Invalid end date entered");
                System.out.println("Enter a valid date after "+sdf.format(startDate));
            }
        }
        
        //checking if string type has been converted to date objects
        System.out.println("Start date and time: "+sdf.format(startDate));
        System.out.println("End date and time: "+sdf.format(endDate));
        System.out.println("Current date and time: "+sdf.format(currDate));
        System.out.println(String.valueOf(startDate.getTime()));
    }
}
