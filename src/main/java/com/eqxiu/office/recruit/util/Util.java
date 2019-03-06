package com.eqxiu.office.recruit.util;

import java.util.LinkedList;
import java.util.List;

public class Util {
    public static List<String> split(String text, char c){
        List<String> list = new LinkedList<>();
        if (text != null && !text.isEmpty()){
            char[] array = text.toCharArray();
            for (int i = 0, j = i; i < array.length; ){
                if (array[i] == c){
                    if (i != j){
                        list.add(new String(array, j, i-j));
                    }
                    j = i + 1;
                }
                i ++;
                if (i == array.length && j != i){
                    list.add(new String(array, j, i - j));
                }
            }
        }
        return list;
    }

    public static List<String> split(String text, char... cs){
        List<String> list = new LinkedList<>();
        if (text != null && !text.isEmpty() && cs != null && cs.length > 0){
            char[] array = text.toCharArray();
            boolean isSeparator = false;
            for (int i = 0, j = i; i < array.length; ){
                for (char c: cs){
                    if (c == array[i]){
                        isSeparator = true;
                        break;
                    }
                }
                if (isSeparator){
                    isSeparator = false;
                    if (i != j){
                        list.add(new String(array, j, i-j));
                    }
                    j = i + 1;
                }
                i ++;
                if (i == array.length && j != i){
                    list.add(new String(array, j, i - j));
                }
            }
        }
        return list;
    }
}
