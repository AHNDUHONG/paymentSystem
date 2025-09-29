package com.tbc.group.application.port.out;

import java.time.LocalDateTime;
import java.util.List;

public interface GroupMemberRepository {

    void addHost(Long groupId, Long userId);

    // 일반 멤버(참가자) 등록
    void addMember(Long groupId, Long userId, String role, String status);

    // 취소가 아닌(활성) 참가 여부
    boolean existsActiveMember(Long groupId, Long userId);

    int countActiveMembers(Long groupId);

    // 참가자 조회(취소 포함/제외)
    List<GroupMemberView> findMembers(Long groupId, boolean excludeCancelled);

    // 조회용 뷰
    record GroupMemberView(Long userId, String role, String status, LocalDateTime joinedAt) {}
}
