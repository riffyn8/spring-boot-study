package com.springboot.springbootstudy.example.controller;

import com.springboot.springbootstudy.dto.MemberDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/get-api")
public class GetController {

    private final Logger LOGGER = LoggerFactory.getLogger(GetController.class);

    // 매개변수가 없는 GET 메서드
    @GetMapping(value ="/name")
    @Operation(summary = "매개변수가 없는 GET 메서드", description = "보통은 전체 데이터를 호출 할 때 사용")
    public String getName() {
        LOGGER.info("getName 메서드가 호출되었습니다.");
        return "John";
    }

    // 경로 변수(Path Variable)를 활용해 매개변수를 받는 경우
    // 예: 게시글 조회 시 {variable} 자리에 해당 값을 입력
    // 중괄호 안의 변수명과 매개변수명이 일치해야 한다.
    // 변수명이 서로 달라야 한다면 @PathVariable("변수명") 형식을 통해 직접 지정 가능
    @GetMapping(value ="/variable1/{variable}")
    @Operation(summary = "경로 변수를 활용한 GET 메서드", description = "주로 특정 데이터를 조회할 때 사용 (예: 게시글 조회시 글 번호를 전달)")
    @ApiResponse(responseCode = "200", description = "api 조회 성공")
    public String getVariable1(@Parameter(name="variable", description = "중괄호 안의 변수명과 매개변수명은 일치해야 한다.") @PathVariable String variable) {
        // 변수의 값이 들어갈 부분을 중괄호로 지정하면 포매팅을 통해 로그 메시지가 구성된다.
        LOGGER.info("@PatchVariable을 통해 들어온 값: {}", variable);
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
