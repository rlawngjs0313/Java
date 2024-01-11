package com.example.learning;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.example.learning.member.Grade;
import com.example.learning.member.Member;
import com.example.learning.member.MemberService;
import com.example.learning.order.Order;
import com.example.learning.order.OrderService;

public class OrderApp {
    public static void main(String[] args) {
        
        /* AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService(); */

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(1L, "itemA", 20000);
        System.out.println("order = " + order.toString());
        System.out.println("discount = " + order.calculatePrice());

    }
}
