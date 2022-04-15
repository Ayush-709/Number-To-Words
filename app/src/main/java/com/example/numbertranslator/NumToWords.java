package com.example.numbertranslator;

import android.text.TextUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class NumToWords {

    public static String toWords(String txt){
        txt=txt.replaceAll(",","");
        long number = Long.parseLong(txt);
        long no=number;
        String res;
        HashMap<Integer, String> maps = new HashMap<>();
        maps.put(0, "");
        maps.put(1, "One");
        maps.put(2, "Two");
        maps.put(3, "Three");
        maps.put(4, "Four");
        maps.put(5, "Five");
        maps.put(6, "Six");
        maps.put(7, "Seven");
        maps.put(8, "Eight");
        maps.put(9, "Nine");
        maps.put(10, "Ten");
        maps.put(11, "Eleven");
        maps.put(12, "Twelve");
        maps.put(13, "Thirteen");
        maps.put(14, "Fourteen");
        maps.put(15, "Fifteen");
        maps.put(16, "Sixteen");
        maps.put(17, "Seventeen");
        maps.put(18, "Eighteen");
        maps.put(19, "Nineteen");
        maps.put(20, "Twenty");
        maps.put(30, "Thirty");
        maps.put(40, "Forty");
        maps.put(50, "Fifty");
        maps.put(60, "Sixty");
        maps.put(70, "Seventy");
        maps.put(80, "Eighty");
        maps.put(90, "Ninety");

        int dLen = String.valueOf(no).length();
        int i=0;
        ArrayList<String> str= new ArrayList<>();

        String [] digits= {"","Hundred", "Thousand", "Lakh", "Crore", "Arab", "Kharab"};

        while(i<dLen) {
            int divider=(i==2)?10:100;
            number=no%divider;
            no=no/divider;
            i+=(divider==10)?1:2;
            if(number>0) {
                int counter = str.size();
                String tmp = (number<21)? maps.get((int) number)+ " "+ digits[counter]:
                        maps.get((int) Math.floor(number / 10) * 10) + " " +
                                maps.get((int) (number % 10))+ digits[counter];
                str.add(tmp);
            }else {
                str.add("");
            }
        }

        Collections.reverse(str);
        res = TextUtils.join(" ",str).trim();
        return res;
    }

}
