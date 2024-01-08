package com.example.learning.order;


import com.example.learning.discount.DiscountPolicy;
import com.example.learning.member.Member;
import com.example.learning.member.MemberRepository;

public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;
    
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.Discount(member, itemPrice);
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
    
}
