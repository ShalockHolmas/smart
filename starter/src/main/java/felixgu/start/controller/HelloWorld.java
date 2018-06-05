package felixgu.start.controller;

import felixgu.start.bean.Test;
import felixgu.start.exception.MyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

//@EnableAutoConfiguration
@RestController
public class HelloWorld {


    @Autowired
    private Test test;

    @RequestMapping("/")
    List<String> home() throws MyException {

        List<String> list = new ArrayList<>();
        list.add("sadasd");
        System.out.println(test.getTest());
        System.out.println(test.getConfigtest());
        //throw new MyException("400", "test");
        return null;
    }

    //public static void main(String[] args) {
    //    SpringApplication.run(HelloWorld.class,args);
    //}

    @RequestMapping(value = "/{user}",method = RequestMethod.GET)
    public String getString(@PathVariable String user){

        return user;
    }
}
