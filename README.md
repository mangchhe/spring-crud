# Spring CRUD

## 실행 방법

### 데이터베이스

```sql
// url : jdbc:mysql://localhost:3306/test
// id : root
// pw : 1234

create database test;
```

### 프로젝트 Build & Run

```bash
git clone https://github.com/mangchhe/spring-crud.git
./gradlew bootRun
or
./gradlew build
java -jar ./build/libs/spring-crud-0.0.1-SNAPSHOT.jar
```

## Swagger

- http://localhost:8080/swagger-ui/index.html

## 개발 환경

- Java 11
- Spring Boot 2.6.4
- Junit5
- Spring Boot JPA
- Swagger
- Mysql 8.0.27

## 기능 명세

- 회원가입(CREATE)
- 전체 유저 조회(READ)
- 프로필 수정(UPDATE)
- 회원탈퇴(DELETE)

## Entity

![entity](https://user-images.githubusercontent.com/50051656/159151342-a7460546-68ef-43bc-918e-17e4c1226904.png)