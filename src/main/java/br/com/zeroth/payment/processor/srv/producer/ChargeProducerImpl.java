package br.com.zeroth.payment.processor.srv.producer;

import br.com.zeroth.payment.processor.srv.domain.Charge;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@Service
@Slf4j
@RequiredArgsConstructor
public class ChargeProducerImpl implements ChargeProducer{

    private final KafkaTemplate<String, Serializable> producer;
    private final String CREATE_CHARGE_TOPIC = "CHARGE_CREATED";

    @Override
    public void createCharge(Charge charge) {
        log.info("Publishing charge to dm-charge-notification {} ", charge);
        producer.send(CREATE_CHARGE_TOPIC, charge.getId(), charge);

    }
}
