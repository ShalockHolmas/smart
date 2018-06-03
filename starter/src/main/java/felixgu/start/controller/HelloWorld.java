package felixgu.start.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

//@EnableAutoConfiguration
@RestController
public class HelloWorld {

    @RequestMapping("/")
    List<String> home() {

        List<String> list = new ArrayList<>();
        list.add("sadasd");
        list.add("sadasd");
        list.add("sadasd");
        list.add("sadasd");
        list.add("sadasd");
        list.add("sadasd");
        list.add("sadasd");
        list.add("sadasd");
        list.add("sadasd");
        list.add("sadasd");
        return list;
    }

    //public static void main(String[] args) {
    //    SpringApplication.run(HelloWorld.class,args);
    //}
}
