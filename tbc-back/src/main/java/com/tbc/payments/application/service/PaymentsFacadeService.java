package com.tbc.payments.application.service;

import com.tbc.payments.adapter.in.web.dto.ConfirmRequest;
import com.tbc.payments.adapter.in.web.dto.ConfirmResponse;
import com.tbc.payments.adapter.in.web.dto.CreatePaymentRequest;
import com.tbc.payments.adapter.in.web.dto.CreatePaymentResponse;
import com.tbc.payments.adapter.in.web.dto.RefundRequest;
import com.tbc.payments.adapter.in.web.dto.RefundResponse;
import com.tbc.payments.application.port.in.PaymentUseCase;
import com.tbc.payments.application.port.in.PaymentsFacade;
import com.tbc.payments.application.port.in.RefundUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentsFacadeService implements PaymentsFacade {

    private final PaymentUseCase paymentUseCase;
    private final RefundUseCase refundUseCase;

    @Override
    public CreatePaymentResponse create(CreatePaymentRequest req) {
        return paymentUseCase.createInit(req);
    }

    @Override
    public ConfirmResponse confirm(ConfirmRequest req) {
        return paymentUseCase.confirmAndCredit(req);
    }

    @Override
    public RefundResponse refund(RefundRequest req) {
        return refundUseCase.refund(req);
    }
}