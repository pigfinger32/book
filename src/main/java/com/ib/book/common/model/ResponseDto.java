package com.ib.book.common.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

/***************************************************
* 
* Project  : ib_book_api
* Package  : com.ib.book.common.model
* Filename : ResponseDto.java
* Description : 응답시 공통 포맷을 유지하기 위한 DTO
* Writer : ljh  
* Date : 2025. 11. 05.
*
* Revision History
* Writer             Date       Description
* ------------------ ---------- -----------------------
* ljh             2025. 11. 05.
*
****************************************************/

@Getter
@Builder
@ToString
@AllArgsConstructor
@Schema(description = "응답정보")
public class ResponseDto<T> {

	/** 결과메세지 */
	@Schema(description = "오류 코드(에러응답시 에러코드 필요한 경우에만 값이 설정됨)")
    @Builder.Default
    private String code = "";
	
    /** 통신상태 */
	@Schema(description = "통신상태")
    private String state;
    
	/** 결과메세지 */
	@Schema(description = "메시지 표출 타입(alert: 확인팝업, confirm: 선택팝업, normal: 유효성체크등 일반화면영역 표출")
    @Builder.Default
    private String alertType = "normal";
	
    /** 결과메세지 */
	@Schema(description = "결과메세지")
    private String resultMessage;

    /** 결과데이타 */
	@Schema(description = "결과데이타", requiredMode = Schema.RequiredMode.REQUIRED)
	private T data;
	
}
