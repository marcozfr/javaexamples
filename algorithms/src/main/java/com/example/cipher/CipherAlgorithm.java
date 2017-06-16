package com.example.cipher;

public interface CipherAlgorithm {
	
	char[] encrypt(String text, String secretKey);
	
	char[] decrypt(String text, String secretKey);

}
