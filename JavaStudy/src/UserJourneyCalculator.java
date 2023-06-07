import java.util.*;

/*
 *
 * Event(user_id = xyz, event_name=A, time=X) <-- INPUTS
 [Event(U1, A1), Event(U1, A2), Event(U2, D)] <-- stored in order of time
 * analyze and store the various possible user journeys
 * write a program to print immediate next possible events from any given event
 *
 * A -> A1 -> A2 -> B -> A -> C (user 1)
 * A -> Z (user 2)
 * A -> A1, C, Z <-- OUTPUT
 *
 */

class Event {
    String userId;
    String eventName;

    public Event(String userId, String eventName) {
        this.userId = userId;
        this.eventName = eventName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return Objects.equals(userId, event.userId) && Objects.equals(eventName, event.eventName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, eventName);
    }
}

public class UserJourneyCalculator {

    static final List<Event> inputEvents = List.of(
            new Event("U1", "A"),
            new Event("U2", "A1"),
            new Event("U1", "C"),
            new Event("U1", "A3"),
            new Event("U1", "C"),
            new Event("U1", "A4"),
            new Event("U1", "B"),
            new Event("U2", "A"),
            new Event("U3", "C"),
            new Event("U3", "A2"),
            new Event("U3", "B")
    );

    public static void main(String[] args) {
        printJourneys(inputEvents, "C");
        printJourneys(inputEvents, "A");
    }

    public static void printJourneys(List<Event> events, String startEventName) {
        HashMap<Event, Set<String>> userEvent = new HashMap<>(); //maps Event to a set of event names
        HashMap<String, String> usersLastEventName = new HashMap<>(); // maps user name to last seen

        // TODO check null for events
        for (Event event : events) {

            String userId = event.userId;
            String eventName = event.eventName;

            // check if there is a last event for this user
            if (usersLastEventName.get(userId) == null) {
                usersLastEventName.put(userId, eventName);
                continue;
            }

            String lastEventName = usersLastEventName.get(userId);
            //System.out.println(userId + ": last event seen = " + lastEventName);
            Set<String> eventNameSet = userEvent.get(new Event(userId, lastEventName));

            if (eventNameSet == null) {
                eventNameSet = new HashSet<>();
                userEvent.put(new Event(userId, lastEventName), eventNameSet);
            }

            eventNameSet.add(event.eventName);

            usersLastEventName.put(userId, event.eventName);
        }

        // now print the output
        //HashMap<Event, Set<String>> userEvent
        Set<Map.Entry<Event, Set<String>>> entrySet = userEvent.entrySet();

        //System.out.println(entrySet);
        for (Map.Entry<Event, Set<String>> entry : entrySet) {
            Event event = entry.getKey();
            Set<String> eventNameSet = entry.getValue();

            if (!event.eventName.equals(startEventName)) continue;

            System.out.print(event.eventName + "->");

            //now print all the entries of the Set
            for (String eventName : eventNameSet) {
                System.out.print(eventName);
                System.out.print(", ");
            }
            System.out.println();
        }
    }
}
