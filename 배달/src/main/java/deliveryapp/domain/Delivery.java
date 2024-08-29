package deliveryapp.domain;

import deliveryapp.domain.DeliveryCreated;
import deliveryapp.배달Application;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Delivery_table")
@Data
//<<< DDD / Aggregate Root
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Embedded
    private OrderId orderId;

    @Embedded
    private RiderId riderId;

    private Date pickupTime;

    private String deliveryStatus;

    @Embedded
    private deliveryStatusType deliveryStatusType;

    @PostPersist
    public void onPostPersist() {
        DeliveryCreated deliveryCreated = new DeliveryCreated(this);
        deliveryCreated.publishAfterCommit();
    }

    @PrePersist
    public void onPrePersist() {}

    public static DeliveryRepository repository() {
        DeliveryRepository deliveryRepository = 배달Application.applicationContext.getBean(
            DeliveryRepository.class
        );
        return deliveryRepository;
    }
}
//>>> DDD / Aggregate Root
