package io;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * @author tengwz
 * 回去认真看一下这两个代码
 * 可以帮助我写出
 * 精简的内部类,以及为什么会需要写内部类,为什么呢?
 * 貌似用到回调的时候,要实现接口的时候
 * 策略模式
 * pattern
 * 为什么会用到 final?内部类中需要用到外部的变量,只有用到 final 才能使类用到外部的对象.
 * static 不能用在这里,那 static 可以用在哪里?
 * 回去解答这些问题
 */
public class DirList2 {
    //regex必须是 final 的
    public static FilenameFilter filenameFilter(final String regex){
        //对于就实现接口的方法,而本身却没啥用的,直接内部类就完事.
        return new FilenameFilter() {
            private Pattern pattern = Pattern.compile(regex);
            public boolean accept(File dir, String name) {
                return pattern.matcher(name).matches();
            }
        };
    }

    public static void main(String[] args) {
        File path = new File(".");
        String[] lists;
        if(args.length == 0){
            lists = path.list();
        }else {
            //按理说,这里应该传一个对象,这里却传了一个方法?,怎么感觉有点像函数式编程?
            //另外,这是一个静态方法,在本类中可以不加类名,好像.
            lists = path.list(filenameFilter(args[0]));
            Arrays.sort(lists,String.CASE_INSENSITIVE_ORDER);
            for(String dirItem : lists){
                System.out.println(dirItem);
            }
        }
    }
}
