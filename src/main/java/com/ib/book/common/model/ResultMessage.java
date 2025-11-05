package com.ib.book.common.model;

import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

/***************************************************
* Copyright(c) 2022-2023 IHNCOM All right reserved.
* 
* Project  : ihncom_sys_api
* Package  : com.ib.book.common.model
* Filename : ResultMessage.java
* Description : 
* Writer : ljh  
* Date : 2025. 11. 05.
*
* Revision History
* Writer             Date       Description
* ------------------ ---------- -----------------------
* ljh             2022. 11. 16.
*
****************************************************/
@Component
@Configuration
@PropertySource(value="classpath:messages.properties", encoding="UTF-8")
@ConfigurationProperties(prefix = "result-message")
@Validated
@Getter
@Setter
@ToString
@Slf4j
public class ResultMessage extends CommonMessage {
	
	/** 결과메세지 */
    private Map<String, String> messages;
    
        /**************************************************************
     * 파라미터로 넘어온 argument 를 message 에 대입, 변경된 메세지 리턴
     *
     * @return String 결과메세지
     **************************************************************/
    @Override
	public String getArgumentsMessage(String key, String[] args) {
        super.setMessages(this.messages);
        log.debug("msg key="+key);
        return  super.getArgumentsMessage(key, args);
    }

}
