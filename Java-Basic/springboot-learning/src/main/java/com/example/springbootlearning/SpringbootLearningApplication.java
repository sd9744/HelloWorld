package com.example.springbootlearning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 스프링부트 메인 애플리케이션 클래스
 * 
 * 이 클래스는 스프링부트 애플리케이션의 진입점(Entry Point)입니다.
 * @SpringBootApplication 어노테이션이 스프링부트의 핵심 기능들을 자동으로 설정합니다.
 * 
 * 주요 기능:
 * 1. @SpringBootApplication: 스프링부트 자동 설정, 컴포넌트 스캔, 설정 클래스 활성화
 * 2. main 메서드: 애플리케이션을 시작하는 진입점
 * 3. SpringApplication.run(): 스프링부트 애플리케이션을 실행
 */
@SpringBootApplication
public class SpringbootLearningApplication {

    /**
     * 애플리케이션의 메인 메서드
     * 
     * 이 메서드는 스프링부트 애플리케이션을 시작하는 진입점입니다.
     * SpringApplication.run() 메서드를 호출하여 스프링 컨테이너를 시작하고
     * 내장 톰캣 서버를 실행합니다.
     * 
     * @param args 명령행 인수 (프로그램 실행 시 전달되는 매개변수)
     */
    public static void main(String[] args) {
        // 스프링부트 애플리케이션 실행
        // 첫 번째 매개변수: 메인 클래스 (현재 클래스)
        // 두 번째 매개변수: 명령행 인수
        SpringApplication.run(SpringbootLearningApplication.class, args);
        
        // 애플리케이션이 시작되면 다음 메시지가 출력됩니다
        System.out.println("==========================================");
        System.out.println("🚀 스프링부트 학습 애플리케이션이 시작되었습니다!");
        System.out.println("📱 웹 브라우저에서 http://localhost:8080 으로 접속하세요");
        System.out.println("🗄️  H2 데이터베이스 콘솔: http://localhost:8080/h2-console");
        System.out.println("==========================================");
    }
}
