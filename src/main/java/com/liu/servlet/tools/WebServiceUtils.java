package com.liu.servlet.tools;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Create By lius on 2020/7/25
 */
public class WebServiceUtils {

    public static List<String> getJarFiles(){
        String jarDir = "D:\\cxfservice\\";
        File jarDirFile = new File(jarDir);
        File[] files = jarDirFile.listFiles();
        List<String> jarNames = new ArrayList<>();
        for(File tempFile:files){
            if(tempFile.getName().endsWith(".jar")){
                jarNames.add(tempFile.getName());
            }
        }
        return jarNames;
    }

}
