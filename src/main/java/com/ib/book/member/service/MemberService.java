package com.ib.book.member.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ib.book.member.model.dao.MemberMapper;
import com.ib.book.member.model.dto.MemberListReq;
import com.ib.book.member.model.dto.MemberListRes;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


/***************************************************
*
* Project  : ib_book_api
* Package  : com.ib.book.member.service
* Filename : MemberService.java
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

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class MemberService {
	
	@Autowired
	public MemberMapper mapper;
	
	/*****************************************************
	 * 사용자 List Cnt 조회
	 * 
	 * @param MemberListReq memberListReq 사용자 조회 요청 Req
	 * @return int 사용자 List Cnt 조회
	 *****************************************************/
	@Transactional(readOnly = true)	
	public int getMemberListCnt(MemberListReq memberListReq) {
		int totCnt = this.mapper.getMemberListCnt(memberListReq);
		
		log.info("totCnt ", totCnt);

		return totCnt;
	}

	/*****************************************************
	 * 사용자 List 조회
	 * 
	 * @param MemberListReq memberListReq 사용자 조회 요청 Req
	 * @return ResponseEntity<ResponseDto> 사용자 List 조회
	 *****************************************************/
	@Transactional(readOnly = true)	
	public List<MemberListRes> getMemberList(MemberListReq memberListReq) {
		List<MemberListRes> memberList = new ArrayList<>();

		memberList = this.mapper.getMemberList(memberListReq);
		
		log.info("memberList ", memberList);

		return memberList;
	}

}
