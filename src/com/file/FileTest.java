package com.file;

import java.io.File;

public class FileTest {

    private static int countTxt(File f) {
        if(f == null || !f.exists()) return 0;
        int count = 0;
        File[] list = f.listFiles();
        for (File item : list) {
            if(item == null || !item.exists())continue;
            if(item.isFile()) {//是文件
                String fileName = item.getName();
                if(".txt".equals(fileName.substring(fileName.lastIndexOf("."), fileName.length()))) {
                    count++;
                } else {
                    continue;
                }
            } else {
                count += countTxt(item);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println("args="+countTxt(new File("/Users/51talk/Downloads/test")));
    }

}
