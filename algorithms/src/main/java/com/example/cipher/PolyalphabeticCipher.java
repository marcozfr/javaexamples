package com.example.cipher;

public class PolyalphabeticCipher implements CipherAlgorithm {
	
	public static void main(String[] args) {
		
		String secretKey = args[2];
		String text = args[1];
		
		PolyalphabeticCipher cipher = new PolyalphabeticCipher();
		if("encrypt".equals(args[0])){
			System.out.println(cipher.encrypt(text, secretKey));
		}if("decrypt".equals(args[0])){
			System.out.println(cipher.decrypt(text, secretKey));
		}
		
		
	}

	public char[] doEncrypt(String text, String secretKey, boolean enc) {
		char[] chars = text.toCharArray();
		char[] key = secretKey.toCharArray();
		
		int i =0; int j = 0; int top = key.length;
		while(i < chars.length){
			while(j < top){
				int ck = key[j];
				int cc = chars[i];
				if(enc){
					cc += ck;
				}else{
					cc -= ck;
				}
				chars[i] = (char)cc;
				i++;
				j++;
			}
			int diff = chars.length - i;
			top = (diff >= key.length) ? key.length : diff;
			j=0;
		}
		return chars;
	}

	public char[] decrypt(String text, String secretKey) {
		return doEncrypt(text, secretKey, false);
	}

	public char[] encrypt(String text, String secretKey) {
		return doEncrypt(text, secretKey, true);
	}

	

}
