package deliveryapp.domain;

import deliveryapp.domain.*;
import deliveryapp.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class StoreCreated extends AbstractEvent {

    private Long id;
    private String name;
    private Address address;
    private String phone;

    public StoreCreated(Store aggregate) {
        super(aggregate);
    }

    public StoreCreated() {
        super();
    }
}
//>>> DDD / Domain Event
