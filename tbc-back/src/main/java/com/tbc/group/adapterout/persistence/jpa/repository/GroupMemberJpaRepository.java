package com.tbc.group.adapterout.persistence.jpa.repository;

import com.tbc.group.adapterout.persistence.jpa.entity.GroupMemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupMemberJpaRepository extends JpaRepository<GroupMemberEntity, Long> {
    int countByGroupIdAndStatus(Long groupId, String status);
    // 중복 체크
    boolean existsByGroupIdAndUserIdAndStatusNot(Long groupId, Long userId, String status);
    // 참가자 목록
    List<GroupMemberEntity> findByGroupId(Long groupId);

    List<GroupMemberEntity> findByGroupIdAndStatusNot(Long groupId, String status);
}
