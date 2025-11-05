package com.ib.book.member.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ib.book.common.Const;
import com.ib.book.common.model.ResponseDto;
import com.ib.book.common.model.ResultMessage;
import com.ib.book.common.util.CoreUtil;
import com.ib.book.member.model.dto.MemberListReq;
import com.ib.book.member.model.dto.MemberListRes;
import com.ib.book.member.service.MemberService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/***************************************************
* 
* Project  : ib_book_api
* Package  : com.ib.book.member.controller
* Filename : MemberController.java
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

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/v1/member", produces = { "application/json;charset=UTF-8" })
@Tag(name = "사용자 Member API", description = "사용자 Member API")
@Slf4j
public class MemberController {
	
	@Autowired
	MemberService memberService;
	
	private final ResultMessage resultMessage;
	
	
	/*****************************************************
	 * 사용자 List 조회
	 * 
	 * @param MemberListReq memberListReq 사용자 조회 요청 Req
	 * @return ResponseEntity<ResponseDto> 사용자 List 조회
	 *****************************************************/
	@PostMapping(value = "/list")
	@Operation(summary = "사용자 List 조회", description = "사용자 List 조회", responses = {
	        @ApiResponse(responseCode = "200", description = "게시글 조회 성공", content = @Content(schema = @Schema(implementation = MemberListRes.class)))
	})
	public ResponseEntity<ResponseDto> selectMemberList(HttpServletRequest request,
			@RequestBody MemberListReq memberListReq) {

		// Http 리소스 상태 코드 및 리턴 메시지 정보
		HttpStatus status = HttpStatus.OK;
		String rstMessage = Const.Message.COMMON_MESSAGE_NO_DATA;
		String state = Const.State.COMMON_STATE_SUCCESS;
		
		List<MemberListRes> memberList = new ArrayList<>();
		HashMap<String, Object> data = new HashMap<String, Object>();
		Integer totCnt = 0;
		

		try {

			// 1.행사 환급 신청 정보 조회
			memberList = this.memberService.getMemberList(memberListReq);
			log.info("memberList >>> \n {}", memberList);
			
			totCnt = this.memberService.getMemberListCnt(memberListReq);
			
			
			if(CoreUtil.isNotEmpty(memberList)) {
				
				data.put("memberList", memberList);
				data.put("totalCount", totCnt);
				
				//4.종료
				rstMessage = Const.Message.COMMON_MESSAGE_SUCCESS;
				status = HttpStatus.OK;
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			
			state = Const.State.COMMON_STATE_ERR;
			rstMessage = Const.Message.COMMON_MESSAGE_ERROR;
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		
		return new ResponseEntity<>(
				ResponseDto.builder()
						.code(rstMessage)
						.state(state)
						.alertType("normal")
						.data(data)
						.resultMessage(resultMessage.getArgumentsMessage(rstMessage, null))
						.build(),
				status);

	}

}
