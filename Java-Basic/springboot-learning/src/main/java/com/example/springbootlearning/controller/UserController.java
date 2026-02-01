package com.example.springbootlearning.controller;

import com.example.springbootlearning.entity.User;
import com.example.springbootlearning.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * 사용자 REST API 컨트롤러
 * 
 * 이 클래스는 사용자 관련 REST API 엔드포인트를 제공합니다.
 * @RestController: REST API 컨트롤러임을 나타냄
 * @RequestMapping: 기본 URL 경로 설정
 * 
 * 주요 학습 내용:
 * 1. REST API 설계 원칙
 * 2. HTTP 메서드 매핑 (@GetMapping, @PostMapping, @PutMapping, @DeleteMapping)
 * 3. @PathVariable, @RequestBody 어노테이션
 * 4. ResponseEntity를 사용한 HTTP 응답 제어
 * 5. 예외 처리와 에러 응답
 * 6. CRUD 작업의 REST API 구현
 */
@RestController  // REST API 컨트롤러임을 나타냄
@RequestMapping("/api/users")  // 기본 URL 경로: /api/users
public class UserController {
    
    /**
     * 사용자 서비스 의존성 주입
     * @Autowired: 스프링이 자동으로 UserService 구현체를 주입
     */
    @Autowired
    private UserService userService;
    
    /**
     * 모든 사용자 조회 API
     * 
     * URL: GET /api/users
     * 응답: 사용자 목록 (JSON)
     * 
     * @return 모든 사용자 목록
     */
    @GetMapping  // HTTP GET 요청 처리
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(users);  // HTTP 200 OK와 함께 응답
    }
    
    /**
     * ID로 사용자 조회 API
     * 
     * URL: GET /api/users/{id}
     * 응답: 사용자 정보 (JSON) 또는 404 Not Found
     * 
     * @param id 사용자 ID
     * @return 사용자 정보 또는 404 에러
     */
    @GetMapping("/{id}")  // /api/users/{id} 경로
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        Optional<User> user = userService.getUserById(id);
        
        if (user.isPresent()) {
            return ResponseEntity.ok(user.get());  // 사용자 정보 반환
        } else {
            return ResponseEntity.notFound().build();  // 404 Not Found
        }
    }
    
    /**
     * 이메일로 사용자 조회 API
     * 
     * URL: GET /api/users/email/{email}
     * 응답: 사용자 정보 (JSON) 또는 404 Not Found
     * 
     * @param email 사용자 이메일
     * @return 사용자 정보 또는 404 에러
     */
    @GetMapping("/email/{email}")
    public ResponseEntity<User> getUserByEmail(@PathVariable String email) {
        Optional<User> user = userService.getUserByEmail(email);
        
        if (user.isPresent()) {
            return ResponseEntity.ok(user.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    /**
     * 사용자 생성 API
     * 
     * URL: POST /api/users
     * 요청 본문: 사용자 정보 (JSON)
     * 응답: 생성된 사용자 정보 (JSON) 또는 400 Bad Request
     * 
     * @param user 생성할 사용자 정보
     * @return 생성된 사용자 정보 또는 에러 메시지
     */
    @PostMapping  // HTTP POST 요청 처리
    public ResponseEntity<?> createUser(@RequestBody User user) {
        try {
            // 사용자 정보 검증
            String validationMessage = userService.validateUser(user);
            if (!validationMessage.isEmpty()) {
                Map<String, String> error = new HashMap<>();
                error.put("error", "입력 데이터 검증 실패");
                error.put("message", validationMessage);
                return ResponseEntity.badRequest().body(error);
            }
            
            // 사용자 생성
            User createdUser = userService.createUser(user);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);  // HTTP 201 Created
            
        } catch (IllegalArgumentException e) {
            Map<String, String> error = new HashMap<>();
            error.put("error", "사용자 생성 실패");
            error.put("message", e.getMessage());
            return ResponseEntity.badRequest().body(error);
        }
    }
    
    /**
     * 사용자 정보 수정 API
     * 
     * URL: PUT /api/users/{id}
     * 요청 본문: 수정할 사용자 정보 (JSON)
     * 응답: 수정된 사용자 정보 (JSON) 또는 에러 메시지
     * 
     * @param id 수정할 사용자 ID
     * @param userDetails 수정할 사용자 정보
     * @return 수정된 사용자 정보 또는 에러 메시지
     */
    @PutMapping("/{id}")  // HTTP PUT 요청 처리
    public ResponseEntity<?> updateUser(@PathVariable Long id, @RequestBody User userDetails) {
        try {
            // 사용자 정보 검증
            String validationMessage = userService.validateUser(userDetails);
            if (!validationMessage.isEmpty()) {
                Map<String, String> error = new HashMap<>();
                error.put("error", "입력 데이터 검증 실패");
                error.put("message", validationMessage);
                return ResponseEntity.badRequest().body(error);
            }
            
            // 사용자 정보 수정
            User updatedUser = userService.updateUser(id, userDetails);
            return ResponseEntity.ok(updatedUser);
            
        } catch (IllegalArgumentException e) {
            Map<String, String> error = new HashMap<>();
            error.put("error", "사용자 수정 실패");
            error.put("message", e.getMessage());
            return ResponseEntity.badRequest().body(error);
        }
    }
    
    /**
     * 사용자 삭제 API
     * 
     * URL: DELETE /api/users/{id}
     * 응답: 삭제 성공 메시지 또는 에러 메시지
     * 
     * @param id 삭제할 사용자 ID
     * @return 삭제 성공 메시지 또는 에러 메시지
     */
    @DeleteMapping("/{id}")  // HTTP DELETE 요청 처리
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        try {
            userService.deleteUser(id);
            Map<String, String> response = new HashMap<>();
            response.put("message", "사용자가 성공적으로 삭제되었습니다.");
            response.put("deletedUserId", id.toString());
            return ResponseEntity.ok(response);
            
        } catch (IllegalArgumentException e) {
            Map<String, String> error = new HashMap<>();
            error.put("error", "사용자 삭제 실패");
            error.put("message", e.getMessage());
            return ResponseEntity.badRequest().body(error);
        }
    }
    
    /**
     * 이름으로 사용자 검색 API
     * 
     * URL: GET /api/users/search?name=검색어
     * 응답: 검색된 사용자 목록 (JSON)
     * 
     * @param name 검색할 이름
     * @return 검색된 사용자 목록
     */
    @GetMapping("/search")  // /api/users/search 경로
    public ResponseEntity<List<User>> searchUsersByName(@RequestParam String name) {
        List<User> users = userService.searchUsersByName(name);
        return ResponseEntity.ok(users);
    }
    
    /**
     * 나이 범위로 사용자 검색 API
     * 
     * URL: GET /api/users/search/age?minAge=20&maxAge=30
     * 응답: 검색된 사용자 목록 (JSON)
     * 
     * @param minAge 최소 나이
     * @param maxAge 최대 나이
     * @return 검색된 사용자 목록
     */
    @GetMapping("/search/age")
    public ResponseEntity<List<User>> searchUsersByAgeRange(
            @RequestParam Integer minAge, 
            @RequestParam Integer maxAge) {
        List<User> users = userService.searchUsersByAgeRange(minAge, maxAge);
        return ResponseEntity.ok(users);
    }
    
    /**
     * 성인 사용자 조회 API
     * 
     * URL: GET /api/users/adults
     * 응답: 성인 사용자 목록 (JSON)
     * 
     * @return 성인 사용자 목록 (18세 이상)
     */
    @GetMapping("/adults")
    public ResponseEntity<List<User>> getAdultUsers() {
        List<User> adultUsers = userService.getAdultUsers();
        return ResponseEntity.ok(adultUsers);
    }
    
    /**
     * 특정 나이 이상의 사용자 조회 API
     * 
     * URL: GET /api/users/age/{age}
     * 응답: 해당 나이 이상의 사용자 목록 (JSON)
     * 
     * @param age 최소 나이
     * @return 해당 나이 이상의 사용자 목록
     */
    @GetMapping("/age/{age}")
    public ResponseEntity<List<User>> getUsersByMinAge(@PathVariable Integer age) {
        List<User> users = userService.getUsersByMinAge(age);
        return ResponseEntity.ok(users);
    }
    
    /**
     * 특정 이메일 도메인의 사용자 조회 API
     * 
     * URL: GET /api/users/domain/{domain}
     * 응답: 해당 도메인의 사용자 목록 (JSON)
     * 
     * @param domain 이메일 도메인 (예: gmail.com)
     * @return 해당 도메인의 사용자 목록
     */
    @GetMapping("/domain/{domain}")
    public ResponseEntity<List<User>> getUsersByEmailDomain(@PathVariable String domain) {
        List<User> users = userService.getUsersByEmailDomain(domain);
        return ResponseEntity.ok(users);
    }
    
    /**
     * 전화번호가 있는 사용자 조회 API
     * 
     * URL: GET /api/users/with-phone
     * 응답: 전화번호가 있는 사용자 목록 (JSON)
     * 
     * @return 전화번호가 있는 사용자 목록
     */
    @GetMapping("/with-phone")
    public ResponseEntity<List<User>> getUsersWithPhoneNumber() {
        List<User> users = userService.getUsersWithPhoneNumber();
        return ResponseEntity.ok(users);
    }
    
    /**
     * 나이순으로 정렬된 사용자 목록 조회 API
     * 
     * URL: GET /api/users/sorted/age
     * 응답: 나이순으로 정렬된 사용자 목록 (JSON)
     * 
     * @return 나이순으로 정렬된 사용자 목록
     */
    @GetMapping("/sorted/age")
    public ResponseEntity<List<User>> getUsersSortedByAge() {
        List<User> users = userService.getUsersSortedByAge();
        return ResponseEntity.ok(users);
    }
    
    /**
     * 이름순으로 정렬된 사용자 목록 조회 API (내림차순)
     * 
     * URL: GET /api/users/sorted/name
     * 응답: 이름순으로 정렬된 사용자 목록 (JSON)
     * 
     * @return 이름순으로 정렬된 사용자 목록 (Z-A)
     */
    @GetMapping("/sorted/name")
    public ResponseEntity<List<User>> getUsersSortedByNameDesc() {
        List<User> users = userService.getUsersSortedByNameDesc();
        return ResponseEntity.ok(users);
    }
    
    /**
     * 사용자 통계 정보 조회 API
     * 
     * URL: GET /api/users/statistics
     * 응답: 나이대별 사용자 수 통계 (JSON)
     * 
     * @return 사용자 통계 정보
     */
    @GetMapping("/statistics")
    public ResponseEntity<List<Object[]>> getUserStatistics() {
        List<Object[]> statistics = userService.getUserStatistics();
        return ResponseEntity.ok(statistics);
    }
    
    /**
     * 이메일 도메인별 사용자 수 조회 API
     * 
     * URL: GET /api/users/statistics/domains
     * 응답: 이메일 도메인별 사용자 수 통계 (JSON)
     * 
     * @return 이메일 도메인별 사용자 수 통계
     */
    @GetMapping("/statistics/domains")
    public ResponseEntity<List<Object[]>> getUserCountByEmailDomain() {
        List<Object[]> domainStatistics = userService.getUserCountByEmailDomain();
        return ResponseEntity.ok(domainStatistics);
    }
    
    /**
     * 최근 가입한 사용자 조회 API
     * 
     * URL: GET /api/users/recent?days=7
     * 응답: 최근 가입한 사용자 목록 (JSON)
     * 
     * @param days 최근 며칠간 (기본값: 7)
     * @return 최근 가입한 사용자 목록
     */
    @GetMapping("/recent")
    public ResponseEntity<List<User>> getRecentUsers(@RequestParam(defaultValue = "7") int days) {
        List<User> recentUsers = userService.getRecentUsers(days);
        return ResponseEntity.ok(recentUsers);
    }
    
    /**
     * 전체 사용자 수 조회 API
     * 
     * URL: GET /api/users/count
     * 응답: 전체 사용자 수 (JSON)
     * 
     * @return 전체 사용자 수
     */
    @GetMapping("/count")
    public ResponseEntity<Map<String, Object>> getTotalUserCount() {
        long totalCount = userService.getTotalUserCount();
        Map<String, Object> response = new HashMap<>();
        response.put("totalUsers", totalCount);
        response.put("message", "전체 사용자 수 조회 완료");
        return ResponseEntity.ok(response);
    }
    
    /**
     * 이메일 존재 여부 확인 API
     * 
     * URL: GET /api/users/exists/email/{email}
     * 응답: 이메일 존재 여부 (JSON)
     * 
     * @param email 확인할 이메일
     * @return 이메일 존재 여부
     */
    @GetMapping("/exists/email/{email}")
    public ResponseEntity<Map<String, Object>> checkEmailExists(@PathVariable String email) {
        boolean exists = userService.isEmailExists(email);
        Map<String, Object> response = new HashMap<>();
        response.put("email", email);
        response.put("exists", exists);
        response.put("message", exists ? "이메일이 존재합니다." : "이메일이 존재하지 않습니다.");
        return ResponseEntity.ok(response);
    }
    
    /**
     * 사용자 정보 요약 조회 API
     * 
     * URL: GET /api/users/{id}/summary
     * 응답: 사용자 정보 요약 (JSON)
     * 
     * @param id 사용자 ID
     * @return 사용자 정보 요약 또는 404 에러
     */
    @GetMapping("/{id}/summary")
    public ResponseEntity<?> getUserSummary(@PathVariable Long id) {
        Optional<User> user = userService.getUserById(id);
        
        if (user.isPresent()) {
            String summary = userService.getUserSummary(user.get());
            Map<String, Object> response = new HashMap<>();
            response.put("summary", summary);
            response.put("user", user.get());
            return ResponseEntity.ok(response);
        } else {
            Map<String, String> error = new HashMap<>();
            error.put("error", "사용자를 찾을 수 없습니다.");
            error.put("message", "ID " + id + "에 해당하는 사용자가 존재하지 않습니다.");
            return ResponseEntity.notFound().build();
        }
    }
}
