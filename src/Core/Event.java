package Core;

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
public class Event implements Comparable<Event>{
    private Date startDate,endDate;
    private String eventID = UUID.randomUUID().toString().substring(5), eventName;
    private int priority = 3;

    //get user input for start and end date and time
    public void getDetails(){
        String start, end;
        Scanner scan = new Scanner(System.in);
        
        System.out.print("Enter the start date and time of the event(dd/mm/yyyy HH:mm:ss): ");
        start = scan.nextLine();
        
        startDate = new Date();
        try {
            startDate = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(start);
        }catch (ParseException e){
        	System.out.println("parse error");
                //TODO handle the exception better, take input in proper format
        }
        
        System.out.print("Enter the end date and time of the event(dd/mm/yyyy HH:mm:ss): ");
        end = scan.nextLine();
        
        endDate = new Date();
        try {
            endDate = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(end);
        }catch (ParseException e){

        }
        
        //checking if string type has been converted to date objects
        System.out.println("Start date: "+ new SimpleDateFormat("dd/MM/yyyy").format(startDate));
        System.out.println("Start time: "+ new SimpleDateFormat("HH:mm:ss").format(startDate));
        System.out.println("End date: "+new SimpleDateFormat("dd/MM/yyyy").format(endDate));
        System.out.println("End time: "+new SimpleDateFormat("HH:mm:ss").format(endDate));
        System.out.println(String.valueOf(startDate.getTime()));
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
    public void showEvent() {
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
