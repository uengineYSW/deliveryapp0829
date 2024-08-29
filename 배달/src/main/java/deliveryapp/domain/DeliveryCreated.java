package deliveryapp.domain;

import deliveryapp.domain.*;
import deliveryapp.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class DeliveryCreated extends AbstractEvent {

    private Long id;
    private OrderId orderId;
    private RiderId riderId;
    private Date pickupTime;
    private String deliveryStatus;

    public DeliveryCreated(Delivery aggregate) {
        super(aggregate);
    }

    public DeliveryCreated() {
        super();
    }
}
//>>> DDD / Domain Event
