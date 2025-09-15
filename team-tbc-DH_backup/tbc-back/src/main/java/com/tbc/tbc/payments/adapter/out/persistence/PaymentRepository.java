package com.tbc.tbc.payments.adapter.out.persistence;

import com.tbc.tbc.payments.application.port.out.PaymentPersistencePort;
import com.tbc.tbc.payments.domain.payment.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PaymentRepository extends JpaRepository<Payment, Long>, PaymentPersistencePort {
    @Override
    Optional<Payment> findByOrderId(String orderId);

    @Override
    default Payment savePayment(Payment entity) {
        return save(entity);
    }
}
