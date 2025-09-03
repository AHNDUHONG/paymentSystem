package com.tbc.payments.repository;

import com.tbc.payments.domain.wallet.WalletLedger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletLedgerRepository extends JpaRepository<WalletLedger, Long> { }
