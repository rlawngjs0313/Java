package com.example.learning.discount;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.example.learning.member.Grade;
import com.example.learning.member.Member;

public class RateDiscountPolicyTest {

    RateDiscountPolicy rateDiscountPolicy = new RateDiscountPolicy();
    
    @Test
    @DisplayName("VIP = 10% 할인")
    void discount(){
        Member member = new Member(1L, "memberA", Grade.VIP);
        int discount = rateDiscountPolicy.Discount(member, 10000);
        Assertions.assertThat(discount).isEqualTo(1000);
    }

    @Test
    @DisplayName("BASIC != 10% 할인")
    void discount2(){
        Member member = new Member(1L, "memberA", Grade.BASIC);
        int discount = rateDiscountPolicy.Discount(member, 10000);
        Assertions.assertThat(discount).isEqualTo(0);
    }

}
