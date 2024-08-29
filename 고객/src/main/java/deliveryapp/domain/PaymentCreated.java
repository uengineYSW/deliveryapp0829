package deliveryapp.domain;

import deliveryapp.domain.*;
import deliveryapp.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class PaymentCreated extends AbstractEvent {

    private Long id;
    private Object orderId;
    private Object amount;
    private String paymentMethod;
    private String paymentStatus;
    private Date paymentTime;
    private Integer earnedPoints;
}
