### 효율적으로 코드를 보기 위해 선행해야 하는 것

1. 컴퓨터 환경을 Java 17 버전으로 설정합니다.
2. Intellij로 해당 프로젝트를 켭니다.
3. Gradle JVM을 클릭한 뒤 Java 17로 사진과 같이 설정해 줍니다.
   ![](https://i.imgur.com/qsB4d6I.png)
4. build.gradle 로 이동하여 해당 버튼을 클릭하여, 프로젝트에 필요한 의존성을 다운로드합니다. (이미 다운로드 되셨다면 넘어가 주세요.
   ![](https://i.imgur.com/WDe7eZl.png)

---
### 애플리케이션 실행 방법

모든 작업은 Docker가 켜져 있어야 가능한 행위입니다.

1. 다음 명령어를 쳐주어 Docker Image를 생성합니다.
```shell
docker build -t sakak .
```
2. 이미지가 생성되었다면 실행시켜 줍니다.
```shell
docker run -p 8080:8080 sakak - 포그라운드로 실행
docker run -d -p 8080:8080 sakak - 백그라운드로 실행
```

--- 

# 신경 쓴 부분
### 코드

- 3 Layered Architecture를 사용했습니다.
- 패키지 간 양방향 의존성이 발생하지 않도록 직접 참조가 아닌, 간접 참조를 선택하고, Service Package에 DTO를 위치시켰습니다.
  ![](https://i.imgur.com/azUj04l.png)
- 테스트 케이스를 최대한 많이 구성하여, 정확한 로직을 작성할 수 있도록 하였습니다.
- VO를 적극 활용하여 잘못된 값이 최대한 입력되지 않도록 하고, 예외 사항에 대해 각각 유연하게 처리할 수 있는 기반을 마련하였습니다.
- GlobalExceptionHandler를 통해 예외를 효율적으로 처리하였습니다.

### 데이터베이스

- H2 Database를 사용하였습니다.
- 하나의 식품에 대해 여러 번 영양소를 조사하는 것을 고려하여 Food(음식), Nutrient(영양소)로 테이블을 나누었습니다.

### 이외의 부분

- Python을 통해 보내주신 Excel 파일의 데이터를 쿼리로 변경하였습니다. (보내주신 모든 데이터가 data.sql에 들어있습니다.)
