package deliveryapp.domain;

import deliveryapp.domain.*;
import deliveryapp.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class OrderCreated extends AbstractEvent {

    private Long id;
    private Object customerId;
    private Object storeId;
    private String orderStatus;
    private Date orderTime;
    private Object totalAmount;
}
