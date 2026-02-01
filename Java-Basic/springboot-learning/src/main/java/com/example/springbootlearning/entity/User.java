package com.example.springbootlearning.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

/**
 * 사용자 엔티티 클래스
 * 
 * 이 클래스는 JPA(Java Persistence API)를 사용하여 데이터베이스 테이블과 매핑되는 엔티티입니다.
 * @Entity: 이 클래스가 데이터베이스 테이블과 매핑됨을 나타냄
 * @Table: 테이블 이름을 지정 (기본값: 클래스명과 동일)
 * 
 * 주요 학습 내용:
 * 1. JPA 엔티티 기본 구조
 * 2. @Entity, @Table, @Id, @GeneratedValue 어노테이션
 * 3. @Column 어노테이션으로 컬럼 속성 설정
 * 4. @Validation 어노테이션으로 데이터 검증
 * 5. 생성자, Getter, Setter 메서드
 */
@Entity  // JPA 엔티티임을 나타냄
@Table(name = "users")  // 데이터베이스 테이블 이름 지정
public class User {
    
    /**
     * 사용자 ID (Primary Key)
     * @Id: 기본키임을 나타냄
     * @GeneratedValue: 자동 생성되는 값임을 나타냄
     * strategy = GenerationType.IDENTITY: 데이터베이스의 AUTO_INCREMENT 사용
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    /**
     * 사용자 이름
     * @NotBlank: null이거나 공백이면 안됨
     * @Size: 최소 2자, 최대 50자
     * @Column: 컬럼 속성 설정 (nullable = false: NOT NULL)
     */
    @NotBlank(message = "이름은 필수입니다")
    @Size(min = 2, max = 50, message = "이름은 2자 이상 50자 이하여야 합니다")
    @Column(nullable = false, length = 50)
    private String name;
    
    /**
     * 이메일 주소
     * @Email: 이메일 형식 검증
     * @Column(unique = true): 중복되지 않는 유니크 값
     */
    @NotBlank(message = "이메일은 필수입니다")
    @Email(message = "올바른 이메일 형식이 아닙니다")
    @Column(nullable = false, unique = true, length = 100)
    private String email;
    
    /**
     * 나이
     * @NotNull: null이면 안됨
     * @Min, @Max: 최소값, 최대값 제한
     */
    @NotNull(message = "나이는 필수입니다")
    @Min(value = 1, message = "나이는 1세 이상이어야 합니다")
    @Max(value = 150, message = "나이는 150세 이하여야 합니다")
    @Column(nullable = false)
    private Integer age;
    
    /**
     * 전화번호
     * @Size: 최대 20자
     */
    @Size(max = 20, message = "전화번호는 20자 이하여야 합니다")
    @Column(length = 20)
    private String phoneNumber;
    
    /**
     * 주소
     * @Size: 최대 200자
     */
    @Size(max = 200, message = "주소는 200자 이하여야 합니다")
    @Column(length = 200)
    private String address;
    
    /**
     * 계정 생성 시간
     * @Column(updatable = false): 수정 불가능 (생성 시에만 설정됨)
     */
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;
    
    /**
     * 계정 수정 시간
     * @Column(insertable = false): 삽입 시에는 설정되지 않음 (수정 시에만 업데이트됨)
     */
    @Column(name = "updated_at", insertable = false)
    private LocalDateTime updatedAt;
    
    /**
     * 기본 생성자
     * JPA에서 엔티티 객체를 생성할 때 필요
     */
    public User() {
        // 기본 생성자 (JPA 요구사항)
    }
    
    /**
     * 사용자 생성용 생성자
     * 
     * @param name 사용자 이름
     * @param email 이메일 주소
     * @param age 나이
     */
    public User(String name, String email, Integer age) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.createdAt = LocalDateTime.now();
    }
    
    /**
     * 모든 필드를 포함한 생성자
     * 
     * @param name 사용자 이름
     * @param email 이메일 주소
     * @param age 나이
     * @param phoneNumber 전화번호
     * @param address 주소
     */
    public User(String name, String email, Integer age, String phoneNumber, String address) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.createdAt = LocalDateTime.now();
    }
    
    // Getter 메서드들
    public Long getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }
    
    public String getEmail() {
        return email;
    }
    
    public Integer getAge() {
        return age;
    }
    
    public String getPhoneNumber() {
        return phoneNumber;
    }
    
    public String getAddress() {
        return address;
    }
    
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    
    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
    
    // Setter 메서드들
    public void setId(Long id) {
        this.id = id;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public void setAge(Integer age) {
        this.age = age;
    }
    
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
    
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
    
    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
    
    /**
     * 엔티티 저장 전에 실행되는 메서드
     * @PrePersist: 엔티티가 데이터베이스에 저장되기 전에 호출됨
     */
    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }
    
    /**
     * 엔티티 수정 전에 실행되는 메서드
     * @PreUpdate: 엔티티가 데이터베이스에서 수정되기 전에 호출됨
     */
    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
    
    /**
     * 사용자 정보를 문자열로 반환
     * @return 사용자 정보 문자열
     */
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
    
    /**
     * 두 User 객체가 같은지 비교
     * @param obj 비교할 객체
     * @return 같으면 true, 다르면 false
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        
        User user = (User) obj;
        return id != null && id.equals(user.id);
    }
    
    /**
     * 객체의 해시코드 반환
     * @return 해시코드
     */
    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
