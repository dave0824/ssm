package cn.dave.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @program: tour_ssm
 * @description:测试加密
 * @author: dave
 * @create: 2019-08-05 17:48
 **/

public class BCryptPasswordEncoderTest {


    public static String getPassword(String ps){
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder.encode(ps);
    }

    public static void main(String[] args) {
        System.out.println(getPassword("123"));
    }
}
