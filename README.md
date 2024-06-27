### Jasypt 암호화
* PBEWithMD5AndDES : MD5, DES를 이용한 암호화
* PBEWithSHA256And128BitAES-CBC-BC : SHA256, AES128를 이용한 암호화
  * '-BC'로 끝나는 알고리즘은 Bouncy Castle JCE Provider에서 제공하는 알고리즘이다.


### MessageDigest 암호화
* 해당 클래스는 Java에서 단방향 해시 함수를 구할 때 사용함.


### Local setting
* VM Option 을 추가할 것. (-Djasypt.encryptor.password='yourPassword')


### 개발환경
* JDK : Azul zulu 17
* Spring boot 3.2.7
* Intellij 2023.1.3 (Ultimate Edition)
* Mac m1 pro


### 레퍼런스
* [property 암/복호화를 위한 Jasypt 적용기 -1-](https://velog.io/@ssol_916/Jasypt으로-properties-암호화)
* [Jasypt 암복호화 하기](https://luvstudy.tistory.com/67#article-4--%EC%95%94%ED%98%B8%ED%99%94-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EC%84%A0%ED%83%9D)
* [MessageDigest 클래스 - 단방향 암호화 기능 제공](https://sharonprogress.tistory.com/151)