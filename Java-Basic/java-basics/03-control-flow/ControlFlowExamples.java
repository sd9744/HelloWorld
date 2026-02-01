/**
 * 자바 제어문 학습 예제
 * 
 * 이 파일은 자바의 조건문(if, switch)과 반복문(for, while, do-while)을 학습하기 위한 예제입니다.
 */

public class ControlFlowExamples {
    
    public static void main(String[] args) {
        
        System.out.println("=== 자바 제어문 예제 ===");
        
        // 1. if문 (조건문)
        System.out.println("\n=== if문 예제 ===");
        
        int age = 20;
        
        // 기본 if문
        if (age >= 18) {
            System.out.println("성인입니다.");
        }
        
        // if-else문
        int score = 85;
        if (score >= 60) {
            System.out.println("합격입니다!");
        } else {
            System.out.println("불합격입니다.");
        }
        
        // if-else if-else문 (다중 조건)
        int temperature = 25;
        if (temperature < 0) {
            System.out.println("매우 추워요!");
        } else if (temperature < 10) {
            System.out.println("추워요.");
        } else if (temperature < 20) {
            System.out.println("시원해요.");
        } else if (temperature < 30) {
            System.out.println("따뜻해요.");
        } else {
            System.out.println("더워요!");
        }
        
        // 중첩 if문
        boolean isStudent = true;
        int studentAge = 22;
        
        if (isStudent) {
            if (studentAge >= 20) {
                System.out.println("성인 학생입니다.");
            } else {
                System.out.println("미성년 학생입니다.");
            }
        } else {
            System.out.println("학생이 아닙니다.");
        }
        
        // 2. switch문
        System.out.println("\n=== switch문 예제 ===");
        
        int dayOfWeek = 3;
        String dayName;
        
        switch (dayOfWeek) {
            case 1:
                dayName = "월요일";
                break;
            case 2:
                dayName = "화요일";
                break;
            case 3:
                dayName = "수요일";
                break;
            case 4:
                dayName = "목요일";
                break;
            case 5:
                dayName = "금요일";
                break;
            case 6:
                dayName = "토요일";
                break;
            case 7:
                dayName = "일요일";
                break;
            default:
                dayName = "잘못된 요일";
                break;
        }
        System.out.println("오늘은 " + dayName + "입니다.");
        
        // Java 14+ 스위치 표현식 (더 간결한 문법)
        String season = switch (dayOfWeek) {
            case 12, 1, 2 -> "겨울";
            case 3, 4, 5 -> "봄";
            case 6, 7, 8 -> "여름";
            case 9, 10, 11 -> "가을";
            default -> "알 수 없음";
        };
        System.out.println("계절: " + season);
        
        // 3. for문 (반복문)
        System.out.println("\n=== for문 예제 ===");
        
        // 기본 for문: 1부터 5까지 출력
        System.out.println("1부터 5까지:");
        for (int i = 1; i <= 5; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        
        // 역순 for문: 5부터 1까지 출력
        System.out.println("5부터 1까지:");
        for (int i = 5; i >= 1; i--) {
            System.out.print(i + " ");
        }
        System.out.println();
        
        // 2씩 증가하는 for문
        System.out.println("짝수 출력 (2씩 증가):");
        for (int i = 2; i <= 10; i += 2) {
            System.out.print(i + " ");
        }
        System.out.println();
        
        // 중첩 for문 (구구단)
        System.out.println("\n구구단 2단:");
        for (int i = 1; i <= 9; i++) {
            System.out.println("2 × " + i + " = " + (2 * i));
        }
        
        // 4. while문
        System.out.println("\n=== while문 예제 ===");
        
        // 기본 while문
        int count = 1;
        System.out.println("while문으로 1부터 5까지:");
        while (count <= 5) {
            System.out.print(count + " ");
            count++;  // count를 1씩 증가
        }
        System.out.println();
        
        // 사용자 입력을 받는 것처럼 시뮬레이션
        int userInput = 7;  // 가상의 사용자 입력
        int sum = 0;
        int number = 1;
        
        System.out.println("1부터 " + userInput + "까지의 합:");
        while (number <= userInput) {
            sum += number;
            number++;
        }
        System.out.println("합계: " + sum);
        
        // 5. do-while문
        System.out.println("\n=== do-while문 예제 ===");
        
        // do-while문은 최소 한 번은 실행됨
        int x = 10;
        System.out.println("do-while문 실행:");
        do {
            System.out.println("x = " + x);
            x++;
        } while (x < 5);  // 조건이 false이지만 한 번은 실행됨
        
        // 6. break와 continue
        System.out.println("\n=== break와 continue 예제 ===");
        
        // break: 반복문을 완전히 종료
        System.out.println("break 예제 (5에서 종료):");
        for (int i = 1; i <= 10; i++) {
            if (i == 6) {
                break;  // i가 6이 되면 반복문 종료
            }
            System.out.print(i + " ");
        }
        System.out.println();
        
        // continue: 현재 반복을 건너뛰고 다음 반복으로
        System.out.println("continue 예제 (3과 7 건너뛰기):");
        for (int i = 1; i <= 10; i++) {
            if (i == 3 || i == 7) {
                continue;  // 3과 7은 건너뛰고 다음 반복으로
            }
            System.out.print(i + " ");
        }
        System.out.println();
        
        // 7. 실용적인 예제들
        System.out.println("\n=== 실용적인 예제 ===");
        
        // 배열의 최댓값 찾기
        int[] numbers = {3, 7, 2, 9, 1, 5};
        int max = numbers[0];  // 첫 번째 원소를 최댓값으로 초기화
        
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] > max) {
                max = numbers[i];
            }
        }
        System.out.println("배열의 최댓값: " + max);
        
        // 소수 판별
        int testNumber = 17;
        boolean isPrime = true;
        
        if (testNumber <= 1) {
            isPrime = false;
        } else {
            for (int i = 2; i <= Math.sqrt(testNumber); i++) {
                if (testNumber % i == 0) {
                    isPrime = false;
                    break;
                }
            }
        }
        
        System.out.println(testNumber + "은(는) " + (isPrime ? "소수" : "소수가 아님") + "입니다.");
        
        // 팩토리얼 계산
        int n = 5;
        int factorial = 1;
        
        for (int i = 1; i <= n; i++) {
            factorial *= i;
        }
        System.out.println(n + "! = " + factorial);
        
        // 피보나치 수열
        System.out.println("피보나치 수열 (처음 10개):");
        int a = 0, b = 1;
        System.out.print(a + " " + b + " ");
        
        for (int i = 2; i < 10; i++) {
            int next = a + b;
            System.out.print(next + " ");
            a = b;
            b = next;
        }
        System.out.println();
    }
}
