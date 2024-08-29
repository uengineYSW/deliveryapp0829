package deliveryapp.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import deliveryapp.config.kafka.KafkaProcessor;
import deliveryapp.domain.*;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

//<<< Clean Arch / Inbound Adaptor
@Service
@Transactional
public class PolicyHandler {

    @Autowired
    CustomerRepository customerRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='PaymentCreated'"
    )
    public void wheneverPaymentCreated_UpdatePoint(
        @Payload PaymentCreated paymentCreated
    ) {
        PaymentCreated event = paymentCreated;
        System.out.println(
            "\n\n##### listener UpdatePoint : " + paymentCreated + "\n\n"
        );

        // Comments //
        //결제금액이 50,000원 이하인 경우 결제금액의 5% 포인트 적립 / 100,000원 이상인 경우에는 결제금액의 10% 포인트 적립 / 200,000원 이상인 경우에는 결제금액의 20% 적립

        // Sample Logic //
        Customer.updatePoint(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
