package deliveryapp.domain;

import deliveryapp.domain.PaymentCreated;
import deliveryapp.주문Application;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Payment_table")
@Data
//<<< DDD / Aggregate Root
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Embedded
    private OrderId orderId;

    @Embedded
    private Money amount;

    private String paymentMethod;

    private String paymentStatus;

    @Embedded
    private paymentStatusType paymentStatusType;

    private Date paymentTime;

    private Integer earnedPoints;

    @PostPersist
    public void onPostPersist() {
        PaymentCreated paymentCreated = new PaymentCreated(this);
        paymentCreated.publishAfterCommit();
    }

    @PrePersist
    public void onPrePersist() {}

    public static PaymentRepository repository() {
        PaymentRepository paymentRepository = 주문Application.applicationContext.getBean(
            PaymentRepository.class
        );
        return paymentRepository;
    }
}
//>>> DDD / Aggregate Root
