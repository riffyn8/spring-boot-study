package com.springboot.springbootstudy.controller;

import com.springboot.springbootstudy.dto.MemberDto;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/get-api")
public class GetController {

    // 매개변수가 없는 GET 메서드
    @GetMapping(value ="/name")
    public String getName() {
        return "John";
    }

    // 경로 변수(Path Variable)를 활용해 매개변수를 받는 경우
    // 예: 게시글 조회 시 {variable} 자리에 해당 값을 입력
    // 중괄호 안의 변수명과 매개변수명이 일치해야 한다.
    // 변수명이 서로 달라야 한다면 @PathVariable("변수명") 형식을 통해 직접 지정 가능
    @GetMapping(value ="/variable1/{variable}")
    public String getVariable1(@PathVariable String variable) {
        return variable;
    }

    // 쿼리 스트링(query string)을 통한 매개변수 바인딩
    // 예: /request1?name=이름&email=이메일&organization=조직
    @GetMapping(value = "/request1")
    public String getRequestParam1(@RequestParam String name, @RequestParam String email, @RequestParam String organization) {
        return name + " " + email + " " + organization;
    }

    // 쿼리 스트링의 키를 특정할 수 없는 경우 Map 객체를 활용하여 바인딩 가능
    @GetMapping(value ="/request2")
    public String getRequestParam2(@RequestParam Map<String, String> param) {
        StringBuilder sb = new StringBuilder();

        param.entrySet().forEach(map -> {
            sb.append(map.getKey() + " : " + map.getValue() + "\n");
        });

        return sb.toString();
    }

    // DTO 객체를 활용한 바인딩
    @GetMapping(value="/request3")
    public String getRequestParam3(MemberDto memberDto) {
        return memberDto.toString();
    }
}
