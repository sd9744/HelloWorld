/**
 * 상속(Inheritance) 학습 예제 - Student 클래스
 * 
 * 이 클래스는 Person 클래스를 상속받아 학생의 특성을 추가한 예제입니다.
 * 상속, 오버라이딩, super 키워드 등의 개념을 학습할 수 있습니다.
 * 
 * 📚 비전공자를 위한 상속 설명:
 * 
 * 🔄 상속(Inheritance):
 *    - Student extends Person = Student 클래스가 Person 클래스를 상속받는다는 의미
 *    - 상속 = 부모의 모든 것을 물려받는 것 (이름, 나이, 자기소개 기능 등)
 *    - + 추가로 학생만의 특성도 가집니다 (학번, 전공, GPA 등)
 *    - 예: 아버지의 성격을 물려받으면서도 자신만의 특성을 가지는 것과 같습니다
 * 
 * 🔄 오버라이딩(Overriding):
 *    - 부모 클래스의 메서드를 자식 클래스에서 다시 정의하는 것
 *    - 예: Person의 introduce()는 "안녕하세요! 제 이름은..." 이지만
 *          Student의 introduce()는 "안녕하세요! 저는... 학번은..." 으로 다릅니다
 * 
 * 🔑 super 키워드:
 *    - 부모 클래스를 가리키는 키워드입니다
 *    - super() = 부모 클래스의 생성자 호출
 *    - super.메서드명() = 부모 클래스의 메서드 호출
 */

public class Student extends Person {
    
    // Student 클래스만의 고유한 필드들
    // 🎓 학생만의 특성: Person 클래스에는 없고 Student 클래스에만 있는 속성들입니다
    // Person의 필드들(이름, 나이, 이메일 등)은 자동으로 상속받아 사용할 수 있습니다
    private String studentId;      // 학번 - 학생의 고유 번호
    private String major;          // 전공 - 학생이 전공하는 학과
    private int grade;             // 학년 - 1학년, 2학년, 3학년, 4학년
    private double gpa;            // 평점평균 - 학점 평균 (0.0 ~ 4.5)
    private String[] subjects;     // 수강과목들 - 현재 수강하고 있는 과목들의 목록
    
    // 기본 생성자
    public Student() {
        // 🔑 super() 설명: 부모 클래스(Person)의 기본 생성자를 먼저 호출합니다
        // 왜? Student는 Person을 상속받았으므로 Person의 초기화가 먼저 필요합니다
        super(); // 부모 클래스(Person)의 기본 생성자 호출
        
        // 그 다음에 Student만의 필드들을 초기화합니다
        this.studentId = "학번 없음";
        this.major = "전공 없음";
        this.grade = 1;
        this.gpa = 0.0;
        this.subjects = new String[0];
        System.out.println("기본 생성자로 Student 객체가 생성되었습니다.");
    }
    
    // 이름, 나이, 학번을 받는 생성자
    public Student(String name, int age, String studentId) {
        super(name, age); // 부모 클래스의 생성자 호출
        this.studentId = studentId;
        this.major = "전공 없음";
        this.grade = 1;
        this.gpa = 0.0;
        this.subjects = new String[0];
        System.out.println("학생 " + name + " (학번: " + studentId + ") 객체가 생성되었습니다.");
    }
    
    // 모든 정보를 받는 생성자
    public Student(String name, int age, String email, String phoneNumber, String address,
                   String studentId, String major, int grade, double gpa) {
        super(name, age, email, phoneNumber, address); // 부모 클래스의 생성자 호출
        this.studentId = studentId;
        this.major = major;
        this.grade = grade;
        this.gpa = gpa;
        this.subjects = new String[0];
        System.out.println("모든 정보로 Student 객체가 생성되었습니다.");
    }
    
    // Getter 메서드들
    public String getStudentId() {
        return studentId;
    }
    
    public String getMajor() {
        return major;
    }
    
    public int getGrade() {
        return grade;
    }
    
    public double getGpa() {
        return gpa;
    }
    
    public String[] getSubjects() {
        return subjects;
    }
    
    // Setter 메서드들
    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }
    
    public void setMajor(String major) {
        this.major = major;
    }
    
    public void setGrade(int grade) {
        if (grade >= 1 && grade <= 4) {
            this.grade = grade;
        } else {
            System.out.println("학년은 1학년부터 4학년까지 가능합니다.");
        }
    }
    
    public void setGpa(double gpa) {
        if (gpa >= 0.0 && gpa <= 4.5) {
            this.gpa = gpa;
        } else {
            System.out.println("GPA는 0.0부터 4.5까지 가능합니다.");
        }
    }
    
    public void setSubjects(String[] subjects) {
        this.subjects = subjects;
    }
    
    // Student 클래스만의 고유한 메서드들
    
    /**
     * 수강과목을 추가하는 메서드
     * @param subject 추가할 과목명
     */
    public void addSubject(String subject) {
        // 기존 배열보다 크기가 1 큰 새 배열 생성
        String[] newSubjects = new String[subjects.length + 1];
        
        // 기존 과목들을 새 배열에 복사
        for (int i = 0; i < subjects.length; i++) {
            newSubjects[i] = subjects[i];
        }
        
        // 새 과목을 마지막에 추가
        newSubjects[subjects.length] = subject;
        
        // subjects 배열을 새 배열로 교체
        subjects = newSubjects;
        
        System.out.println(subject + " 과목이 추가되었습니다.");
    }
    
    /**
     * 수강과목을 제거하는 메서드
     * @param subject 제거할 과목명
     */
    public void removeSubject(String subject) {
        boolean found = false;
        String[] newSubjects = new String[subjects.length - 1];
        int newIndex = 0;
        
        for (int i = 0; i < subjects.length; i++) {
            if (subjects[i].equals(subject)) {
                found = true;
            } else {
                newSubjects[newIndex] = subjects[i];
                newIndex++;
            }
        }
        
        if (found) {
            subjects = newSubjects;
            System.out.println(subject + " 과목이 제거되었습니다.");
        } else {
            System.out.println(subject + " 과목을 찾을 수 없습니다.");
        }
    }
    
    /**
     * 수강과목 목록을 출력하는 메서드
     */
    public void showSubjects() {
        System.out.println("=== 수강과목 목록 ===");
        if (subjects.length == 0) {
            System.out.println("수강중인 과목이 없습니다.");
        } else {
            for (int i = 0; i < subjects.length; i++) {
                System.out.println((i + 1) + ". " + subjects[i]);
            }
        }
    }
    
    /**
     * 학년을 올리는 메서드
     */
    public void promoteGrade() {
        if (grade < 4) {
            grade++;
            System.out.println(getName() + "이(가) " + grade + "학년으로 진급했습니다!");
        } else {
            System.out.println(getName() + "은(는) 이미 최고 학년입니다.");
        }
    }
    
    /**
     * 성적 등급을 반환하는 메서드
     * @return 성적 등급 문자열
     */
    public String getGradeLevel() {
        if (gpa >= 4.0) {
            return "A+";
        } else if (gpa >= 3.5) {
            return "A";
        } else if (gpa >= 3.0) {
            return "B+";
        } else if (gpa >= 2.5) {
            return "B";
        } else if (gpa >= 2.0) {
            return "C+";
        } else if (gpa >= 1.5) {
            return "C";
        } else if (gpa >= 1.0) {
            return "D+";
        } else {
            return "F";
        }
    }
    
    /**
     * 장학금 대상 여부를 확인하는 메서드
     * @return 장학금 대상이면 true, 아니면 false
     */
    public boolean isScholarshipEligible() {
        return gpa >= 3.5;
    }
    
    // 부모 클래스의 메서드를 오버라이딩 (재정의)
    
    /**
     * 부모 클래스의 introduce 메서드를 오버라이딩
     * 학생의 특성을 반영한 자기소개
     * 
     * 🔄 오버라이딩 설명:
     * - Person 클래스의 introduce() 메서드를 Student 버전으로 다시 정의했습니다
     * - @Override 어노테이션: 이 메서드가 부모 클래스의 메서드를 오버라이딩한다는 표시
     * - Student 객체가 introduce()를 호출하면 이 버전이 실행됩니다
     * - Person 객체가 introduce()를 호출하면 부모 버전이 실행됩니다
     */
    @Override
    public void introduce() {
        System.out.println("안녕하세요! 저는 " + getName() + "이고, " + getAge() + "세입니다.");
        System.out.println("학번은 " + studentId + "이고, " + major + " 전공 " + grade + "학년입니다.");
        System.out.println("현재 GPA는 " + gpa + " (" + getGradeLevel() + ")입니다.");
    }
    
    /**
     * 부모 클래스의 toString 메서드를 오버라이딩
     * 학생의 모든 정보를 포함한 문자열 반환
     */
    @Override
    public String toString() {
        return "Student{" +
                "name='" + getName() + '\'' +
                ", age=" + getAge() +
                ", email='" + getEmail() + '\'' +
                ", phoneNumber='" + getPhoneNumber() + '\'' +
                ", address='" + getAddress() + '\'' +
                ", studentId='" + studentId + '\'' +
                ", major='" + major + '\'' +
                ", grade=" + grade +
                ", gpa=" + gpa +
                '}';
    }
    
    /**
     * 학생 정보를 상세히 출력하는 메서드
     */
    public void showStudentInfo() {
        System.out.println("=== 학생 정보 ===");
        System.out.println("이름: " + getName());
        System.out.println("나이: " + getAge() + "세");
        System.out.println("학번: " + studentId);
        System.out.println("전공: " + major);
        System.out.println("학년: " + grade + "학년");
        System.out.println("GPA: " + gpa + " (" + getGradeLevel() + ")");
        System.out.println("장학금 대상: " + (isScholarshipEligible() ? "예" : "아니오"));
        System.out.println("이메일: " + getEmail());
        System.out.println("전화번호: " + getPhoneNumber());
        System.out.println("주소: " + getAddress());
        showSubjects();
    }
}
