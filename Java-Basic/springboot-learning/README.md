# 🚀 스프링부트 학습 프로젝트

비전공자를 위한 스프링부트 종합 학습 프로젝트입니다. REST API 개발부터 데이터베이스 연동까지 실무에서 필요한 핵심 기능들을 단계별로 학습할 수 있습니다.

## 📋 프로젝트 개요

이 프로젝트는 스프링부트의 핵심 기능들을 학습하기 위한 예제 프로젝트입니다:

- **REST API 개발**: HTTP 메서드, JSON 응답, 에러 처리
- **데이터베이스 연동**: JPA, 엔티티, 리포지토리, 쿼리 메서드
- **비즈니스 로직**: 서비스 계층, 트랜잭션 관리
- **설정 관리**: 프로퍼티 파일, 의존성 주입

## 🏗️ 프로젝트 구조

```
springboot-learning/
├── pom.xml                                    # Maven 프로젝트 설정
├── src/main/
│   ├── java/com/example/springbootlearning/
│   │   ├── SpringbootLearningApplication.java # 메인 애플리케이션
│   │   ├── controller/                        # REST API 컨트롤러
│   │   │   ├── HelloController.java           # 기본 API 예제
│   │   │   └── UserController.java            # 사용자 관리 API
│   │   ├── entity/                            # JPA 엔티티
│   │   │   └── User.java                      # 사용자 엔티티
│   │   ├── repository/                        # 데이터 접근 계층
│   │   │   └── UserRepository.java            # 사용자 리포지토리
│   │   ├── service/                           # 비즈니스 로직 계층
│   │   │   └── UserService.java               # 사용자 서비스
│   │   └── config/                            # 설정 클래스
│   │       └── DatabaseInitializer.java       # 데이터베이스 초기화
│   └── resources/
│       └── application.properties              # 애플리케이션 설정
└── README.md                                  # 프로젝트 설명
```

## 🚀 실행 방법

### 1. 프로젝트 실행

```bash
# Maven으로 실행
mvn spring-boot:run

# 또는 IDE에서 SpringbootLearningApplication.java 실행
```

### 2. 애플리케이션 확인

- **애플리케이션**: http://localhost:8080
- **H2 데이터베이스 콘솔**: http://localhost:8080/h2-console
  - JDBC URL: `jdbc:h2:mem:testdb`
  - 사용자명: `sa`
  - 비밀번호: (비어있음)

## 🔗 API 엔드포인트

### Hello API (기본 예제)

| 메서드 | URL | 설명 |
|--------|-----|------|
| GET | `/api/hello` | 기본 인사 메시지 |
| GET | `/api/hello/personal?name=홍길동` | 개인화된 인사 |
| GET | `/api/hello/user/홍길동` | URL 경로 변수 사용 |
| GET | `/api/hello/info?name=김철수&age=25` | 상세 정보 JSON 응답 |
| GET | `/api/hello/time` | 현재 시간 정보 |
| GET | `/api/hello/calculate?a=10&b=5&operation=add` | 계산기 API |

### User API (CRUD 예제)

| 메서드 | URL | 설명 |
|--------|-----|------|
| GET | `/api/users` | 모든 사용자 조회 |
| GET | `/api/users/{id}` | ID로 사용자 조회 |
| GET | `/api/users/email/{email}` | 이메일로 사용자 조회 |
| POST | `/api/users` | 사용자 생성 |
| PUT | `/api/users/{id}` | 사용자 정보 수정 |
| DELETE | `/api/users/{id}` | 사용자 삭제 |

### User 검색 및 통계 API

| 메서드 | URL | 설명 |
|--------|-----|------|
| GET | `/api/users/search?name=검색어` | 이름으로 검색 |
| GET | `/api/users/search/age?minAge=20&maxAge=30` | 나이 범위로 검색 |
| GET | `/api/users/adults` | 성인 사용자 조회 |
| GET | `/api/users/age/{age}` | 특정 나이 이상 조회 |
| GET | `/api/users/domain/{domain}` | 이메일 도메인별 조회 |
| GET | `/api/users/with-phone` | 전화번호가 있는 사용자 |
| GET | `/api/users/sorted/age` | 나이순 정렬 |
| GET | `/api/users/sorted/name` | 이름순 정렬 (내림차순) |
| GET | `/api/users/statistics` | 나이대별 통계 |
| GET | `/api/users/statistics/domains` | 이메일 도메인별 통계 |
| GET | `/api/users/recent?days=7` | 최근 가입자 조회 |
| GET | `/api/users/count` | 전체 사용자 수 |
| GET | `/api/users/exists/email/{email}` | 이메일 존재 여부 |
| GET | `/api/users/{id}/summary` | 사용자 정보 요약 |

## 📊 샘플 데이터

애플리케이션 시작 시 자동으로 다음 샘플 데이터가 생성됩니다:

- **25명의 다양한 사용자** (20대~60대 이상)
- **다양한 이메일 도메인** (gmail.com, naver.com, yahoo.com 등)
- **전화번호가 있는/없는 사용자**
- **주소가 있는/없는 사용자**
- **최근 가입자들** (통계 테스트용)

## 🎯 학습 목표

### 1. REST API 개발
- ✅ HTTP 메서드 매핑 (`@GetMapping`, `@PostMapping`, `@PutMapping`, `@DeleteMapping`)
- ✅ URL 경로 변수 (`@PathVariable`)
- ✅ 쿼리 파라미터 (`@RequestParam`)
- ✅ 요청 본문 처리 (`@RequestBody`)
- ✅ JSON 응답 자동 변환
- ✅ HTTP 상태 코드 제어 (`ResponseEntity`)

### 2. 데이터베이스 연동
- ✅ JPA 엔티티 작성 (`@Entity`, `@Table`, `@Id`, `@GeneratedValue`)
- ✅ 컬럼 속성 설정 (`@Column`)
- ✅ 데이터 검증 (`@NotBlank`, `@Email`, `@Size`, `@Min`, `@Max`)
- ✅ 리포지토리 인터페이스 (`JpaRepository`)
- ✅ 쿼리 메서드 작성법
- ✅ 커스텀 쿼리 (`@Query`)

### 3. 비즈니스 로직
- ✅ 서비스 계층 설계 (`@Service`)
- ✅ 의존성 주입 (`@Autowired`)
- ✅ 트랜잭션 관리 (`@Transactional`)
- ✅ 예외 처리 및 에러 응답
- ✅ 데이터 검증 및 비즈니스 규칙

### 4. 프로젝트 설정
- ✅ Maven 프로젝트 구조 (`pom.xml`)
- ✅ 의존성 관리 (Spring Boot Starters)
- ✅ 애플리케이션 설정 (`application.properties`)
- ✅ 데이터베이스 설정 (H2 인메모리 DB)
- ✅ 개발 도구 설정 (DevTools)

## 🛠️ 기술 스택

- **Java 17**
- **Spring Boot 3.2.0**
- **Spring Data JPA**
- **H2 Database** (인메모리)
- **Maven**
- **Jakarta Validation**

## 📖 학습 가이드

### 단계별 학습 순서

1. **프로젝트 구조 이해**
   - `pom.xml` 파일 분석
   - `application.properties` 설정 이해
   - 패키지 구조 파악

2. **기본 API 개발**
   - `HelloController` 분석
   - HTTP 메서드 매핑 이해
   - JSON 응답 처리

3. **데이터베이스 연동**
   - `User` 엔티티 분석
   - `UserRepository` 인터페이스 이해
   - 쿼리 메서드 작성법

4. **비즈니스 로직 구현**
   - `UserService` 클래스 분석
   - 트랜잭션 관리 이해
   - 예외 처리 방법

5. **고급 기능**
   - 커스텀 쿼리 작성
   - 통계 API 구현
   - 데이터 초기화

### 실습 방법

1. **API 테스트**
   ```bash
   # 브라우저에서 직접 호출
   http://localhost:8080/api/users
   
   # Postman 또는 curl 사용
   curl -X GET http://localhost:8080/api/users
   ```

2. **데이터베이스 확인**
   - H2 콘솔에서 테이블 구조 확인
   - 샘플 데이터 조회
   - 쿼리 실행

3. **코드 수정 실험**
   - 새로운 API 엔드포인트 추가
   - 쿼리 메서드 추가
   - 비즈니스 로직 수정

## 🐛 문제 해결

### 자주 발생하는 문제들

1. **포트 충돌**
   ```
   Port 8080 was already in use
   ```
   - 해결: `application.properties`에서 `server.port=8081` 변경

2. **의존성 다운로드 실패**
   ```
   Failed to download dependencies
   ```
   - 해결: 인터넷 연결 확인, Maven 설정 확인

3. **H2 콘솔 접속 실패**
   ```
   H2 Console not accessible
   ```
   - 해결: `application.properties`에서 `spring.h2.console.enabled=true` 확인

4. **컴파일 오류**
   ```
   Java version mismatch
   ```
   - 해결: Java 17 이상 설치 확인

## 📚 추가 학습 자료

### 추천 도서
- "스프링 부트와 AWS로 혼자 구현하는 웹 서비스" - 이동욱
- "토비의 스프링" - 이일민

### 온라인 강의
- 인프런 스프링부트 강의
- 생활코딩 스프링부트 강의

### 공식 문서
- [Spring Boot Reference Guide](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/)
- [Spring Data JPA Documentation](https://docs.spring.io/spring-data/jpa/docs/current/reference/html/)

## 🎉 다음 단계

이 프로젝트를 완료한 후 다음을 학습해보세요:

1. **보안**: Spring Security로 인증/인가 구현
2. **테스트**: JUnit, MockMvc로 단위/통합 테스트
3. **배포**: Docker, AWS로 배포
4. **모니터링**: Actuator로 애플리케이션 모니터링
5. **캐싱**: Redis로 캐싱 구현

---

**Happy Learning! 🚀**

스프링부트의 강력한 기능들을 하나씩 익혀가며 실무 개발자로 성장해보세요!
