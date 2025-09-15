package com.tbc.tbc.payments.adapter.out.persistence;

import com.tbc.tbc.payments.application.port.out.WalletPersistencePort;
import com.tbc.tbc.payments.domain.wallet.Wallet;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.*;

import java.util.Optional;

public interface WalletRepository extends JpaRepository<Wallet, Long>, WalletPersistencePort {

    @Override
    Optional<Wallet> findByUserId(Long userId);

    @Override
    @Lock(LockModeType.PESSIMISTIC_WRITE) // 비관적 락 (추천)
    @Query("select w from Wallet w where w.userId = :userId")
    Optional<Wallet> findByUserIdForUpdate(Long userId);

    @Override
    default Wallet saveWallet(Wallet entity) {
        return save(entity);
    }
}
