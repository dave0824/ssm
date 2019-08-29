package cn.dave.utils;

import java.util.UUID;

/**
 * @program: tour_ssm
 * @description:
 * @author: dave
 * @create: 2019-08-03 21:54
 **/

public class CommonUtils {
    public static String getUuid(){
        return UUID.randomUUID().toString().replaceAll("-","");
    }
}
