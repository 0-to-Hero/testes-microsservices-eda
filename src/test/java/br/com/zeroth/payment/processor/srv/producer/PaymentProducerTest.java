package br.com.zeroth.payment.processor.srv.producer;

import br.com.zeroth.payment.processor.srv.consumer.PaymentConsumer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.test.annotation.DirtiesContext;

import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.FactoryBasedNavigableListAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@DirtiesContext
@EmbeddedKafka(partitions = 1, brokerProperties = { "listeners=PLAINTEXT://localhost:9092", "port=9092" })
class PaymentProducerTest {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    private PaymentConsumer consumer;

    @Autowired
    private PaymentProducer producer;

    private final String topic = "embedded-payment-test-topic";

    @Test
    public void testProducerEventSent() throws InterruptedException {
        // Simulando envio de evento de pagamento
        String data = "{\"transactionId\": \"1234\", \"status\": \"CONFIRMED\"}";

        producer.send(topic, data);

        boolean messageConsumed = consumer.getLatch().await(10, TimeUnit.SECONDS);
        assertTrue(messageConsumed);

    }

}