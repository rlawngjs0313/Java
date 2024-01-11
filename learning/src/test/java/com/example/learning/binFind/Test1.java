package com.example.learning.binFind;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.learning.AppConfig;
import com.example.learning.discount.DiscountPolicy;
import com.example.learning.member.MemberRepository;
import com.example.learning.member.MemoryMemberRepository;

public class Test1 {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SameBean.class);

    @Test
    void findBeanByDup(){
        assertThrows(NoUniqueBeanDefinitionException.class, 
        () -> ac.getBean(MemberRepository.class));
    }

    @Test
    void findBeanByAll(){
        Map<String, MemberRepository> beansOfType = ac.getBeansOfType(MemberRepository.class);
        for (String key : beansOfType.keySet()){
            System.out.println("Key : " + key + "Value : " + beansOfType.get(key));
        }
    }

    @Configuration
    static class SameBean{

        @Bean
        public MemberRepository memberRepository1(){
            return new MemoryMemberRepository();
        }

        @Bean
        public MemberRepository memberRepository2(){
            return new MemoryMemberRepository();
        }
    }
}
