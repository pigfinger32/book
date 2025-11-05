package com.ib.book.common;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

/***************************************************
* 
* Project  : ib_book_api
* Package  : com.ib.book.common
* Filename : Const.java
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
@Component
@Aspect
@RequiredArgsConstructor
public class Const {
	
	/** 메세지 아이디 정보 */
	public static class Message {
		public static final String COMMON_MESSAGE_SUCCESS 			= "success";		// 요청이 정상적으로 처리되었습니다.
		public static final String COMMON_MESSAGE_NO_DATA 			= "nodata";			// 데이터가 없습니다.
		public static final String COMMON_MESSAGE_SEARCH 			= "search";			// 정상적으로 조회 하였습니다.
		public static final String COMMON_MESSAGE_INSERT 			= "insert";			// 정상적으로 등록 하였습니다.
		public static final String COMMON_MESSAGE_UPDATE 			= "update";			// 정상적으로 수정 하였습니다.
		public static final String COMMON_MESSAGE_DELETE 			= "delete";			// 정상적으로 삭제 하였습니다.
		public static final String COMMON_MESSAGE_SAVE 				= "save";			// 정상적으로 저장 하였습니다
		public static final String COMMON_MESSAGE_FAIL	 			= "fail";			// 요청 처리가 실패되었습니다.
		public static final String COMMON_MESSAGE_ERROR 			= "error";			// 에러가 발생 되었습니다.
		public static final String COMMON_MESSAGE_NO_DELETE 		= "nodelete";		// 삭제할 데이터가 없습니다.
		public static final String COMMON_MESSAGE_NOT_MOV 			= "not-mov";		// 이동이 불가능 합니다
		public static final String COMMON_MESSAGE_DUP_ERROR		    = "dup-error";		// Duplicate entry.
		public static final String COMMON_MESSAGE_NO_UPLOAD_FILE	= "no-uploadfile";  	// 파일을 선택해주세요.
		public static final String COMMON_MESSAGE_ONE_UPLOAD_FILE   = "one-uploadfile"; 	// 하나의 파일만 업로드 할 수 있습니다.
		public static final String COMMON_MESSAGE_NO_DOWNLOAD_FILE	= "nodownloadfile";  	// 다운로드 할 파일이 없습니다.
		public static final String COMMON_MESSAGE_DOWNLOAD_SUCCESS  = "download-success";  	// 정상적으로 파일을 다운로드 했습니다.
		public static final String COMMON_MESSAGE_DOWNLOAD_FAIL		= "download-fail";  	// 파일 다운로드가 실패했습니다.
		public static final String COMMON_MESSAGE_CHK_FILE_TYPE	    = "chk_filetype";  		// 파일 형식을 확인해주세요.
		public static final String COMMON_MESSAGE_DIFF_TEMPLATE		= "diff-template";      // 템플릿 형식이 다릅니다. 템플릿을 새로 다운받고 등록 해주세요.
		public static final String COMMON_MESSAGE_NO_INPUT_DATA		= "no-input-data";      // 필수(노란색 셀) 값을 입력해주세요. 
		public static final String COMMON_MESSAGE_EXCEL_NO_DATA 	= "excel-nodata";		// 엑셀 데이터가 없습니다 엑셀 파일을 확인 해 주세요.	
		
		public static final String BOARD_MESSAGE_NO_SUBJECT_OR_CONTENT	= "no-subject-or-content";      // 제목과 내용 모두 입력해주세요. 
		
		public static final String JOIN_MESSAGE_USER_ID_OK 			= "user-id-ok";		// 사용 가능한 아이디 입니다.
		public static final String JOIN_MESSAGE_USER_ID_NO			= "user-id-no";		// 이미 사용 중인 아이디 입니다.
		
		public static final String PASSWORD_MESSAGE_SEND_TEMP_PWD 	= "send-temp-pwd";		// 임시 비밀번호가 이메일로 전송 되었습니다.
		public static final String PASSWORD_MESSAGE_USER_ID_NO 		= "pwd-user-id-no";		// 일치하는 회원이 없습니다.
		public static final String PASSWORD_MESSAGE_UPDATE_USER_PW 	= "update-user-pw";		// 비밀번호가 정상적으로 변경되었습니다.
		public static final String PASSWORD_MESSAGE_NOT_MATCH_PREV_PW 	= "not-match-prev-pw";	// 기존 비밀번호가 일치하지 않습니다.
		public static final String PASSWORD_MESSAGE_NOT_MATCH_NEW_PW 	= "not-match-new-pw";		// 변경 비밀번호가 일치하지 않습니다.
			
		public static final String LOGIN_MESSAGE_NOT_MATCH_ID 		= "not-match-id";	// 아이디 / 비밀번호가 일치하지 않습니다
		public static final String LOGIN_MESSAGE_NOT_MATCH_INFO 	= "not-match-info";	// 일치하는 회원정보가 없습니다
		public static final String LOGIN_MESSAGE_DUP_INFO 	        = "dup.info";	    // 이미 등록된 회원정보가 있습니다.
		public static final String LOGIN_MESSAGE_NOT_SESSION 		= "no-session";		// 로그인 해주십시오
		public static final String LOGIN_MESSAGE_NOT_LOGOUT 		= "not-logout";		// 로그아웃 중 오류가 발생하였습니다. 관리자에게 문의하여 주십시오
		public static final String LOGIN_MESSAGE_INVALID_TOKEN 		= "invalid-token";	// 로그인 인증정보가 유효하지 않습니다. 로그인하여 주십시오.
		public static final String LOGIN_MESSAGE_EXPIRED_TOKEN		= "expired-token";	// 로그인 토큰정보가 만료 되었습니다. 로그인하여 주십시오.
		public static final String LOGIN_MESSAGE_REFRESH_TOKEN		= "refresh-token";  // 로그인 토큰정보 갱신이 필요합니다.
		public static final String LOGIN_MESSAGE_RENEW_ERR			= "renew-err";  	// 유효 하지 않은 토큰정보 입니다.	
		
		public static final String CHKIN_MESSAGE_ROOMNO_DUP_ERROR	= "roomno-dup-error";      // 이미 등록된 객실 번호 입니다.
		public static final String ACCOM_MESSAGE_CHKINDATA_REMAIN_ERROR	= "chkindata-remain-error";      // 체크인 정보가 존재합니다. 체크인 정보를 먼저 초기화 해주세요.
		
		public static final String VHALL_MESSAGE_DAY_MEAL_DUP_ERROR	= "day-meal-dup-error";      // 행사 일자와 식사 구분이 겹치지 않도록 선택해주세요.(ex)(행사일자 - 1일차, 식사 구분 - 조식) 행사 일자 및 식사 구분이 현재 중복되었습니다.
		public static final String VHALL_MESSAGE_DAY_MEAL_NOT_SAME	= "day-meal-not-same";       // 행사 일자별로 같은 식사 구분만 선택하실 수 있습니다. 식사 구분 변경을 원하신다면, 기존에 등록된 사항을 삭제 후 새로 저장 바랍니다.

	}
	
	/** 통신 상태 정보 */
	public static class State {
		public static final String COMMON_STATE_SUCCESS 		= "success";		
		public static final String COMMON_STATE_ERR 			= "error";			
	}
	
	/** JWT 토큰 정보 */
	public static class SysJwt {
		public static final String TOKEN_TYPE_CD_ACCESS = "AccessToken";
		public static final String TOKEN_TYPE_CD_REFRESH = "RefreshToken";
		public static final String HEADER_JWT = "X-AUTH-TOKEN";
		public static final String HEADER_JWT_REFRESH = "X-AUTH-RT";
		public static final String JWT_TYPE = "typ";
		public static final String JWT_TYPE_VALUE = "JWT";
		public static final String CREATE_AT = "createAt";
		public static final String ISSUE_AT = "issueAt";
		public static final String EXPIRE_AT = "expireAt";
	}	

	/** 날짜패턴 */
	public static class DatePatten {
		public static final String YMD_1 			= "yyyy-MM-dd";
		public static final String YMDH_1 			= "yyyy-MM-dd HH";
		public static final String YMDHM_1 			= "yyyy-MM-dd HH:mm";
		public static final String YMDHMS_1 		= "yyyy-MM-dd HH:mm:ss";

		public static final String YMD_2 			= "yyyyMMdd";
		public static final String YMDH_2 			= "yyyyMMddHH";
		public static final String YMDHM_2 			= "yyyyMMddHHmm";
		public static final String YMDHMS_2 		= "yyyyMMddHHmmss";
	}

	/** 날짜변경 */
	public static class DateChange {
		public static final String YEAR 			= "year";	// 년
		public static final String MONTH 			= "month";	// 월
		public static final String WEEK 			= "week";	// 주
		public static final String DAY 				= "day";	// 일
		public static final String HOUR 			= "hour";	// 시
		public static final String MIN 				= "min";	// 분
		public static final String SEC 				= "sec";	// 초
	}
	
}
