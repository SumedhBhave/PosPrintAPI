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
    String printService(@RequestBody PrintRequest printRequest){

        ProcessBuilderClass processBuilderClass = new ProcessBuilderClass();
        try {
            processBuilderClass.printMethod(printRequest);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "ok";
    }
}
