package com.example.learning;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.learning.discount.DiscountPolicy;
import com.example.learning.discount.RateDiscountPolicy;
import com.example.learning.member.MemberRepository;
import com.example.learning.member.MemberService;
import com.example.learning.member.MemberServiceImpl;
import com.example.learning.member.MemoryMemberRepository;
import com.example.learning.order.OrderService;
import com.example.learning.order.OrderServiceImpl;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }
}
