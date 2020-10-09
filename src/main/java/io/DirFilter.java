package io;

import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

/**
 * @author tengwz
 */
public class DirFilter implements FilenameFilter {
    private Pattern pattern;//正则表达式
    //初始化
    public DirFilter(String regx){
        //Pattern类用于创建一个正则表达式,也可以说创建一个匹配模式,它的构造方法是私有的,不可以直接创建,
        // 但可以通过Pattern.complie(String regex)简单工厂方法创建一个正则表达式,
        pattern = Pattern.compile(regx);
    }

    //我说为什么接口都要加上注释,这里的 name 在上层中的作用就是文件目录的每一个文件名称
    public boolean accept(File dir, String name) {
        //这里可以用 equals 啦,啥啥啥的,主要功能就是实现一个匹配,注入一个正则表达式,看你匹不匹配
        return pattern.matcher(name).matches();
    }
    //Pattern.matcher(String regex,CharSequence input)是一个静态方法,
    // 用于快速匹配字符串,该方法适合用于只匹配一次,且匹配全部字符串.

}
