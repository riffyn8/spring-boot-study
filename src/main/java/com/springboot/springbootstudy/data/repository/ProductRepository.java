package com.springboot.springbootstudy.data.repository;

import com.springboot.springbootstudy.data.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/*
레포지토리는 Spring Data JAP가 제공하는 인터페이스.
엔티티가 테이블 생성 및 구조 설정을 했다면, 레포지토리는 이 테이블에 접근할 때 사용하는 것.

레포지토리에는 메서드 이름에 특정 키워드를 설정하여 SQL을 자동으로 구성해 주는 기능이 있다
- FindBy: SQL의 WHERE 절 역할을 수행하며, 뒤에 필드명을 붙여 조건을 지정(예: findByName)
- And, Or: 여러 조건을 결합하여 검색할 때 사용 (예: findByNameAndEmail)
- Like / NotLike: SQL의 LIKE 연산자와 동일한 기능을 수행
- StartsWith / StartingWith: 특정 키워드로 시작하는 문자열 조건을 설정
- EndsWith / EndingWith: 특정 키워드로 끝나는 문자열 조건을 설정
- IsNull / IsNotNull: 해당 필드 값이 null인지 또는 null이 아닌지 확인
- True / False: Boolean 타입 필드의 참/거짓 여부를 확인
- Before / After: 날짜나 시간 타입을 기준으로 이전 또는 이후 데이터를 검색
- LessThan / GreaterThan: 특정 값을 기준으로 작거나(미만) 큰(초과) 데이터를 비교할 때 사용
- Between: 두 값 사이의 범위에 있는 데이터를 조회
- OrderBy: 특정 필드를 기준으로 결과를 정렬 (SQL의 ORDER BY)
- CountBy: 조건에 부합하는 데이터의 전체 개수를 반환 (SQL의 COUNT)
*/
public interface ProductRepository extends JpaRepository<Product, Long> {
}
