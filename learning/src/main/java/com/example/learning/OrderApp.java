package com.example.learning;

import com.example.learning.member.Grade;
import com.example.learning.member.Member;
import com.example.learning.member.MemberService;
import com.example.learning.member.MemberServiceImpl;
import com.example.learning.order.Order;
import com.example.learning.order.OrderService;
import com.example.learning.order.OrderServiceImpl;

public class OrderApp {
    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        OrderService orderService = new OrderServiceImpl();

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(1L, "itemA", 10000);
        System.out.println("order = " + order.toString());
        System.out.println("discount = " + order.calculatePrice());

    }
}
