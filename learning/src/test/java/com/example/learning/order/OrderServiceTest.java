package com.example.learning.order;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.learning.AppConfig;
import com.example.learning.member.Grade;
import com.example.learning.member.Member;
import com.example.learning.member.MemberService;

public class OrderServiceTest {

    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }
    

    @Test
    void order(){
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);
        Order order = orderService.createOrder(1L, "itemA", 10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
        

    }
}
