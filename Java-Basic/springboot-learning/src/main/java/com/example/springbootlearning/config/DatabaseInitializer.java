package com.example.springbootlearning.config;

import com.example.springbootlearning.entity.User;
import com.example.springbootlearning.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 데이터베이스 초기화 컴포넌트
 * 
 * 이 클래스는 애플리케이션 시작 시 샘플 데이터를 데이터베이스에 삽입합니다.
 * CommandLineRunner: 애플리케이션 시작 후 실행되는 인터페이스
 * 
 * 주요 학습 내용:
 * 1. CommandLineRunner 인터페이스 사용법
 * 2. 애플리케이션 시작 시 초기 데이터 설정
 * 3. 서비스 계층을 통한 데이터 조작
 * 4. 예외 처리와 로깅
 */
@Component  // 스프링 컴포넌트로 등록
public class DatabaseInitializer implements CommandLineRunner {
    
    /**
     * 사용자 서비스 의존성 주입
     */
    @Autowired
    private UserService userService;
    
    /**
     * 애플리케이션 시작 후 실행되는 메서드
     * 
     * @param args 명령행 인수
     * @throws Exception 예외 발생 시
     */
    @Override
    public void run(String... args) throws Exception {
        System.out.println("==========================================");
        System.out.println("🗄️  데이터베이스 초기화를 시작합니다...");
        
        try {
            // 기존 데이터가 있는지 확인
            long existingUserCount = userService.getTotalUserCount();
            
            if (existingUserCount > 0) {
                System.out.println("📊 기존 사용자 데이터가 " + existingUserCount + "개 있습니다.");
                System.out.println("🔄 샘플 데이터 생성을 건너뜁니다.");
                return;
            }
            
            // 샘플 사용자 데이터 생성
            createSampleUsers();
            
            System.out.println("✅ 샘플 데이터 생성이 완료되었습니다!");
            System.out.println("📱 다음 URL로 API를 테스트해보세요:");
            System.out.println("   - 전체 사용자 조회: http://localhost:8080/api/users");
            System.out.println("   - 사용자 통계: http://localhost:8080/api/users/statistics");
            System.out.println("   - 성인 사용자: http://localhost:8080/api/users/adults");
            
        } catch (Exception e) {
            System.err.println("❌ 데이터베이스 초기화 중 오류가 발생했습니다: " + e.getMessage());
            e.printStackTrace();
        }
        
        System.out.println("==========================================");
    }
    
    /**
     * 샘플 사용자 데이터를 생성하는 메서드
     */
    private void createSampleUsers() {
        System.out.println("👥 샘플 사용자 데이터를 생성합니다...");
        
        // 다양한 연령대와 정보를 가진 샘플 사용자들 생성
        User[] sampleUsers = {
            // 20대 사용자들
            new User("김철수", "kim@example.com", 25, "010-1234-5678", "서울시 강남구"),
            new User("이영희", "lee@example.com", 28, "010-2345-6789", "서울시 서초구"),
            new User("박민수", "park@gmail.com", 22, "010-3456-7890", "부산시 해운대구"),
            
            // 30대 사용자들
            new User("최지영", "choi@naver.com", 32, "010-4567-8901", "대구시 수성구"),
            new User("정민호", "jung@example.com", 35, "010-5678-9012", "인천시 연수구"),
            new User("한소영", "han@yahoo.com", 30, "010-6789-0123", "광주시 서구"),
            
            // 40대 사용자들
            new User("윤성호", "yoon@example.com", 42, "010-7890-1234", "대전시 유성구"),
            new User("강미영", "kang@hotmail.com", 45, "010-8901-2345", "울산시 남구"),
            
            // 50대 사용자들
            new User("임동수", "lim@example.com", 52, "010-9012-3456", "세종시 조치원읍"),
            new User("송현정", "song@example.com", 55, "010-0123-4567", "경기도 수원시"),
            
            // 60대 이상 사용자들
            new User("조영수", "jo@example.com", 62, "010-1234-5679", "경기도 성남시"),
            new User("오미경", "oh@example.com", 68, "010-2345-6780", "경기도 안양시"),
            
            // 전화번호가 없는 사용자 (선택적 정보 테스트용)
            new User("신동욱", "shin@example.com", 27, null, "서울시 마포구"),
            new User("배수진", "bae@example.com", 33, null, "부산시 부산진구"),
            
            // 주소가 없는 사용자
            new User("홍길동", "hong@example.com", 29, "010-3456-7891", null),
            new User("김영수", "kim2@example.com", 31, "010-4567-8902", null),
            
            // 다양한 이메일 도메인 테스트용
            new User("테스트1", "test1@company.co.kr", 26, "010-5678-9013", "서울시 종로구"),
            new User("테스트2", "test2@university.ac.kr", 24, "010-6789-0124", "서울시 중구"),
            new User("테스트3", "test3@startup.io", 28, "010-7890-1235", "서울시 용산구"),
            
            // 최근 가입자들 (통계 테스트용)
            new User("신규1", "new1@example.com", 23, "010-8901-2346", "서울시 송파구"),
            new User("신규2", "new2@example.com", 26, "010-9012-3457", "서울시 강동구"),
            new User("신규3", "new3@example.com", 29, "010-0123-4568", "서울시 노원구")
        };
        
        // 각 사용자를 데이터베이스에 저장
        for (int i = 0; i < sampleUsers.length; i++) {
            try {
                User createdUser = userService.createUser(sampleUsers[i]);
                System.out.println("✅ 사용자 생성 완료: " + createdUser.getName() + 
                                 " (" + createdUser.getEmail() + ")");
            } catch (Exception e) {
                System.err.println("❌ 사용자 생성 실패: " + sampleUsers[i].getName() + 
                                 " - " + e.getMessage());
            }
        }
        
        // 생성된 사용자 수 확인
        long totalUsers = userService.getTotalUserCount();
        System.out.println("📊 총 " + totalUsers + "명의 사용자가 생성되었습니다.");
        
        // 통계 정보 출력
        printUserStatistics();
    }
    
    /**
     * 사용자 통계 정보를 출력하는 메서드
     */
    private void printUserStatistics() {
        System.out.println("\n📈 사용자 통계 정보:");
        
        try {
            // 나이대별 통계
            List<Object[]> ageStatistics = userService.getUserStatistics();
            System.out.println("   나이대별 사용자 수:");
            for (Object[] stat : ageStatistics) {
                System.out.println("   - " + stat[0] + ": " + stat[1] + "명");
            }
            
            // 이메일 도메인별 통계
            List<Object[]> domainStatistics = userService.getUserCountByEmailDomain();
            System.out.println("   이메일 도메인별 사용자 수:");
            for (Object[] stat : domainStatistics) {
                System.out.println("   - " + stat[0] + ": " + stat[1] + "명");
            }
            
            // 성인 사용자 수
            List<User> adultUsers = userService.getAdultUsers();
            System.out.println("   성인 사용자 (18세 이상): " + adultUsers.size() + "명");
            
            // 전화번호가 있는 사용자 수
            List<User> usersWithPhone = userService.getUsersWithPhoneNumber();
            System.out.println("   전화번호가 있는 사용자: " + usersWithPhone.size() + "명");
            
        } catch (Exception e) {
            System.err.println("❌ 통계 정보 조회 중 오류 발생: " + e.getMessage());
        }
    }
}
