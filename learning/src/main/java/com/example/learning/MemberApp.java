package com.example.learning;

import com.example.learning.member.Grade;
import com.example.learning.member.Member;
import com.example.learning.member.MemberService;
import com.example.learning.member.MemberServiceImpl;

public class MemberApp {
    
    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("1: " + member.getName());
        System.out.println("2: " + findMember.getGrade());
    }
}