
package deliveryapp;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.cloud.stream.test.binder.MessageCollector;
import org.springframework.context.ApplicationContext;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.MimeTypeUtils;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.springframework.cloud.contract.verifier.messaging.MessageVerifier;
import org.springframework.cloud.contract.verifier.messaging.boot.AutoConfigureMessageVerifier;

import javax.inject.Inject;
import org.springframework.cloud.contract.verifier.messaging.internal.ContractVerifierMessage;
import org.springframework.cloud.contract.verifier.messaging.internal.ContractVerifierMessaging;
import org.springframework.cloud.contract.verifier.messaging.internal.ContractVerifierObjectMapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import deliveryapp.config.kafka.KafkaProcessor;
import deliveryapp.domain.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMessageVerifier
public class UpdatePointTest {

   private static final Logger LOGGER = LoggerFactory.getLogger(UpdatePointTest.class);
   
   @Autowired
   private KafkaProcessor processor;
   @Autowired
   private MessageCollector messageCollector;
   @Autowired
   private ApplicationContext applicationContext;

   @Autowired
   ObjectMapper objectMapper;

   @Autowired
   private MessageVerifier<Message<?>> messageVerifier;
   

   @Test
   @SuppressWarnings("unchecked")
   public void test0() {

      //given:

      entity.setId(1L);
      entity.setName("홍길동");
      entity.setPhone("010-1234-5678");
      entity.setAddress([object Object]);
      entity.setTotalPoints(100L);

      repository.save(entity);

      //when:  
      
      PaymentCreated event = new PaymentCreated();

      event.setId(1L);
      event.setOrderId("ORDER-001");
      event.setAmount([object Object]);
      event.setPaymentMethod("credit card");
      event.setPaymentStatus("completed");
      event.setPaymentTime("2022-01-01T12:00:00");
      event.setEarnedPoints(null);
   
   

      ObjectMapper objectMapper = new ObjectMapper();
      try {
         String msg = objectMapper.writeValueAsString(event);

         this.messageVerifier.send(MessageBuilder
                .withPayload(msg)
                .setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON)
                .setHeader("type", event.getEventType())
                .build(), "deliveryapp");

         //then:

         Message<?> receivedMessage = this.messageVerifier.receive("deliveryapp", 5000, TimeUnit.MILLISECONDS);

         assertNotNull("Resulted event must be published", receivedMessage);

         PointUpdated outputEvent = objectMapper.readValue(receivedMessage.getPayload(), PointUpdated.class);


         LOGGER.info("Response received: {}", receivedMessage.getPayload());

         assertEquals(outputEvent.getId(), 1L);
         assertEquals(outputEvent.getName(), "홍길동");
         assertEquals(outputEvent.getPhone(), "010-1234-5678");
         assertEquals(outputEvent.getAddress(), [object Object]);
         assertEquals(outputEvent.getTotalPoints(), 150L);


      } catch (JsonProcessingException e) {
         // TODO Auto-generated catch block
         assertTrue("exception", false);
      }

     
   }
   @Test
   @SuppressWarnings("unchecked")
   public void test1() {

      //given:

      entity.setId(2L);
      entity.setName("김철수");
      entity.setPhone("010-9876-5432");
      entity.setAddress([object Object]);
      entity.setTotalPoints(200L);

      repository.save(entity);

      //when:  
      
      PaymentCreated event = new PaymentCreated();

      event.setId(2L);
      event.setOrderId("ORDER-002");
      event.setAmount([object Object]);
      event.setPaymentMethod("bank transfer");
      event.setPaymentStatus("completed");
      event.setPaymentTime("2022-02-01T09:30:00");
      event.setEarnedPoints(null);
   
   

      ObjectMapper objectMapper = new ObjectMapper();
      try {
         String msg = objectMapper.writeValueAsString(event);

         this.messageVerifier.send(MessageBuilder
                .withPayload(msg)
                .setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON)
                .setHeader("type", event.getEventType())
                .build(), "deliveryapp");

         //then:

         Message<?> receivedMessage = this.messageVerifier.receive("deliveryapp", 5000, TimeUnit.MILLISECONDS);

         assertNotNull("Resulted event must be published", receivedMessage);

         PointUpdated outputEvent = objectMapper.readValue(receivedMessage.getPayload(), PointUpdated.class);


         LOGGER.info("Response received: {}", receivedMessage.getPayload());

         assertEquals(outputEvent.getId(), 2L);
         assertEquals(outputEvent.getName(), "김철수");
         assertEquals(outputEvent.getPhone(), "010-9876-5432");
         assertEquals(outputEvent.getAddress(), [object Object]);
         assertEquals(outputEvent.getTotalPoints(), 300L);


      } catch (JsonProcessingException e) {
         // TODO Auto-generated catch block
         assertTrue("exception", false);
      }

     
   }
   @Test
   @SuppressWarnings("unchecked")
   public void test2() {

      //given:

      entity.setId(3L);
      entity.setName("이영희");
      entity.setPhone("010-5555-4444");
      entity.setAddress([object Object]);
      entity.setTotalPoints(300L);

      repository.save(entity);

      //when:  
      
      PaymentCreated event = new PaymentCreated();

      event.setId(3L);
      event.setOrderId("ORDER-003");
      event.setAmount([object Object]);
      event.setPaymentMethod("cash");
      event.setPaymentStatus("completed");
      event.setPaymentTime("2022-03-01T14:45:00");
      event.setEarnedPoints(null);
   
   

      ObjectMapper objectMapper = new ObjectMapper();
      try {
         String msg = objectMapper.writeValueAsString(event);

         this.messageVerifier.send(MessageBuilder
                .withPayload(msg)
                .setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON)
                .setHeader("type", event.getEventType())
                .build(), "deliveryapp");

         //then:

         Message<?> receivedMessage = this.messageVerifier.receive("deliveryapp", 5000, TimeUnit.MILLISECONDS);

         assertNotNull("Resulted event must be published", receivedMessage);

         PointUpdated outputEvent = objectMapper.readValue(receivedMessage.getPayload(), PointUpdated.class);


         LOGGER.info("Response received: {}", receivedMessage.getPayload());

         assertEquals(outputEvent.getId(), 3L);
         assertEquals(outputEvent.getName(), "이영희");
         assertEquals(outputEvent.getPhone(), "010-5555-4444");
         assertEquals(outputEvent.getAddress(), [object Object]);
         assertEquals(outputEvent.getTotalPoints(), 600L);


      } catch (JsonProcessingException e) {
         // TODO Auto-generated catch block
         assertTrue("exception", false);
      }

     
   }

}
