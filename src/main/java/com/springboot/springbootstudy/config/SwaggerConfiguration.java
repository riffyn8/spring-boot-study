package com.springboot.springbootstudy.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;

/*
스프링부트 3.x 이상부터는 springdoc-openapi를 사용
implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.8.14")

@Operation(summary = "", description = "") -> API 메서드 자체의 기능과 의도를 설명할 때
@ApiResponse(responseCode = "", description = "") -> API 실행 후 어떤 응답을 하는지
@ApiResponses(value = {}) -> 여러개의 응답이 있을 때는 ApiResponses를 사용
@Parameter(name="", description = "") -> 어떤 파라메터를 전달하는지
@Schema(description = "", example = "") -> DTO의 클래스와 필드에 붙여서 데이터의 의미와 예시값을 작성
@Tag(name = "", description = "") -> API를 그룹화할 때 사용. 컨트롤러 상단에 붙이면 해당 컨트롤러의 모든 API가 하나로 묶임
 */
public class SwaggerConfiguration {
    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .components(new Components())
                .info(apiInfo());
    }

    private Info apiInfo() {
        return new Info()
                .title("Spring Boot Open API Test with Swagger")
                .description("설명")
                .version("1.0.0");
    }
}
