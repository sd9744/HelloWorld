package com.example.springbootlearning.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * REST API 컨트롤러 예제 - HelloController
 * 
 * 이 클래스는 스프링부트의 REST API 개발 방법을 학습하기 위한 예제입니다.
 * @RestController: REST API 컨트롤러임을 나타냄 (JSON 응답 자동 변환)
 * @RequestMapping: 기본 URL 경로 설정
 * @GetMapping: HTTP GET 요청을 처리하는 메서드임을 나타냄
 * 
 * 주요 학습 내용:
 * 1. REST API 기본 구조
 * 2. HTTP 메서드 매핑 (@GetMapping)
 * 3. URL 경로 변수 (@PathVariable)
 * 4. 쿼리 파라미터 (@RequestParam)
 * 5. JSON 응답 자동 변환
 */
@RestController  // REST API 컨트롤러임을 나타냄 (JSON 응답 자동 변환)
@RequestMapping("/api/hello")  // 기본 URL 경로 설정
public class HelloController {
    
    /**
     * 기본 인사 메시지 API
     * 
     * URL: GET /api/hello
     * 응답: "안녕하세요! 스프링부트에 오신 것을 환영합니다!"
     */
    @GetMapping  // HTTP GET 요청을 처리
    public String hello() {
        return "안녕하세요! 스프링부트에 오신 것을 환영합니다!";
    }
    
    /**
     * 개인화된 인사 메시지 API
     * 
     * URL: GET /api/hello/personal?name=홍길동
     * 응답: "안녕하세요, 홍길동님! 스프링부트 학습을 시작해보세요!"
     * 
     * @param name 사용자 이름 (쿼리 파라미터)
     * @return 개인화된 인사 메시지
     */
    @GetMapping("/personal")  // /api/hello/personal 경로
    public String personalHello(@RequestParam String name) {
        return "안녕하세요, " + name + "님! 스프링부트 학습을 시작해보세요!";
    }
    
    /**
     * URL 경로 변수를 사용한 인사 메시지 API
     * 
     * URL: GET /api/hello/user/홍길동
     * 응답: "안녕하세요, 홍길동님! 오늘도 좋은 하루 되세요!"
     * 
     * @param username URL 경로에 포함된 사용자명
     * @return 개인화된 인사 메시지
     */
    @GetMapping("/user/{username}")  // /api/hello/user/{username} 경로
    public String userHello(@PathVariable String username) {
        return "안녕하세요, " + username + "님! 오늘도 좋은 하루 되세요!";
    }
    
    /**
     * 상세한 정보를 포함한 JSON 응답 API
     * 
     * URL: GET /api/hello/info?name=김철수&age=25
     * 응답: JSON 형태의 상세 정보
     * 
     * @param name 사용자 이름
     * @param age 사용자 나이
     * @return 사용자 정보가 포함된 Map 객체 (JSON으로 자동 변환됨)
     */
    @GetMapping("/info")
    public Map<String, Object> userInfo(
            @RequestParam String name,
            @RequestParam(required = false, defaultValue = "0") int age) {
        
        // Map 객체를 생성하여 사용자 정보를 담음
        Map<String, Object> userInfo = new HashMap<>();
        userInfo.put("name", name);
        userInfo.put("age", age);
        userInfo.put("message", "안녕하세요, " + name + "님!");
        userInfo.put("timestamp", LocalDateTime.now());
        userInfo.put("status", "success");
        
        // 성인 여부 판단
        if (age >= 18) {
            userInfo.put("isAdult", true);
            userInfo.put("category", "성인");
        } else {
            userInfo.put("isAdult", false);
            userInfo.put("category", "미성년자");
        }
        
        return userInfo;  // Map 객체가 JSON으로 자동 변환됨
    }
    
    /**
     * 현재 시간 정보를 반환하는 API
     * 
     * URL: GET /api/hello/time
     * 응답: 현재 시간 정보가 포함된 JSON
     * 
     * @return 현재 시간 정보
     */
    @GetMapping("/time")
    public Map<String, Object> currentTime() {
        Map<String, Object> timeInfo = new HashMap<>();
        LocalDateTime now = LocalDateTime.now();
        
        timeInfo.put("currentTime", now);
        timeInfo.put("year", now.getYear());
        timeInfo.put("month", now.getMonthValue());
        timeInfo.put("day", now.getDayOfMonth());
        timeInfo.put("hour", now.getHour());
        timeInfo.put("minute", now.getMinute());
        timeInfo.put("second", now.getSecond());
        timeInfo.put("dayOfWeek", now.getDayOfWeek());
        
        return timeInfo;
    }
    
    /**
     * 간단한 계산기 API
     * 
     * URL: GET /api/hello/calculate?a=10&b=5&operation=add
     * 응답: 계산 결과가 포함된 JSON
     * 
     * @param a 첫 번째 숫자
     * @param b 두 번째 숫자
     * @param operation 연산 종류 (add, subtract, multiply, divide)
     * @return 계산 결과
     */
    @GetMapping("/calculate")
    public Map<String, Object> calculate(
            @RequestParam double a,
            @RequestParam double b,
            @RequestParam String operation) {
        
        Map<String, Object> result = new HashMap<>();
        result.put("a", a);
        result.put("b", b);
        result.put("operation", operation);
        
        double calculationResult;
        String operationName;
        
        switch (operation.toLowerCase()) {
            case "add":
                calculationResult = a + b;
                operationName = "덧셈";
                break;
            case "subtract":
                calculationResult = a - b;
                operationName = "뺄셈";
                break;
            case "multiply":
                calculationResult = a * b;
                operationName = "곱셈";
                break;
            case "divide":
                if (b != 0) {
                    calculationResult = a / b;
                    operationName = "나눗셈";
                } else {
                    result.put("error", "0으로 나눌 수 없습니다!");
                    return result;
                }
                break;
            default:
                result.put("error", "지원하지 않는 연산입니다. (add, subtract, multiply, divide)");
                return result;
        }
        
        result.put("result", calculationResult);
        result.put("operationName", operationName);
        result.put("expression", a + " " + operation + " " + b + " = " + calculationResult);
        
        return result;
    }
    
    /**
     * 에러 처리 예제 API
     * 
     * URL: GET /api/hello/error
     * 응답: 의도적으로 에러를 발생시켜 에러 처리 방법을 학습
     */
    @GetMapping("/error")
    public String errorExample() {
        // 의도적으로 예외를 발생시킴 (에러 처리 학습용)
        throw new RuntimeException("이것은 학습용 에러입니다!");
    }
}
