package com.zhong.setting;

import com.zhong.utils.DateTimeUtil;
import com.zhong.utils.MD5Util;

public class test {
    public static void main(String[] args) {
        String formatSystemTime = DateTimeUtil.getFormatSystemTime();
        String time  = "2021-05-30 12:11:20";
        int i = formatSystemTime.compareTo(time);
        System.out.println(i);

        MD5Util md = new MD5Util();
        System.out.println(md.getMD5("guang994599834"));

    }
}
