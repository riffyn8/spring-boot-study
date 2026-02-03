package com.springboot.springbootstudy.controller;

import com.springboot.springbootstudy.dto.MemberDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("api/v1/post-api")
public class PostController {
    // @RequestBody를 활용한 데이터 수신
    // HTTP Body의 내용을 지정된 객체에 매핑하는 역할
    // 어떤 값이 전달될지 특정하기 어려운 경우 Map 객체를 사용
    // 전달받을 값이 정해져 있는 경우에는 DTO 객체를 매개변수로 활용
    @PostMapping(value = "/member")
    public String postMember(@RequestBody Map<String, Object> postData) {
        StringBuilder sb = new StringBuilder();

        postData.entrySet().forEach(map -> {
            sb.append(map.getKey() + " : " + map.getValue() + "\n");
        });

        return sb.toString();
    }

    @PostMapping(value ="/member2")
    public String postMemberDto(@RequestBody MemberDto memberDto) {
        return memberDto.toString();
    }

    // ResponseEntity
    // 클라이언트의 요청에 대해 응답 데이터와 HTTP 상태 코드를 직접 구성하여 전달
    @PostMapping(value ="/member3")
    public ResponseEntity<MemberDto> postMemberDto2(@RequestBody MemberDto memberDto) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(memberDto);
    }
}
