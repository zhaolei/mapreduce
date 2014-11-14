package org.zhaolei;
import java.io.*;
import java.net.*;
import java.util.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        File directory = new File("");//设定为当前文件夹
        try{
            String path = new String(directory.getCanonicalPath());
            System.out.println(directory.getCanonicalPath());//获取标准的路径
            System.out.println(directory.getAbsolutePath());//获取绝对路径
            System.out.println(path);
        }catch(IOException e){}

        System.out.println( "Hello World!" );
    }
}
