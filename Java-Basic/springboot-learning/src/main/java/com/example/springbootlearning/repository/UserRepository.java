package com.example.springbootlearning.repository;

import com.example.springbootlearning.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * 사용자 데이터 접근 리포지토리 인터페이스
 * 
 * 이 인터페이스는 JPA Repository를 상속받아 데이터베이스 CRUD 작업을 수행합니다.
 * @Repository: 데이터 접근 계층의 컴포넌트임을 나타냄
 * JpaRepository<User, Long>: User 엔티티와 Long 타입의 ID를 사용하는 리포지토리
 * 
 * 주요 학습 내용:
 * 1. JPA Repository 기본 기능
 * 2. 쿼리 메서드 (Query Methods) 작성법
 * 3. @Query 어노테이션을 사용한 커스텀 쿼리
 * 4. Optional을 사용한 null 안전 처리
 */
@Repository  // 데이터 접근 계층의 컴포넌트임을 나타냄
public interface UserRepository extends JpaRepository<User, Long> {
    
    /**
     * 이메일로 사용자 찾기
     * 
     * JPA가 메서드 이름을 분석하여 자동으로 쿼리를 생성합니다.
     * "findBy" + 필드명 + 조건 = SELECT * FROM users WHERE email = ?
     * 
     * @param email 검색할 이메일
     * @return 사용자 정보 (Optional로 null 안전 처리)
     */
    Optional<User> findByEmail(String email);
    
    /**
     * 이름으로 사용자 찾기 (부분 일치)
     * 
     * 메서드 이름: findBy + 필드명 + Containing
     * 생성되는 쿼리: SELECT * FROM users WHERE name LIKE %?%
     * 
     * @param name 검색할 이름 (부분 일치)
     * @return 사용자 목록
     */
    List<User> findByNameContaining(String name);
    
    /**
     * 나이 범위로 사용자 찾기
     * 
     * 메서드 이름: findBy + 필드명 + Between
     * 생성되는 쿼리: SELECT * FROM users WHERE age BETWEEN ? AND ?
     * 
     * @param minAge 최소 나이
     * @param maxAge 최대 나이
     * @return 사용자 목록
     */
    List<User> findByAgeBetween(Integer minAge, Integer maxAge);
    
    /**
     * 특정 나이 이상의 사용자 찾기
     * 
     * 메서드 이름: findBy + 필드명 + GreaterThanEqual
     * 생성되는 쿼리: SELECT * FROM users WHERE age >= ?
     * 
     * @param age 최소 나이
     * @return 사용자 목록
     */
    List<User> findByAgeGreaterThanEqual(Integer age);
    
    /**
     * 이메일이 특정 도메인인 사용자 찾기
     * 
     * 메서드 이름: findBy + 필드명 + EndingWith
     * 생성되는 쿼리: SELECT * FROM users WHERE email LIKE %?
     * 
     * @param domain 이메일 도메인 (예: "@gmail.com")
     * @return 사용자 목록
     */
    List<User> findByEmailEndingWith(String domain);
    
    /**
     * 전화번호가 있는 사용자 찾기
     * 
     * 메서드 이름: findBy + 필드명 + IsNotNull
     * 생성되는 쿼리: SELECT * FROM users WHERE phone_number IS NOT NULL
     * 
     * @return 사용자 목록
     */
    List<User> findByPhoneNumberIsNotNull();
    
    /**
     * 이름과 나이로 사용자 찾기
     * 
     * 메서드 이름: findBy + 필드명1 + And + 필드명2
     * 생성되는 쿼리: SELECT * FROM users WHERE name = ? AND age = ?
     * 
     * @param name 사용자 이름
     * @param age 사용자 나이
     * @return 사용자 목록
     */
    List<User> findByNameAndAge(String name, Integer age);
    
    /**
     * 이름 또는 이메일로 사용자 찾기
     * 
     * 메서드 이름: findBy + 필드명1 + Or + 필드명2
     * 생성되는 쿼리: SELECT * FROM users WHERE name = ? OR email = ?
     * 
     * @param name 사용자 이름
     * @param email 사용자 이메일
     * @return 사용자 목록
     */
    List<User> findByNameOrEmail(String name, String email);
    
    /**
     * 사용자 수 세기 (이름으로)
     * 
     * 메서드 이름: countBy + 필드명
     * 생성되는 쿼리: SELECT COUNT(*) FROM users WHERE name = ?
     * 
     * @param name 사용자 이름
     * @return 사용자 수
     */
    long countByName(String name);
    
    /**
     * 이메일 존재 여부 확인
     * 
     * 메서드 이름: existsBy + 필드명
     * 생성되는 쿼리: SELECT COUNT(*) > 0 FROM users WHERE email = ?
     * 
     * @param email 확인할 이메일
     * @return 존재하면 true, 없으면 false
     */
    boolean existsByEmail(String email);
    
    /**
     * 나이순으로 정렬된 사용자 목록
     * 
     * 메서드 이름: findBy + OrderBy + 필드명 + Asc/Desc
     * 생성되는 쿼리: SELECT * FROM users ORDER BY age ASC
     * 
     * @return 나이순으로 정렬된 사용자 목록
     */
    List<User> findByOrderByAgeAsc();
    
    /**
     * 이름순으로 정렬된 사용자 목록 (내림차순)
     * 
     * @return 이름순으로 정렬된 사용자 목록 (Z-A)
     */
    List<User> findByOrderByNameDesc();
    
    /**
     * 커스텀 JPQL 쿼리 - 성인 사용자 찾기
     * 
     * @Query: JPQL(Java Persistence Query Language) 쿼리를 직접 작성
     * JPQL은 SQL과 유사하지만 엔티티와 속성을 사용합니다.
     * 
     * @return 성인 사용자 목록 (18세 이상)
     */
    @Query("SELECT u FROM User u WHERE u.age >= 18")
    List<User> findAdultUsers();
    
    /**
     * 커스텀 JPQL 쿼리 - 특정 나이대 사용자 찾기
     * 
     * @Param: 쿼리 파라미터에 이름을 지정하여 가독성 향상
     * 
     * @param minAge 최소 나이
     * @param maxAge 최대 나이
     * @return 해당 나이대 사용자 목록
     */
    @Query("SELECT u FROM User u WHERE u.age BETWEEN :minAge AND :maxAge ORDER BY u.age ASC")
    List<User> findUsersByAgeRange(@Param("minAge") Integer minAge, @Param("maxAge") Integer maxAge);
    
    /**
     * 커스텀 JPQL 쿼리 - 이름으로 검색 (대소문자 무시)
     * 
     * LOWER(): 문자열을 소문자로 변환
     * 
     * @param name 검색할 이름
     * @return 해당 이름을 포함한 사용자 목록 (대소문자 무시)
     */
    @Query("SELECT u FROM User u WHERE LOWER(u.name) LIKE LOWER(CONCAT('%', :name, '%'))")
    List<User> findUsersByNameIgnoreCase(@Param("name") String name);
    
    /**
     * 네이티브 SQL 쿼리 - 복잡한 통계 쿼리
     * 
     * @Query(nativeQuery = true): 네이티브 SQL 쿼리 사용
     * 네이티브 쿼리는 데이터베이스별 SQL 문법을 그대로 사용할 수 있습니다.
     * 
     * @return 나이대별 사용자 수 통계
     */
    @Query(value = """
        SELECT 
            CASE 
                WHEN age < 20 THEN '10대'
                WHEN age < 30 THEN '20대'
                WHEN age < 40 THEN '30대'
                WHEN age < 50 THEN '40대'
                WHEN age < 60 THEN '50대'
                ELSE '60대 이상'
            END as age_group,
            COUNT(*) as user_count
        FROM users 
        GROUP BY age_group
        ORDER BY MIN(age)
        """, nativeQuery = true)
    List<Object[]> getUserStatisticsByAgeGroup();
    
    /**
     * 커스텀 JPQL 쿼리 - 최근 가입한 사용자 찾기
     * 
     * @param days 최근 며칠간
     * @return 최근 가입한 사용자 목록
     */
    @Query("SELECT u FROM User u WHERE u.createdAt >= CURRENT_DATE - :days")
    List<User> findRecentUsers(@Param("days") int days);
    
    /**
     * 커스텀 JPQL 쿼리 - 이메일 도메인별 사용자 수
     * 
     * SUBSTRING(): 문자열의 일부를 추출
     * LOCATE(): 특정 문자열의 위치를 찾음
     * 
     * @return 이메일 도메인별 사용자 수
     */
    @Query("""
        SELECT SUBSTRING(u.email, LOCATE('@', u.email) + 1) as domain, COUNT(u) as count
        FROM User u 
        WHERE u.email IS NOT NULL
        GROUP BY domain
        ORDER BY count DESC
        """)
    List<Object[]> getUserCountByEmailDomain();
}
