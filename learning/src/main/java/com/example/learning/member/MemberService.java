package com.example.learning.member;

public interface MemberService {
    void join(Member member);
    Member findMember(Long memberId);
}
