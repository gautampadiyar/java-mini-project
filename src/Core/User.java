package Core;

import java.util.*;

public class User {
    private String name, userId;
    private ArrayList<Event> schedule, pref1, pref2;
    public User(String name) {
        this.name = name;
        userId = UUID.randomUUID().toString();
    }
    void setSchedule() {
        schedule = new ArrayList<>();
        ArrayList<Event> pref = new ArrayList<>();
        pref.addAll(pref1);
        pref.addAll(pref2);
        Collections.sort(pref);
        Event prev = null;
        //prev is initialised to have start and end time as beginning of the day
        for(Event e:pref) {
            if(e.getStartDate().compareTo(prev.getEndDate()) > 0) {
                schedule.add(e);
            }
            else if(e.getPriority() == 1){
                for(Event x:schedule) {
                    if(x.getEndDate().compareTo(e.getStartDate())>0) {
                        if(x.getPriority() > 1) {
                            schedule.remove(x);
                            //hope this doesn't create problems, as i'm traversing the array at x here
                        }
                        else {
                            //TODO resolve the conflict. ask user which eventS to keep
                        }
                    }
                }
            }
            prev = e;
        }
        
        
    }
    void setPref1() {
        pref1 = new ArrayList<>();
        //TODO populate pref1
    }
    void setPref2() {
        pref2 = new ArrayList<>();
        //TODO populate pref2
    }
}
