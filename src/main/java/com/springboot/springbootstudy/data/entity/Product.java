package com.springboot.springbootstudy.data.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity // 해당 클래스가 엔티티임을 명시. 클래스는 DB에서 테이블과 1:1로 매핑되고, 인스턴스는 테이블에서 하나의 레코드
@Getter // 롬복을 이용하여 Getter 메서드 자동  생성
@Setter // 롬복을 이용하여 Setter 메서드 자동  생성
@NoArgsConstructor // 롬복을 이용하여 파라미터가 아무것도 없는 생성자 생성
@AllArgsConstructor // 롬복을 이용하여 모든 필드 값을 다 받는 생성자 생성
@ToString // 롬복을 이용하여 toString() 메서드 자동 생성
// @Data >> Getter, Setter, NoArgsConstructor, AllArgsConstructor 등 클래스에 기본적으로 만들어지는 메서드와 생성자를 모두 생성해 주는 것
@Table(name = "product") // 클래스의 이름과 테이블의 이름이 다를 경우에 사용. DB와 JAVA의 명명 규칙이 다르기 때문에 자주사용함.
public class Product {
    @Id // 기본키. 필수
    @GeneratedValue(strategy = GenerationType.IDENTITY) // @Id와 함께 사용되며, 해당 필의 값을 어떤 방식으로 자동으로 생성할지 결정할 때 사용
    private Long number;
    /*
    GenerationType
     - AUTO: 기본 설정. 설정된 기본값에 맞게 자동으로 생성
     - IDENTITY: 기본값 생성을 DB에 위임. DB의 AUTO_INCREMENT를 사용한다
     - SEQUENCE: @SequenceGenerator로 식별자 생성기를 설정하고, 이를 통해 값을 자동 주입
     - TABLE: 어떤 DBMS를 사용하더라도 동일하게 동작하기를 원할 때 사용 @TableGenerator로 테이블 정보를 설정
    */


    @Column(nullable = false) // 앤티티 클래스의 필드는 자동으로 테이블 컬럼으로 매핑됨. 별다른 설정이 없을 경우 생략해도 무관
    private String name;

    @Column(nullable = false)
    private Integer price;

    @Column(nullable = false)
    private Integer stock;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
