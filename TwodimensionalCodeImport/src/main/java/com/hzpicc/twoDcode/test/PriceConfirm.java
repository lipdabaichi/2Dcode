package com.hzpicc.twoDcode.test;

import java.util.Scanner;

public class PriceConfirm {

    public Integer PriceHowMuch(Integer nums){
        int zhangshu = nums * 2;
        double beishu = Math.ceil((double)zhangshu / 6);
        System.out.println(beishu);
        Integer beishu1 = Integer.valueOf((int) beishu);
        int pirce = beishu1 * 8;
        System.out.println("我要几块："+pirce);
        return pirce;
    }

    public static void main(String[] args) {
        PriceConfirm priceConfirm = new PriceConfirm();
        priceConfirm.PriceHowMuch(23);
    }
}
