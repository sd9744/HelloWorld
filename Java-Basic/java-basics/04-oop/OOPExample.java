/**
 * 객체지향 프로그래밍 종합 예제
 * 
 * 이 클래스는 Person과 Student 클래스를 사용하여 객체지향 프로그래밍의
 * 핵심 개념들을 실제로 구현하고 테스트하는 예제입니다.
 * 
 * 📚 비전공자를 위한 용어 설명:
 * 
 * 🏗️ 클래스(Class): 
 *    - 객체를 만들기 위한 설계도나 틀입니다
 *    - 예: 자동차 설계도 = 클래스, 실제 자동차 = 객체
 *    - Person 클래스는 "사람"이라는 개념을 정의한 설계도입니다
 * 
 * 🎯 객체(Object): 
 *    - 클래스를 바탕으로 실제로 만들어진 구체적인 것입니다
 *    - 예: Person 클래스로 만든 "김철수"라는 실제 사람
 *    - 각 객체는 고유한 속성(이름, 나이 등)과 행동(자기소개 등)을 가집니다
 * 
 * ⚙️ 메서드(Method): 
 *    - 객체가 할 수 있는 행동이나 기능입니다
 *    - 예: introduce() = 자기소개하기, setAge() = 나이 설정하기
 *    - 함수와 비슷하지만 객체에 속해있다는 점이 다릅니다
 */

public class OOPExample {
    
    public static void main(String[] args) {
        
        System.out.println("=== 객체지향 프로그래밍 종합 예제 ===");
        
        // 1. Person 객체 생성 및 사용
        System.out.println("\n=== Person 객체 예제 ===");
        
        // 🎯 객체 생성하기: 클래스에서 실제 객체를 만드는 과정
        // 기본 생성자로 Person 객체 생성
        // new Person() = Person 클래스의 설계도를 바탕으로 새로운 사람 객체를 만듭니다
        Person person1 = new Person();
        // ⚙️ 메서드 호출하기: 객체에게 일을 시키는 과정
        // person1.setName("김철수") = person1 객체에게 이름을 "김철수"로 설정하라고 명령
        person1.setName("김철수");
        person1.setAge(25);
        person1.setEmail("kim@email.com");
        person1.setPhoneNumber("010-1234-5678");
        person1.setAddress("서울시 강남구");
        
        // 매개변수가 있는 생성자로 Person 객체 생성
        Person person2 = new Person("이영희", 30);
        person2.setEmail("lee@email.com");
        person2.setPhoneNumber("010-9876-5432");
        person2.setAddress("부산시 해운대구");
        
        // 모든 정보를 받는 생성자로 Person 객체 생성
        Person person3 = new Person("박민수", 28, "park@email.com", 
                                   "010-5555-1234", "대구시 수성구");
        
        // Person 객체들의 메서드 호출
        person1.introduce();
        person1.showContactInfo();
        System.out.println("성인 여부: " + person1.isAdult());
        System.out.println("나이대: " + person1.getAgeGroup());
        
        System.out.println("\n" + person2.getName() + "의 정보:");
        person2.showContactInfo();
        
        // 두 사람의 나이 차이 계산
        int ageDifference = person1.getAgeDifference(person2);
        System.out.println(person1.getName() + "과 " + person2.getName() + 
                          "의 나이 차이: " + ageDifference + "세");
        
        // 생일 축하
        person1.haveBirthday();
        System.out.println("생일 후 나이: " + person1.getAge() + "세");
        
        // 2. Student 객체 생성 및 사용 (상속 예제)
        System.out.println("\n=== Student 객체 예제 (상속) ===");
        
        // 🔄 상속(Inheritance) 설명:
        // Student 클래스는 Person 클래스를 상속받았습니다
        // 상속 = 부모의 모든 것을 물려받는 것 (이름, 나이, 자기소개 기능 등)
        // + 추가로 학생만의 특성도 가집니다 (학번, 전공, GPA 등)
        
        // 기본 생성자로 Student 객체 생성
        Student student1 = new Student();
        student1.setName("최지영");
        student1.setAge(20);
        student1.setEmail("choi@university.edu");
        student1.setPhoneNumber("010-1111-2222");
        student1.setAddress("서울시 서초구");
        student1.setStudentId("2024001");
        student1.setMajor("컴퓨터공학");
        student1.setGrade(2);
        student1.setGpa(3.8);
        
        // 매개변수가 있는 생성자로 Student 객체 생성
        Student student2 = new Student("정민호", 22, "2024002");
        student2.setEmail("jung@university.edu");
        student2.setPhoneNumber("010-3333-4444");
        student2.setAddress("인천시 연수구");
        student2.setMajor("경영학");
        student2.setGrade(3);
        student2.setGpa(3.2);
        
        // 모든 정보를 받는 생성자로 Student 객체 생성
        Student student3 = new Student("한소영", 21, "han@university.edu", 
                                      "010-7777-8888", "광주시 서구",
                                      "2024003", "심리학", 2, 4.1);
        
        // Student 객체들의 메서드 호출
        System.out.println("\n=== 학생 정보 출력 ===");
        student1.showStudentInfo();
        
        System.out.println("\n=== 학생 자기소개 (오버라이딩) ===");
        // 🔄 오버라이딩(Overriding) 설명:
        // Student 클래스에서 부모(Person)의 introduce() 메서드를 다시 정의했습니다
        // 오버라이딩 = 부모의 기능을 자식이 자신만의 방식으로 다시 만드는 것
        // student1.introduce()를 호출하면 Student 버전의 자기소개가 나옵니다
        student1.introduce(); // 부모 클래스의 메서드를 오버라이딩한 메서드 호출
        
        // 수강과목 관리
        System.out.println("\n=== 수강과목 관리 ===");
        student1.addSubject("자바 프로그래밍");
        student1.addSubject("데이터베이스");
        student1.addSubject("웹 프로그래밍");
        student1.addSubject("알고리즘");
        student1.showSubjects();
        
        student1.removeSubject("데이터베이스");
        student1.showSubjects();
        
        // 학년 진급
        System.out.println("\n=== 학년 진급 ===");
        student1.promoteGrade();
        System.out.println("현재 학년: " + student1.getGrade() + "학년");
        
        // 성적 관련 정보
        System.out.println("\n=== 성적 정보 ===");
        System.out.println(student1.getName() + "의 성적 등급: " + student1.getGradeLevel());
        System.out.println("장학금 대상 여부: " + (student1.isScholarshipEligible() ? "예" : "아니오"));
        
        // 3. 다형성(Polymorphism) 예제
        System.out.println("\n=== 다형성 예제 ===");
        
        // 🔄 다형성(Polymorphism) 설명:
        // 다형성 = 같은 타입이지만 다른 형태로 동작하는 것
        // Person 배열에 Person과 Student 객체들을 모두 저장할 수 있습니다
        // 왜? Student는 Person을 상속받았기 때문입니다 (Student는 Person의 한 종류)
        Person[] people = {person1, person2, person3, student1, student2, student3};
        
        System.out.println("=== 모든 사람들의 자기소개 ===");
        for (Person person : people) {
            person.introduce(); // 각 객체의 타입에 따라 다른 introduce 메서드가 호출됨
            System.out.println("---");
        }
        
        // 4. 객체 비교 예제
        System.out.println("\n=== 객체 비교 예제 ===");
        
        Person person4 = new Person("김철수", 25);
        Person person5 = new Person("김철수", 25);
        
        System.out.println("person1과 person4가 같은가? " + person1.equals(person4));
        System.out.println("person4와 person5가 같은가? " + person4.equals(person5));
        
        // 5. 실용적인 예제 - 학생 관리 시스템 시뮬레이션
        System.out.println("\n=== 학생 관리 시스템 시뮬레이션 ===");
        
        Student[] students = {student1, student2, student3};
        
        // 전체 학생의 평균 GPA 계산
        double totalGpa = 0;
        for (Student student : students) {
            totalGpa += student.getGpa();
        }
        double averageGpa = totalGpa / students.length;
        System.out.println("전체 학생 평균 GPA: " + String.format("%.2f", averageGpa));
        
        // 장학금 대상 학생 찾기
        System.out.println("\n=== 장학금 대상 학생 ===");
        for (Student student : students) {
            if (student.isScholarshipEligible()) {
                System.out.println("- " + student.getName() + " (" + student.getStudentId() + 
                                  ", GPA: " + student.getGpa() + ")");
            }
        }
        
        // 학년별 학생 수 계산
        System.out.println("\n=== 학년별 학생 수 ===");
        int[] gradeCount = new int[5]; // 0~4학년
        for (Student student : students) {
            gradeCount[student.getGrade()]++;
        }
        
        for (int i = 1; i <= 4; i++) {
            System.out.println(i + "학년: " + gradeCount[i] + "명");
        }
        
        // 6. toString 메서드 사용 예제
        System.out.println("\n=== 객체 정보 출력 (toString) ===");
        System.out.println("Person 객체: " + person1);
        System.out.println("Student 객체: " + student1);
        
        System.out.println("\n=== 객체지향 프로그래밍 예제 완료 ===");
    }
}
