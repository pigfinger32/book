package com.ib.book.member.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/***************************************************
* 
* Project  : ib_book_api
* Package  : com.ib.book.member.model.dto
* Filename : MemberListRes.java
* Description : 
* Writer : ljh  
* Date : 2025. 11. 04.
*
* Revision History
* Writer             Date       Description
* ------------------ ---------- -----------------------
* ljh             2025. 11. 04.
*
****************************************************/

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper=true)
// ErefundListReq의 example 필드처럼 JSON 형태로 전체 객체의 예시를 제공합니다.
@Schema(description = "회원 조회 객체", example = "{\n" +
        "  \"loginId\": \"testUser\",\n" +
        "  \"pw\": \"password123!\",\n" +
        "  \"name\": \"홍길동\",\n" +
        "  \"company\": \"(주)이비북\",\n" +
        "  \"city\": \"서울특별시\",\n" +
        "  \"street\": \"테헤란로 123\",\n" +
        "  \"zipcode\": \"06123\",\n" +
        "  \"phone\": \"010-1234-5678\",\n" +
        "  \"bizRegiNo\": \"123-45-67890\"\n" +
        "}"
)
public class MemberListRes {
	
	@Schema(description = "회원 고유 ID (생성 시 불필요)", example = "1", readOnly = true)
    private Long memberId;

    @Schema(description = "로그인 아이디", example = "testUser")
    private String loginId;

    @Schema(description = "비밀번호 (2023-05-09 추가)", example = "password123!")
    private String pw; 

    @Schema(description = "회원 이름", example = "홍길동")
    private String name;

    @Schema(description = "회사 이름 (2023-05-09 추가)", example = "(주)이비북")
    private String company;
    
    @Schema(description = "도시", example = "서울특별시")
    private String city;
    
    @Schema(description = "상세 주소", example = "테헤란로 123")
    private String street;
    
    @Schema(description = "우편번호", example = "06123")
    private String zipcode;

    @Schema(description = "전화번호 (2023-05-17 추가)", example = "010-1234-5678")
    private String phone;
    
    @Schema(description = "사업자등록번호 (2023-05-17 추가)", example = "123-45-67890")
    private String bizRegiNo;

}
