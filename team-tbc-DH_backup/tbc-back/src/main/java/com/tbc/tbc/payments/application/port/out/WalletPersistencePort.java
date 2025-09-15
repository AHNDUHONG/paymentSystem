package com.tbc.tbc.payments.application.port.out;

import com.tbc.tbc.payments.domain.wallet.Wallet;

import java.util.Optional;

public interface WalletPersistencePort {
    Optional<Wallet> findByUserId(Long userId);
    Optional<Wallet> findByUserIdForUpdate(Long userId);
    Wallet saveWallet(Wallet wallet);
}