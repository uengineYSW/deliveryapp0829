package deliveryapp.domain;

import deliveryapp.domain.NotificationCreated;
import deliveryapp.알림Application;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Notification_table")
@Data
//<<< DDD / Aggregate Root
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Embedded
    private CustomerId customerId;

    @Embedded
    private OrderId orderId;

    private String message;

    private Date notificationTime;

    @PostPersist
    public void onPostPersist() {
        NotificationCreated notificationCreated = new NotificationCreated(this);
        notificationCreated.publishAfterCommit();
    }

    @PrePersist
    public void onPrePersist() {}

    public static NotificationRepository repository() {
        NotificationRepository notificationRepository = 알림Application.applicationContext.getBean(
            NotificationRepository.class
        );
        return notificationRepository;
    }
}
//>>> DDD / Aggregate Root
