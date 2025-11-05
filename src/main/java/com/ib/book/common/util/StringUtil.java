package com.ib.book.common.util;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import lombok.extern.slf4j.Slf4j;

/***************************************************
* 
* Project  : ib_book_api
* Package  : com.ib.book.common.util
* Filename : StringUtil.java
* Description : 자바 공통 유틸
* Writer : ljh  
* Date : 2025. 11. 05.
*
* Revision History
* Writer             Date       Description
* ------------------ ---------- -----------------------
* ljh             2025. 11. 05.
*
****************************************************/
@Slf4j
public class StringUtil {

	/*****************************************************
	 * 날짜 형식 변환 (20200616 => 2020.06.16)
	 * @param value 날짜 데이타
	 * @return String 반환 된 문자
	 *****************************************************/
	public static String setConvertDate(String value) {
		return setConvertDate(value, ".");
	}

	/*****************************************************
	 * 날짜 형식 변환
	 * @param value 날짜 데이타
	 * @param delimiter 날짜 변환 구분자
	 * @return String 반환 된 문자
	 *****************************************************/
	public static String setConvertDate(String value, String delimiter) {
		if(value.length() < 8) {
			return  value ;
		}

		// 변환 날짜 데이타
		String strRetValue = "";
		// 날짜 데이타 문자배열로 변환
		char [] arrCDate = value.toCharArray();

		// 합칠 날짜 데이타 변수
		StringBuilder sb = new StringBuilder(strRetValue);

		for(int count = 0; count < 8; count++) {
			sb.append(arrCDate[count]);

			if(count == 3 || count == 5) {
				sb.append(delimiter);
			}
		}

		strRetValue = sb.toString();

		return strRetValue;
	}

	/*****************************************************
	 * 날짜 형식 변환 (2019.08.22 => 20190822)
	 * @param value 날짜 데이타
	 * @return String 반환 된 문자
	 *****************************************************/
	public static String reConvertDate(String value) {
		// 날짜 데이타
		String chgValue = value;
		chgValue = chgValue.replace(".", "");

		return chgValue;
	}

	/*****************************************************
	 * 문자열 합치기
	 * @param strings 문자배열
	 * @param delimiter 문자구분자
	 * @return String 반환 된 문자
	 *****************************************************/
	public static String join(String[] strings, String delimiter) {
		// 합칠 문자 데이타 변수
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < strings.length - 1; i++) {
			sb.append(strings[i]).append(delimiter);
		}

		sb.append(strings[strings.length - 1]);

		return sb.toString();
	}

	/*****************************************************
	 * 문자배열에 해당 문자가 존재하는지 체크
	 * @param str 체크문자
	 * @param array 문자배열
	 * @return boolean true/false
	 *****************************************************/
	public static boolean contains(String str, String[] array) {
		if (str == null) {
			return false;
		}

		// 문자배열 안의 문자수만큼 비교
		for (int i = 0; i < array.length; i++) {
			if (str.equals(array[i])) {
				return true;
			}
		}

		return false;
	}

	/*****************************************************
	 * 문자 데이타 값 존재 여부 체크
	 * @param sData 체크문자
	 * @return boolean true/false
	 *****************************************************/
	public static boolean isBlank(String sData) {
		return (sData == null || sData.length() == 0);
	}

	/*****************************************************
	 * 전송 데이타 Cross Site Script 방지
	 * @param strData 체크 할 문자
	 * @return String 반환 된 문자
	 *****************************************************/
	public static String removeXSS(String strData) {
		// 체크 할 문자배열
		String[] arrSrcCode = {"<", ">", "\"", "\'", "%00", "%"};
		// 체크 할 Tag 문자배열
		String[] arrTgtCode = {"&lt;", "&gt;", "&#34;", "&#39;", "null;", "&#37;"};

		if ( strData == null || "".equals(strData) ) {
			return "";
		}

		for (int nLoop=0; nLoop < arrSrcCode.length; nLoop++) {
			strData = strData.replaceAll(arrSrcCode[nLoop], arrTgtCode[nLoop]);
		}

		return strData;
	}

	/*****************************************************
	 * 쿼리단 Cross Site Script 방지
	 * @param strData 체크 할 문자
	 * @return String 반환 된 문자
	 *****************************************************/
	public static String removeQueryXSS(String strData) {
		// 체크 할 문자배열
		String[] arrSrcCode = {"<", ">", "\"", "\'", "%00", "%", ";", "-"};
		// 체크 할 Tag 문자배열
		String[] arrTgtCode = {"&lt;", "&gt;", "&#34;", "&#39;", "null;", "&#37;", "&#59;", "&#45;"};

		if ( strData == null || "".equals(strData) ) {
			return strData;
		}

		for (int nLoop=0; nLoop < arrSrcCode.length; nLoop++) {
			strData = strData.replaceAll(arrSrcCode[nLoop], arrTgtCode[nLoop]);
		}

		return strData;
	}

	/*****************************************************
	 * 입력된 데이타 토크나이징 처리 후 토크나이징된 토큰들을 문자배열로 반환
	 * @param pmString 토크나이징되는 문자
	 * @param pmDelimeter 문자열를 분리하는 문자
	 * @return String 반환 된 문자배열
	 *****************************************************/
	public static String[] getTokens(String pmString, String pmDelimeter) {
		//토크나이징되는 문자
		String pmsDelimeter = pmDelimeter;
		// 문자열를 분리하는 문자
		String[] lmsReturns = null;

		if (pmString != null) {
			if( "\\".equals(pmsDelimeter) ) {
				pmsDelimeter = "/";
			}

			StringTokenizer lmoTokenizer = new StringTokenizer(pmString, pmsDelimeter);
			lmsReturns = new String[lmoTokenizer.countTokens()];

			for (int i = 0; lmoTokenizer.hasMoreTokens(); i++) {
				lmsReturns[i] = lmoTokenizer.nextToken();
			}
		}
		return lmsReturns;
	}

	/*****************************************************
	 * 문자열을 정의한 Byte로 잘라 끝을 ...으로 표현
	 * @param str 변환 시킬 문자
	 * @param putByteLength 문자열 자를 Byte
	 * @param delimiter 문자 구분자
	 * @return String 반환 된 문자
	 *****************************************************/
	public static String getStringByteCut(String str, int putByteLength, String delimiter){
		// 표현문자 길이
		int strLength = 0;

		// 비교할 문자배열
		char[] tempChar = new char[str.length()];
		// 합칠 문자 데이타 변수
		StringBuilder stb = new StringBuilder();

		for (int i = 0; i < tempChar.length; i++) {
			tempChar[i] = str.charAt(i);
			if (tempChar[i] < 128) {
				strLength++;
			} else {
				strLength += 2;
			}

			stb.append(tempChar[i]);

			if( strLength > putByteLength ) {
				stb.append(delimiter);
				break;
			}
		}

		return stb.toString();
	}

	/*****************************************************
	 * 자릿수에 0 채워주기
	 * @param n 변환 시킬 숫자
	 * @param cipher 자릿수
	 * @return String 반환 된 숫자
	 *****************************************************/
	public static String addZero(int n, int cipher) {
		// 숫자 길이
		String num = String.valueOf(n);
		// 합칠 문자 데이타 변수
		StringBuilder str = new StringBuilder();

		for ( int i = 0 ; i < cipher - num.length(); i++ ) {
			str.append("0");
		}

		return str.append(num).toString();
	}

	/*****************************************************
	 * 이메일 유효성 체크
	 * @param n 체크 할 이메일주소
	 * @return boolean true/false
	 *****************************************************/
	public static boolean isValidEmail(String email) {
		// 유효성 체크 여부
		boolean err = false;
		// 유효성 패턴
		Pattern p = Pattern.compile( "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" + "\\@" + "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" + "(" + "\\." + "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" + ")+" );
		// 유효성 패턴 체크 여부
		Matcher m = p.matcher(email);

		if( !m.matches() ) {
			err = true;
		}

		return err;
	}

	/*****************************************************
	 * 문자 null 체크 후 null인 경우 공백 문자로 변환
	 * @param oData null 체크 할 object
	 * @return String 반환 된 문자
	 *****************************************************/
	public static String nvl(Object oData) {
		return nvl(oData, "");
	}

	/*****************************************************
	 * 문자 null 체크 후 null인 경우 대체 숫자로 변환
	 * @param oData null 체크 할 object
	 * @param sTrans 대체 숫자
	 * @return String 반환 된 문자
	 *****************************************************/
	public static String nvl(Object oData, int sTrans) {
		return nvl(oData, Integer.toString(sTrans));
	}

	/*****************************************************
	 * 문자 null 체크 후 null인 경우 대체 문자로 변환
	 * @param oData null 체크 할 object
	 * @param sTrans 대체 문자
	 * @return String 반환 된 문자
	 *****************************************************/
	public static String nvl(Object oData, String sTrans) {
		if (sTrans == null) {
			sTrans = "";
		}

		if (oData != null && !"".equals(oData) && !"null".equals(oData)) {
			return removeXSS(oData.toString().trim());
		}

		return removeXSS(sTrans);
	}

	/*****************************************************
	 * 숫자의 왼쪽 자리를 '0'으로 추가
	 * @param sbRtn 변환 시킬 숫자
	 * @param sbRtn 추가 시킬 수
	 * @return String 반환 된 문자
	 *****************************************************/
	public static String padLeftwithZero(int convert, int size) {
		// 합칠 문자 데이타 변수
		StringBuilder sbRtn = new StringBuilder();
		// 숫자 Integer형으로 변환 변수
		Integer inTemp  = Integer.valueOf(convert);
		// Integer 문자열 변환 변수
		String  stTemp;

		stTemp = inTemp.toString();

		if (stTemp.length() < size) {
			for (int i = 0; i < size - stTemp.length(); i++) {
				sbRtn.append("0");
			}
		}

		sbRtn.append(stTemp);

		return sbRtn.toString();
	}

	/*****************************************************
	 * 왼쪽에  0이 붙은 문자를 제거
	 * @param sbRtn 변환 시킬 문자
	 * @return String 반환 된 문자
	 *****************************************************/
	public static String removeLeftZero(String sbRtn) {
		return sbRtn.replaceFirst("^0+(?!$)", "");
	}

	/**
	 * Method Summary. <br>
	 * @param sData String : 데이터 값
	 * @param sTrans String : null, "", "null"일 경우 변경할값
	 * @return String
	 */
	public static int nvlInt(Object objData, int nTrans) {
		return Integer.parseInt(nvl(objData, nTrans));
	}

	/*****************************************************
	 * US7ASCII로 인코딩된 문자열을 한글로 변환하여 반환
	 * @param value US7ASCII로 인코딩된 문자열
	 * @return String 한글로 변환된 문자열
	 *****************************************************/
	public static String encodeKoreanFromUs7ascii(String value) {
		if(value == null) {
			return "";
		}

		String str = "";

		try {
			str = new String(value.getBytes(StandardCharsets.ISO_8859_1) ,"KSC5601");
		} catch (UnsupportedEncodingException e) {
			log.error(e.getMessage());
		}

		return str;
	}
	
    /**
     * 이메일 포맷 Validator
     * @param str
     * @return isValidEmailFormat
     */
    public static boolean isEmail(final String str) {
 	   String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
       return isValid(EMAIL_PATTERN, str);
    }

    /**
    * 문자열이 정규식에 맞는 포맷인지 체크
    * @param regex
    * @param target
    * @return isValid
    */
    public static boolean isValid(final String regex, final String target) {
      Matcher matcher = Pattern.compile(regex).matcher(target);
      return matcher.matches();
    }
    
    /**
    * 이메일 주소 마스킹 처리
    * @param email
    * @return maskedEmailAddress
    */
    public static String getMaskedEmail(String email) {
      String regex = "\\b(\\S+)+@(\\S+.\\S+)";
      Matcher matcher = Pattern.compile(regex).matcher(email);
      if (matcher.find()) {
         return email.replaceAll("\\b(\\S+)[^@][^@]+@(\\S+)", "$1**@$2");
      }
      return email;
    }
    
    /**
     * String이 Json타입인지를 확인하는 함수.
     * @param jsonString
     * @return boolean
     */
    public static boolean isJSONValid(String jsonString) {
        // 문자열의 앞뒤 공백을 제거
        jsonString = jsonString.trim();

        // 문자열이 JSON 객체 또는 배열 형식으로 시작 및 종료되는지 검사
        boolean isObject = jsonString.startsWith("{") && jsonString.endsWith("}");
        boolean isArray = jsonString.startsWith("[") && jsonString.endsWith("]");

        if (!isObject && !isArray) {
            // 문자열이 JSON 객체 또는 배열 형식이 아니면 바로 false 반환
            return false;
        }

        try {
            if (isObject) {
                new JSONObject(jsonString);
            } else {
                new JSONArray(jsonString);
            }
        } catch (JSONException ex) {
            // JSON 파싱 중 오류가 발생하면 false 반환
            return false;
        }

        // 위의 모든 검사를 통과하면 문자열은 유효한 JSON 형식
        return true;
    }

}
