package io;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

/**
 * @author tengwz
 * 类上加 final 的作用?
 * 这里用到了换行?
 */


//在类上加 final 和 static 起到了什么样的作用?
public final class Directory {
    public static File[]
    local(File dir,final String regex){
        return dir.listFiles(new FilenameFilter() {
            private Pattern pattern = Pattern.compile(regex);
            public boolean accept(File dir, String name) {
                return pattern.matcher(new File(name).getName()).matches();
            }
        });
    }
    //定义一系列的 static 方法是不是就可以实现函数式编程
//    public static void main(String[] args) {
//        for (File file:
//             local(new File("."))) {
//            System.out.println(file);
//        }
//
//    }
    //函数的重载,重载是为了让接口更加普适
    public static File[]
    local(String path,final String regex){
        return local(new File(path),regex);
    }

    //这个内部静态类,以及其内部的静态方法,普通成员,在外部是怎么表现的
    //可以正常访问吗?普通的内部类呢?
    //哦我明白了,只有声明为内部类,才可以在里面写静态的方法,写静态方法时为了
    //让外部可以直接调用,但因为一个静态方法需要用到另一个方法,
    //所以需要把这个方法也设为静态的
    //然而,为什么要大费周折,写一个内部类,而不是抽取来呢?
    //这是因为 static 只能修饰内部类
    public static class TreeInfo implements Iterable<File>{
        //这两有什么区别吗?
        public List<File> files = new ArrayList<File>();
        public List<File> dirs = new ArrayList<File>();
        public Iterator<File> iterator() {
            return files.iterator();
        }
        void addAll(TreeInfo other){
            files.addAll(other.dirs);
            dirs.addAll(other.files);
        }

        @Override
        public String toString() {
            return super.toString();
        }
        public static TreeInfo walk(File start){
            return recurseDirs(start,".");
        }



        //在类内部定义一个静态方法,那么,这个类所有的方法都可以访问,是吗?,以及可以直
        //接被外部调用,如果是普通的方法,可以吗?
        //静态方法只能访问静态成员
         static TreeInfo recurseDirs(File startDir,String regex){
            TreeInfo result = new TreeInfo();
            return result;
        }
    }





















}
