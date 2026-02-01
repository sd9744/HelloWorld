/**
 * 자바 연산자 학습 예제
 * 
 * 이 파일은 자바의 다양한 연산자들을 학습하기 위한 예제입니다.
 * 산술, 비교, 논리 연산자 등을 포함합니다.
 */

public class OperatorExamples {
    
    public static void main(String[] args) {
        
        System.out.println("=== 자바 연산자 예제 ===");
        
        // 1. 산술 연산자 (Arithmetic Operators)
        System.out.println("\n=== 산술 연산자 ===");
        
        int a = 10;
        int b = 3;
        
        System.out.println("a = " + a + ", b = " + b);
        System.out.println("덧셈 (a + b): " + (a + b));  // 13
        System.out.println("뺄셈 (a - b): " + (a - b));  // 7
        System.out.println("곱셈 (a * b): " + (a * b));  // 30
        System.out.println("나눗셈 (a / b): " + (a / b));  // 3 (정수 나눗셈)
        System.out.println("나머지 (a % b): " + (a % b));  // 1
        
        // 실수 나눗셈
        double x = 10.0;
        double y = 3.0;
        System.out.println("실수 나눗셈 (x / y): " + (x / y));  // 3.333...
        
        // 2. 증감 연산자 (Increment/Decrement Operators)
        System.out.println("\n=== 증감 연산자 ===");
        
        int count = 5;
        System.out.println("초기값: " + count);
        
        // 전위 증가 (++변수): 값을 먼저 증가시키고 사용
        System.out.println("전위 증가 (++count): " + (++count));  // 6
        System.out.println("증가 후 count: " + count);  // 6
        
        // 후위 증가 (변수++): 값을 먼저 사용하고 나중에 증가
        System.out.println("후위 증가 (count++): " + (count++));  // 6
        System.out.println("증가 후 count: " + count);  // 7
        
        // 전위 감소 (--변수): 값을 먼저 감소시키고 사용
        System.out.println("전위 감소 (--count): " + (--count));  // 6
        System.out.println("감소 후 count: " + count);  // 6
        
        // 후위 감소 (변수--): 값을 먼저 사용하고 나중에 감소
        System.out.println("후위 감소 (count--): " + (count--));  // 6
        System.out.println("감소 후 count: " + count);  // 5
        
        // 3. 비교 연산자 (Comparison Operators)
        System.out.println("\n=== 비교 연산자 ===");
        
        int num1 = 10;
        int num2 = 20;
        
        System.out.println("num1 = " + num1 + ", num2 = " + num2);
        System.out.println("같다 (num1 == num2): " + (num1 == num2));  // false
        System.out.println("다르다 (num1 != num2): " + (num1 != num2));  // true
        System.out.println("크다 (num1 > num2): " + (num1 > num2));  // false
        System.out.println("작다 (num1 < num2): " + (num1 < num2));  // true
        System.out.println("크거나 같다 (num1 >= num2): " + (num1 >= num2));  // false
        System.out.println("작거나 같다 (num1 <= num2): " + (num1 <= num2));  // true
        
        // 4. 논리 연산자 (Logical Operators)
        System.out.println("\n=== 논리 연산자 ===");
        
        boolean isStudent = true;
        boolean hasJob = false;
        
        System.out.println("isStudent = " + isStudent + ", hasJob = " + hasJob);
        
        // AND 연산자 (&&): 둘 다 true여야 true
        System.out.println("AND (isStudent && hasJob): " + (isStudent && hasJob));  // false
        
        // OR 연산자 (||): 하나라도 true이면 true
        System.out.println("OR (isStudent || hasJob): " + (isStudent || hasJob));  // true
        
        // NOT 연산자 (!): true를 false로, false를 true로
        System.out.println("NOT (!isStudent): " + (!isStudent));  // false
        System.out.println("NOT (!hasJob): " + (!hasJob));  // true
        
        // 5. 할당 연산자 (Assignment Operators)
        System.out.println("\n=== 할당 연산자 ===");
        
        int value = 10;
        System.out.println("초기값: " + value);
        
        value += 5;  // value = value + 5와 같음
        System.out.println("+= 5 후: " + value);  // 15
        
        value -= 3;  // value = value - 3과 같음
        System.out.println("-= 3 후: " + value);  // 12
        
        value *= 2;  // value = value * 2와 같음
        System.out.println("*= 2 후: " + value);  // 24
        
        value /= 4;  // value = value / 4와 같음
        System.out.println("/= 4 후: " + value);  // 6
        
        value %= 5;  // value = value % 5와 같음
        System.out.println("%= 5 후: " + value);  // 1
        
        // 6. 삼항 연산자 (Ternary Operator)
        System.out.println("\n=== 삼항 연산자 ===");
        
        int score = 85;
        // 조건 ? 참일때값 : 거짓일때값
        String result = (score >= 80) ? "합격" : "불합격";
        System.out.println("점수 " + score + "점은 " + result);
        
        int max = (num1 > num2) ? num1 : num2;
        System.out.println(num1 + "과 " + num2 + " 중 큰 값: " + max);
        
        // 7. 연산자 우선순위 예제
        System.out.println("\n=== 연산자 우선순위 ===");
        
        int result1 = 2 + 3 * 4;  // 곱셈이 먼저 계산됨: 2 + 12 = 14
        int result2 = (2 + 3) * 4;  // 괄호가 먼저 계산됨: 5 * 4 = 20
        
        System.out.println("2 + 3 * 4 = " + result1);
        System.out.println("(2 + 3) * 4 = " + result2);
        
        // 8. 실용적인 예제들
        System.out.println("\n=== 실용적인 예제 ===");
        
        // 나이에 따른 할인율 계산
        int age = 25;
        double discount = (age < 20) ? 0.1 : (age >= 65) ? 0.2 : 0.0;
        System.out.println("나이 " + age + "세의 할인율: " + (discount * 100) + "%");
        
        // 짝수/홀수 판별
        int number = 7;
        String evenOdd = (number % 2 == 0) ? "짝수" : "홀수";
        System.out.println(number + "은(는) " + evenOdd + "입니다.");
        
        // 성적 등급 계산
        int grade = 92;
        String gradeLetter = (grade >= 90) ? "A" : 
                           (grade >= 80) ? "B" : 
                           (grade >= 70) ? "C" : 
                           (grade >= 60) ? "D" : "F";
        System.out.println("점수 " + grade + "점의 등급: " + gradeLetter);
    }
}
