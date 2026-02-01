/**
 * 자바 변수와 데이터 타입 학습 예제
 * 
 * 이 파일은 자바의 기본적인 변수 선언과 데이터 타입을 학습하기 위한 예제입니다.
 * 비전공자를 위해 각 줄마다 자세한 설명을 포함했습니다.
 */

public class VariableExamples {
    
    // 메인 메서드 - 프로그램이 시작되는 진입점
    public static void main(String[] args) {
        System.out.println("=== 자바 변수와 데이터 타입 예제 ===");
        
        // 1. 정수형 변수들
        // int: 가장 많이 사용하는 정수 타입 (32비트, -2,147,483,648 ~ 2,147,483,647)
        int age = 25;  // 나이를 저장하는 변수
        int year = 2024;  // 연도를 저장하는 변수
        
        // long: 더 큰 정수를 저장할 때 사용 (64비트)
        long population = 50000000L;  // 인구수를 저장 (L을 붙여서 long 타입임을 명시)
        
        // short: 작은 정수 (16비트, -32,768 ~ 32,767)
        short temperature = -10;  // 온도를 저장
        
        // byte: 가장 작은 정수 (8비트, -128 ~ 127)
        byte grade = 95;  // 점수를 저장
        
        // 2. 실수형 변수들
        // double: 소수점이 있는 숫자 (64비트, 더 정확함)
        double height = 175.5;  // 키를 저장
        double pi = 3.14159265359;  // 원주율
        
        // float: 소수점이 있는 숫자 (32비트, 덜 정확하지만 메모리 절약)
        float weight = 70.5f;  // 몸무게를 저장 (f를 붙여서 float 타입임을 명시)
        
        // 3. 문자형 변수
        // char: 하나의 문자를 저장 (16비트, 유니코드 지원)
        char gradeLetter = 'A';  // 학점을 저장
        char koreanChar = '한';  // 한글도 저장 가능
        
        // 4. 논리형 변수
        // boolean: true 또는 false만 저장 가능
        boolean isStudent = true;  // 학생 여부를 저장
        boolean isWorking = false;  // 일하고 있는지 여부를 저장
        
        // 5. 문자열 변수
        // String: 여러 문자를 저장 (실제로는 클래스이지만 기본 타입처럼 사용)
        String name = "김철수";  // 이름을 저장
        String address = "서울시 강남구";  // 주소를 저장
        
        // 변수 값 출력하기
        System.out.println("=== 변수 값 출력 ===");
        System.out.println("나이: " + age + "세");
        System.out.println("연도: " + year + "년");
        System.out.println("인구수: " + population + "명");
        System.out.println("온도: " + temperature + "도");
        System.out.println("점수: " + grade + "점");
        System.out.println("키: " + height + "cm");
        System.out.println("원주율: " + pi);
        System.out.println("몸무게: " + weight + "kg");
        System.out.println("학점: " + gradeLetter);
        System.out.println("한글: " + koreanChar);
        System.out.println("학생 여부: " + isStudent);
        System.out.println("일하는 중: " + isWorking);
        System.out.println("이름: " + name);
        System.out.println("주소: " + address);
        
        // 변수 값 변경하기
        System.out.println("\n=== 변수 값 변경 후 ===");
        age = 26;  // 나이를 26으로 변경
        name = "김영희";  // 이름을 김영희로 변경
        isStudent = false;  // 학생이 아니게 변경
        
        System.out.println("변경된 나이: " + age + "세");
        System.out.println("변경된 이름: " + name);
        System.out.println("변경된 학생 여부: " + isStudent);
        
        // 상수 (final 키워드 사용)
        // 상수는 한 번 값을 설정하면 변경할 수 없습니다
        final int MAX_STUDENTS = 30;  // 최대 학생 수 (변경 불가)
        final String SCHOOL_NAME = "코딩학교";  // 학교 이름 (변경 불가)
        
        System.out.println("\n=== 상수 값 ===");
        System.out.println("최대 학생 수: " + MAX_STUDENTS + "명");
        System.out.println("학교 이름: " + SCHOOL_NAME);
        
        // 상수는 변경할 수 없습니다 (아래 주석을 해제하면 오류가 발생합니다)
        // MAX_STUDENTS = 50;  // 오류! 상수는 변경할 수 없습니다
    }
}
