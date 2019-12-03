package events;


import com.grupa2.AbstractController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/events")
public class EventController extends AbstractController <Long, EventModel,EventRepository,EventService> {

    public EventController (EventService service) { super (service);}
}
