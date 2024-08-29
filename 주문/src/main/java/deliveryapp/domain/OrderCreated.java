package deliveryapp.domain;

import deliveryapp.domain.*;
import deliveryapp.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class OrderCreated extends AbstractEvent {

    private Long id;
    private CustomerId customerId;
    private StoreId storeId;
    private String orderStatus;
    private Date orderTime;
    private Money totalAmount;

    public OrderCreated(Order aggregate) {
        super(aggregate);
    }

    public OrderCreated() {
        super();
    }
}
//>>> DDD / Domain Event
