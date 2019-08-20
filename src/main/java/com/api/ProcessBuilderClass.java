package com.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ProcessBuilderClass {
    private static final Logger logger = LoggerFactory.getLogger(ProcessBuilderClass.class);
    void printMethod(PrintRequest printRequest) throws IOException{
        String command[] = {"javac", printRequest.getFilePath()+"\\"+printRequest.getFile()+".java"};

        logger.info("Process file = "+ printRequest.getFilePath()+"\\"+printRequest.getFile()+".java");
        ProcessBuilder processBuilder = new ProcessBuilder(command);

        Process process = processBuilder.start();

        if( process.getErrorStream().read() != -1 ){
            print("Compilation Errors",process.getErrorStream());
        }
        if( process.exitValue() == 0 ){
            logger.info("Commandline args = "+"\""+printRequest.getPrinterName()+"\" \""+printRequest.getPrintContent()+"\" \""+printRequest.getPaperCutCommand()+"\"");

            process = new ProcessBuilder(new String[]{"java","-cp",printRequest.getFilePath(),
                    printRequest.getFile(), "\""+printRequest.getPrinterName()+"\" \""+printRequest.getPrintContent()+"\" \""+printRequest.getPaperCutCommand()+"\""}).start();

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

