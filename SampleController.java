package org.zerock.springex.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Controller
@Log4j2
public class SampleController {
    @GetMapping("/hello")
    public void hello() {
        log.info("hello....");
    }

    @GetMapping("/ex1")
    public void ex1(String name, int age) { // query String의 Parameter들을 형변환해줌.
        log.info("ex1.......");
        log.info("name: {}",name);
        log.info("age: {}",age);
    }

    @GetMapping("/ex2")
    public void ex2(@RequestParam(name="name", defaultValue = "AAA") String name,
                    @RequestParam(name="age", defaultValue="20") int age) {
        // RequestParam으로 query Parameter를 받고, 이름과 기본값을 정한 뒤 형변환
        log.info("ex2.......");
        log.info("name: {}",name);
        log.info("age: {}",age);
    }

    @GetMapping("/ex3")
    public void ex3(LocalDate dueDate) { // Date Parameter
        log.info("ex3.......");
        log.info("dueDate: {}", dueDate);
    }
}
