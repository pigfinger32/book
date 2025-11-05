package com.ib.book.member.model.dto;

import com.ib.book.common.model.CommonSearch;

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
* Filename : MemberListReq.java
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
@ToString(callSuper = true)
@Schema(description = "행사 질문사항 List REQ")
public class MemberListReq extends CommonSearch{
	
	@Schema(description = "회원 고유 ID", example = "1")
    private Integer memberId;

}
