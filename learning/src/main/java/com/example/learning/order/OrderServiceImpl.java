package com.example.learning.order;


import com.example.learning.discount.DiscountPolicy;
import com.example.learning.discount.FixDiscountPolicy;
import com.example.learning.member.Member;
import com.example.learning.member.MemberRepository;
import com.example.learning.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.Discount(member, itemPrice);
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
    
}
