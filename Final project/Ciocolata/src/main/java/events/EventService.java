package events;


import com.grupa2.AbstractService;


public class EventService extends AbstractService<Long, EventModel, EventRepository> {

    private EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        super(eventRepository);
    }

}


