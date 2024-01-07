package com.example.learning.discount;

import com.example.learning.member.Grade;
import com.example.learning.member.Member;

public class FixDiscountPolicy implements DiscountPolicy{

    private int DiscountFixAmount = 1000;

    @Override
    public int Discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP){
            return DiscountFixAmount;
        }
        else{
            return 0;
        }
    }
    
}
