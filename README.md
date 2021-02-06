# I18nMessageFileGenerator


## 소개
시스템에 i18n을 적용하려면 다양한 언어의 메시지파일이 필요합니다 ex) ko.properties, en.properties, ja.properties or ko.json ...

보통 조직에 전문 번역가가 없으면 보통 구* 번역 등으로 손수 메시지 파일을 만드는데요,,

이때 번역할 부분이 많으면 상당한 시간이 걸립니다 (보통 300개의 주제를 6개 국가언어로 손수 작업하면 6시간정도 걸림)

저도 이 때문에 국제화가 필요한 프로젝트에서 상당히 고생을 했었습니다.

이런 이유로,,, 자동으로 번역하는 툴이 있으면 좋을것같다고 생각하고 만들었습니다


## 효과

하나의 원본언어 메시지파일로 여러 국가언어의 메시지파일을 만들 수 있음


## 실행환경
### 운영체제 
[Ubuntu](https://ubuntu.com/)
### 필요 프로그램 
[crow-translate](https://crow-translate.github.io/)

[open-jdk-11](https://github.com/ojdkbuild/ojdkbuild)


## 사용
1. 프로젝트 빌드(gradle)
2. ./build/lib 에 있는 ~-all.jar 가 있는 곳으로 이동
3. 현재 디렉토리에 원본파일 ko.properties 위치
4. java -jar ~-all.jar \<srcFileName> \<srcLanguage> \<desLanguage> bing

srcFileName에는 파일의 확장명까지 적으면 됩니다.
  
Language 두부분에는 korean, english 처럼 입력하시면 됩니다.


## 계획
* 유저인터페이스
* 실행파일
