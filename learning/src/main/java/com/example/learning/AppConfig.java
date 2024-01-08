package com.example.learning;

import com.example.learning.discount.DiscountPolicy;
import com.example.learning.discount.RateDiscountPolicy;
import com.example.learning.member.MemberRepository;
import com.example.learning.member.MemberService;
import com.example.learning.member.MemberServiceImpl;
import com.example.learning.member.MemoryMemberRepository;
import com.example.learning.order.OrderService;
import com.example.learning.order.OrderServiceImpl;

public class AppConfig {

    
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }

    private MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    private DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }
}
