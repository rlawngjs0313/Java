package com.example.learning.discount;

import com.example.learning.member.Member;

public interface DiscountPolicy {

    int Discount(Member member, int price);

}
