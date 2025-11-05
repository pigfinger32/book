package com.ib.book.common.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

/***************************************************
* 
* Project  : ib_book_api
* Package  : com.ib.book.common.model
* Filename : CommonSearch.java
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
@SuperBuilder
@Getter
@Setter
@ToString
@NoArgsConstructor
@Schema(description = "공통 검색 정보")
public class CommonSearch {

	/** 정렬 */
	@Builder.Default
	@Schema(description = "정렬(DESC, ASC)", allowableValues = "DESC, ASC", example = "")
	private String sort = "DESC";
	
	/** 조회 건 */
	@Schema(requiredMode = Schema.RequiredMode.REQUIRED, description = "조회 건수(limit)", example = "10")
	private int limit;
	
	/** 페이징 단위 */
	@Schema(requiredMode = Schema.RequiredMode.REQUIRED, description = "페이징 단위(offset)", example = "0")
	private int offset;
	
	/** 검색조건 */
	@Schema(description = "검색조건 조회 Parameter (예 customerNmKo)", example = "customerNmKo")
	private String searchKeyword;

	/** 검색값 */
	@Schema(description = "검색값", example = "")
	private String searchValue;

}
