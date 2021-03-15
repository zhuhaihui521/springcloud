package com.mall.huitop.test;

import cn.hutool.core.util.StrUtil;
import com.mall.huitop.bo.AdminUserDetails;
import com.mall.huitop.dto.PmsProductParam;
import com.mall.huitop.entity.UserResource;
import io.netty.util.internal.StringUtil;
import org.openjdk.jol.info.ClassLayout;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Auther zhuhaihui
 * @Date 2020-08-21 20:40
 */
public class B {
    public static void main(String[] args) throws InterruptedException {
        String d="hello";
        int a=129;
        double b = 129.0;
        float c = 129f;
        System.out.println(a == b);
        System.out.println(b == c);
        HashSet set=new HashSet();
        HashMap hashMap=new HashMap();
        float f = 3 * 0.1f;
        System.out.println(f == 0.3);
    }
}
