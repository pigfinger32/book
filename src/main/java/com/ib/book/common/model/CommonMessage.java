package com.ib.book.common.model;

import java.util.Map;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/***************************************************
* Copyright(c) 2022-2023 IHNCOM All right reserved.
* 
* Project  : ihncom_sys_api
* Package  : com.ihncom.sys.common.model
* Filename : CommonMessage.java
* Description : Message 관리 결과, 오류 메세지 객체 공통 정보 객체
* Writer : ljh  
* Date : 2025. 11. 05.
*
* Revision History
* Writer             Date       Description
* ------------------ ---------- -----------------------
* ljh             2025. 11. 05.
*
****************************************************/
@Setter
@Slf4j
public class CommonMessage {
	
	/** 메세지 */
    private Map<String, String> messages;

    /**************************************************************
     * 파라미터로 넘어온 argument 를 message 에 대입, 변경된 메세지 리턴
     *
     * @return String 메세지
     **************************************************************/
    public String getArgumentsMessage(String key, String[] args) {
    	
        args = Optional.ofNullable(args).orElse(new String[] {});
        
        Pattern pattern = Pattern.compile("/[^a-z|A-Z|0-9|ㄱ-ㅎ|가-힣]/g"); 
        
        Matcher matcher = pattern.matcher(key);
                
        StringBuilder stringBuilder = new StringBuilder();
        int startIndex = 0;

        while (matcher.find()) {
            stringBuilder.append(this.messages.get(key), startIndex, matcher.start());
                        
            try {
                stringBuilder.append(args[Integer.parseInt(matcher.group().substring(1,matcher.group().length()-1))]);                                
            } catch (Exception e) {
                stringBuilder.append(matcher.group());
            }

            startIndex = matcher.end();
            
        }

        if (stringBuilder.length() > 0) {
            stringBuilder.append(this.messages.get(key).substring(startIndex));
        } else {
            stringBuilder.append(this.messages.get(key));
        }
        
        return stringBuilder.toString();
    }

}
