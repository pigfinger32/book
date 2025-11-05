package com.ib.book.config;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

import org.jasypt.encryption.StringEncryptor;
import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;

import lombok.extern.slf4j.Slf4j;

@Configuration
@EnableEncryptableProperties
@Slf4j
public class JasyptConfig {
  @Value("${jasypt.encryptor.algorithm}")
  private String algorithm;
  @Value("${jasypt.encryptor.pool-size}")
  private int poolSize;
  @Value("${jasypt.encryptor.string-output-type}")
  private String stringOutputType;
  @Value("${jasypt.encryptor.key-obtention-iterations}")
  private int keyObtentionIterations;

  @Bean
  public StringEncryptor jasyptStringEncryptor() {
    PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
    encryptor.setPoolSize(poolSize);
    encryptor.setAlgorithm(algorithm);
    encryptor.setPassword(getJasyptEncryptorPassword()); 
    encryptor.setStringOutputType(stringOutputType);
    encryptor.setKeyObtentionIterations(keyObtentionIterations);
        
//	String source = "password";//실제 비밀번호 입력
//	String dec = encryptor.encrypt(source);	
//	
//	System.out.println("Plain Text to Encrypt: " + source);
//    System.out.println("Encrypted Text (copy this to application.yml): " + encryptor.encrypt(source));
//    System.out.println("Decrypted Text (for verification): " + encryptor.decrypt(dec)); // 암호화가 제대로 되는지 확인용
    
	
    return encryptor;
  }

  private String getJasyptEncryptorPassword() {
    try {
      ClassPathResource resource = new ClassPathResource("env.yml");
      return Files.readAllLines(Paths.get(resource.getURI())).stream()
          .collect(Collectors.joining(""));
    } catch (IOException e) {
      throw new RuntimeException("Not found Jasypt password file.");
    }
  }
}