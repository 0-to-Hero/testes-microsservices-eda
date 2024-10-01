package br.com.zeroth.payment.processor.srv.domain;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class Charge implements Serializable {
    private String id;
}
