package br.com.zeroth.payment.processor.srv.producer;

import br.com.zeroth.payment.processor.srv.domain.Charge;

public interface ChargeProducer {

    void createCharge(Charge charge);
}
