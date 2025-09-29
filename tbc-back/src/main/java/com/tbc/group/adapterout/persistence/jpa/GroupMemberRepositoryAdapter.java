package com.tbc.group.adapterout.persistence.jpa;

import com.tbc.group.adapterout.persistence.jpa.entity.GroupMemberEntity;
import com.tbc.group.adapterout.persistence.jpa.repository.GroupMemberJpaRepository;
import com.tbc.group.application.port.out.GroupMemberRepository;
import com.tbc.point.adapters.in.web.dto.ParticipantResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class GroupMemberRepositoryAdapter implements GroupMemberRepository {

    private final GroupMemberJpaRepository repo;

    @Override
    public void addHost(Long groupId, Long userId) {
        repo.save(GroupMemberEntity.builder()
                .groupId(groupId)
                .userId(userId)
                .role("HOST")
                .status("ACTIVE")
                .joinedAt(LocalDateTime.now())
                .build());
    }

    @Override
    public int countActiveMembers(Long groupId) {
        return repo.countByGroupIdAndStatus(groupId, "ACTIVE");
    }

    // 참가 로직에서 사용할 helper들 (포트에 굳이 넣지 않고 어댑터 공개 메소드로 사용)
    public void addMember(Long groupId, Long userId, String role, String status) {
        repo.save(GroupMemberEntity.builder()
                .groupId(groupId)
                .userId(userId)
                .role(role == null || role.isBlank() ? "MEMBER" : role) // 요청값 반영
                .status(status == null || status.isBlank() ? "ACTIVE" : status)
                .joinedAt(LocalDateTime.now())
                .build());
    }

    public boolean existsActiveMember(Long groupId, Long userId) {
        return repo.existsByGroupIdAndUserIdAndStatusNot(groupId, userId, "CANCELLED");
    }

    @Override
    public List<GroupMemberView> findMembers(Long groupId, boolean excludeCancelled) {
        var rows = excludeCancelled
                ? repo.findByGroupIdAndStatusNot(groupId, "CANCELLED")
                : repo.findByGroupId(groupId);

        return rows.stream()
                .map(e -> new GroupMemberView(   // record 매핑
                        e.getUserId(),
                        e.getRole(),
                        e.getStatus(),
                        e.getJoinedAt()
                ))
                .toList();
    }
}
