package com.ib.book.member.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ib.book.member.model.dto.MemberListReq;
import com.ib.book.member.model.dto.MemberListRes;

/***************************************************
*
* Project  : ib_book_api
* Package  : com.ib.book.member.model.dao
* Filename : MemberMapper.java
* Description :
* Writer : ljh 
* Date : 2025. 11. 05.
*
* Revision History
* Writer             Date       Description
* ---------------------------------------------------
* ljh             2025. 11. 05.
*
****************************************************/
@Repository
@Mapper
public interface MemberMapper {
	
	/*****************************************************
	 * 사용자 List Cnt 조회
	 * 
	 * @param MemberListReq memberListReq 사용자 조회 요청 Req
	 * @return int 사용자 List Cnt 조회
	 *****************************************************/
	@Transactional(readOnly = true)	
	public int getMemberListCnt(MemberListReq memberListReq);
	
	/*****************************************************
	 * 사용자 List 조회
	 * 
	 * @param MemberListReq memberListReq 사용자 조회 요청 Req
	 * @return ResponseEntity<ResponseDto> 사용자 List 조회
	 *****************************************************/
	@Transactional(readOnly = true)	
	public List<MemberListRes> getMemberList(MemberListReq memberListReq);
	
}
