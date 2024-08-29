package deliveryapp.domain;

import deliveryapp.domain.*;
import deliveryapp.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class PaymentCreated extends AbstractEvent {

    private Long id;
    private OrderId orderId;
    private Money amount;
    private String paymentMethod;
    private String paymentStatus;
    private Date paymentTime;
    private Integer earnedPoints;

    public PaymentCreated(Payment aggregate) {
        super(aggregate);
    }

    public PaymentCreated() {
        super();
    }
}
//>>> DDD / Domain Event
