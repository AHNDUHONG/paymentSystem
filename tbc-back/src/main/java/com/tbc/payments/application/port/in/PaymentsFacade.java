package com.tbc.payments.application.port.in;

import com.tbc.payments.adapter.in.web.dto.ConfirmRequest;
import com.tbc.payments.adapter.in.web.dto.ConfirmResponse;
import com.tbc.payments.adapter.in.web.dto.CreatePaymentRequest;
import com.tbc.payments.adapter.in.web.dto.CreatePaymentResponse;
import com.tbc.payments.adapter.in.web.dto.RefundRequest;
import com.tbc.payments.adapter.in.web.dto.RefundResponse;

public interface PaymentsFacade {
    CreatePaymentResponse create(CreatePaymentRequest req);
    ConfirmResponse confirm(ConfirmRequest req);
    RefundResponse refund(RefundRequest req);
}