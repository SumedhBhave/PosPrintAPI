package com.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

@Controller
@RequestMapping("/print")
public class PrintController {
    @RequestMapping(value = "/data", method = RequestMethod.POST)
    public
    @ResponseBody
    String printService(@RequestBody PrintRequest printRequest) {

        PrinterService.printString(printRequest);

        if(printRequest.getPaperCutCommand() != null){
            System.out.println("Actual Command:: " + printRequest.getPaperCutCommand());
            String[] codes = printRequest.getPaperCutCommand().split(",");
            String command = "";
            for (int i = 0; i < codes.length; i++){
                command += (char)(Integer.parseInt(codes[i]));
            }
            System.out.println("Converted Command:: " + command);
            PrinterService.printBytes(printRequest.getPrinterName(),command);
        }

        return "ok";
    }
}
