# 🚀 자바부터 스프링부트까지 학습 프로젝트

비전공자를 위한 자바 기초부터 스프링부트까지의 종합 학습 프로젝트입니다. 각 단계별로 상세한 주석과 설명이 포함되어 있어 체계적으로 학습할 수 있습니다.

## 📚 프로젝트 구조

```
📁 프로젝트 루트/
├── 📁 java-basics/                    # 자바 기초 학습
│   ├── 📁 01-variables/               # 변수와 데이터 타입
│   │   └── VariableExamples.java
│   ├── 📁 02-operators/               # 연산자
│   │   └── OperatorExamples.java
│   ├── 📁 03-control-flow/            # 제어문 (조건문, 반복문)
│   │   └── ControlFlowExamples.java
│   └── 📁 04-oop/                     # 객체지향 프로그래밍
│       ├── Person.java                # 기본 클래스 예제
│       ├── Student.java               # 상속 예제
│       └── OOPExample.java            # 객체지향 종합 예제
│
└── 📁 springboot-learning/            # 스프링부트 학습
    ├── pom.xml                        # Maven 프로젝트 설정
    ├── 📁 src/main/
    │   ├── 📁 java/com/example/springbootlearning/
    │   │   ├── SpringbootLearningApplication.java  # 메인 애플리케이션
    │   │   ├── 📁 controller/         # REST API 컨트롤러
    │   │   │   ├── HelloController.java
    │   │   │   └── UserController.java
    │   │   ├── 📁 entity/             # JPA 엔티티
    │   │   │   └── User.java
    │   │   ├── 📁 repository/          # 데이터 접근 계층
    │   │   │   └── UserRepository.java
    │   │   ├── 📁 service/             # 비즈니스 로직 계층
    │   │   │   └── UserService.java
    │   │   └── 📁 config/              # 설정 클래스
    │   │       └── DatabaseInitializer.java
    │   └── 📁 resources/
    │       └── application.properties  # 애플리케이션 설정
    └── README.md                      # 스프링부트 프로젝트 설명
```

## 🎯 학습 목표

### 1단계: 자바 기초 (java-basics)
- ✅ **변수와 데이터 타입**: 기본 자료형, 변수 선언, 상수
- ✅ **연산자**: 산술, 비교, 논리, 할당 연산자
- ✅ **제어문**: if문, switch문, for문, while문, break/continue
- ✅ **객체지향 프로그래밍**: 클래스, 객체, 상속, 캡슐화, 다형성

### 2단계: 스프링부트 (springboot-learning)
- ✅ **프로젝트 설정**: Maven, 의존성 관리, 설정 파일
- ✅ **REST API**: 컨트롤러, HTTP 메서드, JSON 응답
- ✅ **데이터베이스 연동**: JPA, 엔티티, 리포지토리
- ✅ **비즈니스 로직**: 서비스 계층, 트랜잭션 관리

## 🛠️ 개발 환경 설정

### 필수 요구사항
- **Java 17** 이상
- **Maven 3.6** 이상
- **IDE** (IntelliJ IDEA, Eclipse, VS Code 등)

### 설치 방법

1. **Java 설치 확인**
   ```bash
   java -version
   javac -version
   ```

2. **Maven 설치 확인**
   ```bash
   mvn -version
   ```

3. **프로젝트 클론 또는 다운로드**
   ```bash
   git clone [프로젝트-URL]
   cd java-springboot-learning
   ```

## 🚀 실행 방법

### 자바 기초 예제 실행

1. **변수 예제 실행**
   ```bash
   cd java-basics/01-variables
   javac VariableExamples.java
   java VariableExamples
   ```

2. **연산자 예제 실행**
   ```bash
   cd java-basics/02-operators
   javac OperatorExamples.java
   java OperatorExamples
   ```

3. **제어문 예제 실행**
   ```bash
   cd java-basics/03-control-flow
   javac ControlFlowExamples.java
   java ControlFlowExamples
   ```

4. **객체지향 예제 실행**
   ```bash
   cd java-basics/04-oop
   javac *.java
   java OOPExample
   ```

### 스프링부트 애플리케이션 실행

1. **프로젝트 디렉토리로 이동**
   ```bash
   cd springboot-learning
   ```

2. **Maven으로 애플리케이션 실행**
   ```bash
   mvn spring-boot:run
   ```

3. **또는 IDE에서 SpringbootLearningApplication.java 실행**

4. **브라우저에서 확인**
   - 애플리케이션: http://localhost:8080
   - H2 데이터베이스 콘솔: http://localhost:8080/h2-console

## 📖 학습 가이드

### 자바 기초 학습 순서

1. **변수와 데이터 타입** (`01-variables/`)
   - 기본 자료형 이해
   - 변수 선언과 초기화
   - 상수 사용법

2. **연산자** (`02-operators/`)
   - 산술 연산자
   - 비교 연산자
   - 논리 연산자
   - 증감 연산자

3. **제어문** (`03-control-flow/`)
   - 조건문 (if, switch)
   - 반복문 (for, while, do-while)
   - break, continue 사용법

4. **객체지향 프로그래밍** (`04-oop/`)
   - 클래스와 객체
   - 생성자와 메서드
   - 상속과 다형성
   - 캡슐화

### 스프링부트 학습 순서

1. **프로젝트 구조 이해**
   - Maven 프로젝트 구조
   - 의존성 관리 (pom.xml)
   - 설정 파일 (application.properties)

2. **REST API 개발**
   - 컨트롤러 작성법
   - HTTP 메서드 매핑
   - JSON 응답 처리

3. **데이터베이스 연동**
   - JPA 엔티티 작성
   - 리포지토리 인터페이스
   - 쿼리 메서드

4. **비즈니스 로직 구현**
   - 서비스 계층 설계
   - 트랜잭션 관리
   - 예외 처리

## 🔗 주요 API 엔드포인트

### Hello API
- `GET /api/hello` - 기본 인사
- `GET /api/hello/personal?name=홍길동` - 개인화된 인사
- `GET /api/hello/user/홍길동` - URL 경로 변수 사용
- `GET /api/hello/info?name=김철수&age=25` - 상세 정보
- `GET /api/hello/time` - 현재 시간
- `GET /api/hello/calculate?a=10&b=5&operation=add` - 계산기

### User API
- `GET /api/users` - 모든 사용자 조회
- `GET /api/users/{id}` - ID로 사용자 조회
- `POST /api/users` - 사용자 생성
- `PUT /api/users/{id}` - 사용자 정보 수정
- `DELETE /api/users/{id}` - 사용자 삭제
- `GET /api/users/search?name=검색어` - 이름으로 검색
- `GET /api/users/adults` - 성인 사용자 조회
- `GET /api/users/statistics` - 사용자 통계

## 🗄️ 데이터베이스 정보

- **데이터베이스**: H2 인메모리 데이터베이스
- **콘솔 URL**: http://localhost:8080/h2-console
- **JDBC URL**: `jdbc:h2:mem:testdb`
- **사용자명**: `sa`
- **비밀번호**: (비어있음)

## 📝 학습 팁

### 자바 기초 학습 시
1. **코드를 직접 타이핑**해보세요
2. **주석을 꼼꼼히 읽어보세요**
3. **변수명과 메서드명의 의미**를 이해하세요
4. **각 예제를 실행**하고 결과를 확인하세요
5. **코드를 수정**해보며 실험해보세요

### 스프링부트 학습 시
1. **API를 직접 호출**해보세요 (Postman, 브라우저 등)
2. **데이터베이스 콘솔**에서 데이터를 확인하세요
3. **로그 메시지**를 주의깊게 읽어보세요
4. **에러가 발생**하면 에러 메시지를 분석하세요
5. **코드 구조**를 이해하고 따라해보세요

## 🐛 문제 해결

### 자주 발생하는 문제들

1. **컴파일 오류**
   - Java 버전 확인
   - 클래스패스 설정 확인
   - 문법 오류 확인

2. **스프링부트 실행 오류**
   - 포트 충돌 (8080 포트 사용 중)
   - 의존성 다운로드 실패
   - 설정 파일 오류

3. **데이터베이스 연결 오류**
   - H2 콘솔 접속 실패
   - JDBC URL 확인
   - 테이블 생성 오류

## 📚 추가 학습 자료

### 추천 도서
- "이것이 자바다" - 신용권
- "스프링 부트와 AWS로 혼자 구현하는 웹 서비스" - 이동욱

### 온라인 강의
- 생활코딩 Java 입문
- 인프런 스프링부트 강의

### 공식 문서
- [Oracle Java Documentation](https://docs.oracle.com/en/java/)
- [Spring Boot Reference Guide](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/)

## 🤝 기여하기

이 프로젝트는 학습용 프로젝트입니다. 개선사항이나 추가 예제가 있다면 언제든 제안해주세요!

## 📄 라이선스

이 프로젝트는 교육 목적으로 자유롭게 사용할 수 있습니다.

---

**Happy Coding! 🎉**

자바와 스프링부트의 세계에 오신 것을 환영합니다. 차근차근 학습하시면 분명 멋진 개발자가 되실 수 있습니다!
