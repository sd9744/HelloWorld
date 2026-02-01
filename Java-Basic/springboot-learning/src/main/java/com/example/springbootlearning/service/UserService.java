package com.example.springbootlearning.service;

import com.example.springbootlearning.entity.User;
import com.example.springbootlearning.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * 사용자 비즈니스 로직 서비스 클래스
 * 
 * 이 클래스는 사용자 관련 비즈니스 로직을 처리하는 서비스 계층입니다.
 * @Service: 서비스 계층의 컴포넌트임을 나타냄
 * @Transactional: 트랜잭션 관리 (데이터베이스 작업의 원자성 보장)
 * 
 * 주요 학습 내용:
 * 1. 서비스 계층의 역할과 책임
 * 2. @Service, @Autowired 어노테이션
 * 3. @Transactional을 사용한 트랜잭션 관리
 * 4. 비즈니스 로직과 데이터 접근 로직의 분리
 * 5. 예외 처리와 데이터 검증
 */
@Service  // 서비스 계층의 컴포넌트임을 나타냄
@Transactional  // 클래스 레벨에서 트랜잭션 관리 (모든 메서드에 적용)
public class UserService {
    
    /**
     * 사용자 리포지토리 의존성 주입
     * @Autowired: 스프링이 자동으로 UserRepository 구현체를 주입
     */
    @Autowired
    private UserRepository userRepository;
    
    /**
     * 모든 사용자 조회
     * 
     * @return 모든 사용자 목록
     */
    @Transactional(readOnly = true)  // 읽기 전용 트랜잭션 (성능 최적화)
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    
    /**
     * ID로 사용자 조회
     * 
     * @param id 사용자 ID
     * @return 사용자 정보 (Optional로 null 안전 처리)
     */
    @Transactional(readOnly = true)
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }
    
    /**
     * 이메일로 사용자 조회
     * 
     * @param email 사용자 이메일
     * @return 사용자 정보 (Optional로 null 안전 처리)
     */
    @Transactional(readOnly = true)
    public Optional<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }
    
    /**
     * 사용자 생성
     * 
     * @param user 생성할 사용자 정보
     * @return 저장된 사용자 정보
     * @throws IllegalArgumentException 이메일이 이미 존재하는 경우
     */
    public User createUser(User user) {
        // 이메일 중복 검사
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new IllegalArgumentException("이미 존재하는 이메일입니다: " + user.getEmail());
        }
        
        // 사용자 저장
        return userRepository.save(user);
    }
    
    /**
     * 사용자 정보 수정
     * 
     * @param id 수정할 사용자 ID
     * @param userDetails 수정할 사용자 정보
     * @return 수정된 사용자 정보
     * @throws IllegalArgumentException 사용자를 찾을 수 없는 경우
     */
    public User updateUser(Long id, User userDetails) {
        // 기존 사용자 조회
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("사용자를 찾을 수 없습니다. ID: " + id));
        
        // 이메일 변경 시 중복 검사
        if (!existingUser.getEmail().equals(userDetails.getEmail()) && 
            userRepository.existsByEmail(userDetails.getEmail())) {
            throw new IllegalArgumentException("이미 존재하는 이메일입니다: " + userDetails.getEmail());
        }
        
        // 사용자 정보 업데이트
        existingUser.setName(userDetails.getName());
        existingUser.setEmail(userDetails.getEmail());
        existingUser.setAge(userDetails.getAge());
        existingUser.setPhoneNumber(userDetails.getPhoneNumber());
        existingUser.setAddress(userDetails.getAddress());
        
        return userRepository.save(existingUser);
    }
    
    /**
     * 사용자 삭제
     * 
     * @param id 삭제할 사용자 ID
     * @throws IllegalArgumentException 사용자를 찾을 수 없는 경우
     */
    public void deleteUser(Long id) {
        // 사용자 존재 여부 확인
        if (!userRepository.existsById(id)) {
            throw new IllegalArgumentException("사용자를 찾을 수 없습니다. ID: " + id);
        }
        
        userRepository.deleteById(id);
    }
    
    /**
     * 이름으로 사용자 검색
     * 
     * @param name 검색할 이름 (부분 일치)
     * @return 검색된 사용자 목록
     */
    @Transactional(readOnly = true)
    public List<User> searchUsersByName(String name) {
        return userRepository.findByNameContaining(name);
    }
    
    /**
     * 나이 범위로 사용자 검색
     * 
     * @param minAge 최소 나이
     * @param maxAge 최대 나이
     * @return 검색된 사용자 목록
     */
    @Transactional(readOnly = true)
    public List<User> searchUsersByAgeRange(Integer minAge, Integer maxAge) {
        return userRepository.findByAgeBetween(minAge, maxAge);
    }
    
    /**
     * 성인 사용자 조회
     * 
     * @return 성인 사용자 목록 (18세 이상)
     */
    @Transactional(readOnly = true)
    public List<User> getAdultUsers() {
        return userRepository.findAdultUsers();
    }
    
    /**
     * 특정 나이 이상의 사용자 조회
     * 
     * @param age 최소 나이
     * @return 해당 나이 이상의 사용자 목록
     */
    @Transactional(readOnly = true)
    public List<User> getUsersByMinAge(Integer age) {
        return userRepository.findByAgeGreaterThanEqual(age);
    }
    
    /**
     * 특정 이메일 도메인의 사용자 조회
     * 
     * @param domain 이메일 도메인 (예: "gmail.com")
     * @return 해당 도메인의 사용자 목록
     */
    @Transactional(readOnly = true)
    public List<User> getUsersByEmailDomain(String domain) {
        return userRepository.findByEmailEndingWith("@" + domain);
    }
    
    /**
     * 전화번호가 있는 사용자 조회
     * 
     * @return 전화번호가 있는 사용자 목록
     */
    @Transactional(readOnly = true)
    public List<User> getUsersWithPhoneNumber() {
        return userRepository.findByPhoneNumberIsNotNull();
    }
    
    /**
     * 나이순으로 정렬된 사용자 목록 조회
     * 
     * @return 나이순으로 정렬된 사용자 목록
     */
    @Transactional(readOnly = true)
    public List<User> getUsersSortedByAge() {
        return userRepository.findByOrderByAgeAsc();
    }
    
    /**
     * 이름순으로 정렬된 사용자 목록 조회 (내림차순)
     * 
     * @return 이름순으로 정렬된 사용자 목록 (Z-A)
     */
    @Transactional(readOnly = true)
    public List<User> getUsersSortedByNameDesc() {
        return userRepository.findByOrderByNameDesc();
    }
    
    /**
     * 사용자 통계 정보 조회
     * 
     * @return 나이대별 사용자 수 통계
     */
    @Transactional(readOnly = true)
    public List<Object[]> getUserStatistics() {
        return userRepository.getUserStatisticsByAgeGroup();
    }
    
    /**
     * 이메일 도메인별 사용자 수 조회
     * 
     * @return 이메일 도메인별 사용자 수 통계
     */
    @Transactional(readOnly = true)
    public List<Object[]> getUserCountByEmailDomain() {
        return userRepository.getUserCountByEmailDomain();
    }
    
    /**
     * 최근 가입한 사용자 조회
     * 
     * @param days 최근 며칠간
     * @return 최근 가입한 사용자 목록
     */
    @Transactional(readOnly = true)
    public List<User> getRecentUsers(int days) {
        return userRepository.findRecentUsers(days);
    }
    
    /**
     * 전체 사용자 수 조회
     * 
     * @return 전체 사용자 수
     */
    @Transactional(readOnly = true)
    public long getTotalUserCount() {
        return userRepository.count();
    }
    
    /**
     * 특정 이름의 사용자 수 조회
     * 
     * @param name 사용자 이름
     * @return 해당 이름의 사용자 수
     */
    @Transactional(readOnly = true)
    public long getUserCountByName(String name) {
        return userRepository.countByName(name);
    }
    
    /**
     * 이메일 존재 여부 확인
     * 
     * @param email 확인할 이메일
     * @return 존재하면 true, 없으면 false
     */
    @Transactional(readOnly = true)
    public boolean isEmailExists(String email) {
        return userRepository.existsByEmail(email);
    }
    
    /**
     * 사용자 정보 검증
     * 
     * @param user 검증할 사용자 정보
     * @return 검증 결과 메시지
     */
    public String validateUser(User user) {
        StringBuilder validationMessage = new StringBuilder();
        
        // 이름 검증
        if (user.getName() == null || user.getName().trim().isEmpty()) {
            validationMessage.append("이름은 필수입니다. ");
        } else if (user.getName().length() < 2 || user.getName().length() > 50) {
            validationMessage.append("이름은 2자 이상 50자 이하여야 합니다. ");
        }
        
        // 이메일 검증
        if (user.getEmail() == null || user.getEmail().trim().isEmpty()) {
            validationMessage.append("이메일은 필수입니다. ");
        } else if (!user.getEmail().contains("@")) {
            validationMessage.append("올바른 이메일 형식이 아닙니다. ");
        }
        
        // 나이 검증
        if (user.getAge() == null) {
            validationMessage.append("나이는 필수입니다. ");
        } else if (user.getAge() < 1 || user.getAge() > 150) {
            validationMessage.append("나이는 1세 이상 150세 이하여야 합니다. ");
        }
        
        return validationMessage.toString().trim();
    }
    
    /**
     * 사용자 정보 요약 생성
     * 
     * @param user 사용자 정보
     * @return 사용자 정보 요약 문자열
     */
    public String getUserSummary(User user) {
        return String.format("ID: %d, 이름: %s, 나이: %d세, 이메일: %s", 
                           user.getId(), user.getName(), user.getAge(), user.getEmail());
    }
}
