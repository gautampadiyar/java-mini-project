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
        Collections.sort(pref1);
        Collections.sort(pref2);
        Event prev = null;
        //prev is initialised to have start and end time as beginning of the day
        for(Event e:pref1) {
            if(e.getStartDate().compareTo(prev.getEndDate()) > 0) {
                schedule.add(e);
            }
            else {
                //TODO resolve the conflict. ask user which eventS to keep
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
