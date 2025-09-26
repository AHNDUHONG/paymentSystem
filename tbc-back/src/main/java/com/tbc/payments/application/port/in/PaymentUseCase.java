package com.tbc.payments.application.port.in;

import com.tbc.payments.adapter.in.web.dto.ConfirmRequest;
import com.tbc.payments.adapter.in.web.dto.ConfirmResponse;
import com.tbc.payments.adapter.in.web.dto.CreatePaymentRequest;
import com.tbc.payments.adapter.in.web.dto.CreatePaymentResponse;

public interface PaymentUseCase {
    CreatePaymentResponse createInit(CreatePaymentRequest req);
    ConfirmResponse confirmAndCredit(ConfirmRequest req);
}
