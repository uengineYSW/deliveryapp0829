package deliveryapp.domain;

import deliveryapp.domain.StoreCreated;
import deliveryapp.주문Application;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Store_table")
@Data
//<<< DDD / Aggregate Root
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @Embedded
    private Address address;

    private String phone;

    @PostPersist
    public void onPostPersist() {
        StoreCreated storeCreated = new StoreCreated(this);
        storeCreated.publishAfterCommit();
    }

    @PrePersist
    public void onPrePersist() {}

    public static StoreRepository repository() {
        StoreRepository storeRepository = 주문Application.applicationContext.getBean(
            StoreRepository.class
        );
        return storeRepository;
    }
}
//>>> DDD / Aggregate Root
