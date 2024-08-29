package deliveryapp.domain;

import deliveryapp.domain.*;
import deliveryapp.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class CustomerCreated extends AbstractEvent {

    private Long id;
    private String name;
    private String phone;
    private Address address;

    public CustomerCreated(Customer aggregate) {
        super(aggregate);
    }

    public CustomerCreated() {
        super();
    }
}
//>>> DDD / Domain Event
