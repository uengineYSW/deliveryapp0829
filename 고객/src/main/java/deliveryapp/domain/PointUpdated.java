package deliveryapp.domain;

import deliveryapp.domain.*;
import deliveryapp.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class PointUpdated extends AbstractEvent {

    private Long id;
    private String name;
    private String phone;
    private Address address;
    private Integer totalPoints;

    public PointUpdated(Customer aggregate) {
        super(aggregate);
    }

    public PointUpdated() {
        super();
    }
}
//>>> DDD / Domain Event
