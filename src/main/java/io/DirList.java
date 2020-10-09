package io;

import java.io.File;
import java.util.Arrays;

/**
 * @author tengwz
 * 策略模式,正则表达式,File路径读取,args参数
 */
public class DirList {

    public static void main(String[] args) {
        File path = new File(".");
        String[] list;
        if(args.length == 0){
            list = path.list();
        }else {
            list = path.list(new DirFilter(args[0]));
        }
        Arrays.sort(list,String.CASE_INSENSITIVE_ORDER);
        for(String dirItem : list){
            System.out.println(dirItem);
        }
    }

}
