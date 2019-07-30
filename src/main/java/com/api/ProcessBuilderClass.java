package com.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ProcessBuilderClass {
    private static final Logger logger = LoggerFactory.getLogger(ProcessBuilderClass.class);
    public void printMethod(String printerName, String content, String filePath, String fileName) throws IOException{
        String command[] = {"javac", filePath+"\\"+fileName+".java"};

        logger.info("Process file = "+ filePath+"\\"+fileName+".java");
        ProcessBuilder processBuilder = new ProcessBuilder(command);

        Process process = processBuilder.start();

        String content1 = "";
        content1 = content1 +"       Barbeque Nation Pvt. Ltd.        "+System.getProperty("line.separator");
        content = content1 +"--------------------------------------- "+System.getProperty("line.separator");

       // content = content.replaceAll("\n", "\\\n");
        if( process.getErrorStream().read() != -1 ){
            print("Compilation Errors",process.getErrorStream());
        }
        if( process.exitValue() == 0 ){
            logger.info("Commandline args = "+"\""+printerName+"\" \""+content+"\"");

            process = new ProcessBuilder(new String[]{"java","-cp",filePath,fileName, "\""+printerName+"\" \""+content+"\""}).start();

            if( process.getErrorStream().read() != -1 ){
                print("Errors ",process.getErrorStream());
            }
            else{
                print("Output ",process.getInputStream());
            }

        }
    }


    private static void print(String status, InputStream input) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(input));
        System.out.println("************* "+status+"***********************");
        String line = null;
        while((line = in.readLine()) != null ){
            logger.info("Status of printing = "+ line);
            System.out.println(line);
        }
        in.close();
    }

}

