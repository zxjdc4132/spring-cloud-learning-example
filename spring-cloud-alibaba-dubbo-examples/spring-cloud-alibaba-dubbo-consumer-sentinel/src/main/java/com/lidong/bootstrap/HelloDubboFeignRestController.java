package com.lidong.bootstrap;

import com.lidong.dubbo.service.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

@RestController
public class HelloDubboFeignRestController {


    @Autowired
    @Lazy
    private DubboFeignRestService dubboFeignRestService;

    @GetMapping(value = "/param")
    public String param(@RequestParam("param") String param){
        return dubboFeignRestService.param(param);
    }


    @PostMapping("/params")
    String params(@RequestParam("b") String paramB, @RequestParam("a") int paramA){
        return dubboFeignRestService.params(paramB,paramA);
    }

    @PostMapping(value = "/request/body/map", produces = APPLICATION_JSON_UTF8_VALUE)
    User requestBody(@RequestParam("param") String param,
                     @RequestBody Map<String, Object> data){
        return dubboFeignRestService.requestBody(param,data);
    }

    @GetMapping("/headers")
    public String headers(@RequestHeader("h2") String header2,
                          @RequestParam("v") Integer value, @RequestHeader("h") String header){
        return dubboFeignRestService.headers(header2,value,header);
    }

    @GetMapping("/path-variables/{p1}/{p2}")
    public String pathVariables(@RequestParam("v") String param,
                                @PathVariable("p2") String path2, @PathVariable("p1") String path1){
        return dubboFeignRestService.pathVariables(param,path2,path1);
    }
}
