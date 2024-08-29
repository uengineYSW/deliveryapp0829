package deliveryapp.domain;

import deliveryapp.domain.*;
import deliveryapp.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class RiderCreated extends AbstractEvent {

    private Long id;
    private String name;
    private String phone;
    private Address currentLocation;

    public RiderCreated(Rider aggregate) {
        super(aggregate);
    }

    public RiderCreated() {
        super();
    }
}
//>>> DDD / Domain Event
