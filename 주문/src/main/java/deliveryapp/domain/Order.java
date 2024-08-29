package deliveryapp.domain;

import deliveryapp.domain.OrderCreated;
import deliveryapp.주문Application;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Order_table")
@Data
//<<< DDD / Aggregate Root
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Embedded
    private CustomerId customerId;

    @Embedded
    private StoreId storeId;

    private String orderStatus;

    @Embedded
    private orderStatusType orderStatusType;

    private Date orderTime;

    @Embedded
    private Money totalAmount;

    private Integer earnedPoints;

    @PostPersist
    public void onPostPersist() {
        OrderCreated orderCreated = new OrderCreated(this);
        orderCreated.publishAfterCommit();
    }

    @PrePersist
    public void onPrePersist() {}

    public static OrderRepository repository() {
        OrderRepository orderRepository = 주문Application.applicationContext.getBean(
            OrderRepository.class
        );
        return orderRepository;
    }
}
//>>> DDD / Aggregate Root
