/**
 * 객체지향 프로그래밍 학습 예제 - Person 클래스
 * 
 * 이 클래스는 객체지향 프로그래밍의 핵심 개념들을 학습하기 위한 예제입니다.
 * 클래스, 객체, 캡슐화, 생성자, 메서드 등의 개념을 포함합니다.
 * 
 * 📚 비전공자를 위한 상세 설명:
 * 
 * 🏗️ 클래스(Class): 
 *    - Person 클래스는 "사람"이라는 개념을 정의한 설계도입니다
 *    - 모든 사람이 공통으로 가져야 할 속성(이름, 나이 등)과 행동(자기소개 등)을 정의합니다
 * 
 * 🔒 캡슐화(Encapsulation):
 *    - private 필드: 외부에서 직접 접근할 수 없도록 보호합니다
 *    - public 메서드: 안전한 방법으로 데이터에 접근할 수 있게 합니다
 *    - 예: 나이를 직접 바꾸는 대신 setAge() 메서드를 통해 유효성 검사와 함께 설정합니다
 * 
 * 🏭 생성자(Constructor):
 *    - 객체를 만들 때 자동으로 호출되는 특별한 메서드입니다
 *    - 객체의 초기 상태를 설정하는 역할을 합니다
 *    - 여러 개의 생성자를 만들어 다양한 방법으로 객체를 생성할 수 있습니다
 * 
 * ⚙️ 메서드(Method):
 *    - 객체가 할 수 있는 행동이나 기능을 정의합니다
 *    - Getter: 데이터를 읽어오는 메서드 (getName, getAge 등)
 *    - Setter: 데이터를 설정하는 메서드 (setName, setAge 등)
 *    - 비즈니스 메서드: 실제 기능을 수행하는 메서드 (introduce, isAdult 등)
 */

public class Person {
    
    // 1. 필드 (Field) - 객체의 속성/상태를 나타냄
    // 🔒 캡슐화 설명: private 키워드로 외부에서 직접 접근할 수 없도록 보호
    // 왜 private을 사용하나요? 데이터를 안전하게 보호하고 유효성 검사를 할 수 있기 때문입니다
    private String name;        // 이름 - 사람의 이름을 저장하는 변수
    private int age;            // 나이 - 사람의 나이를 저장하는 변수
    private String email;       // 이메일 - 사람의 이메일 주소를 저장하는 변수
    private String phoneNumber; // 전화번호 - 사람의 전화번호를 저장하는 변수
    private String address;     // 주소 - 사람의 주소를 저장하는 변수
    
    // 2. 생성자 (Constructor) - 객체를 생성할 때 호출되는 특별한 메서드
    // 🏭 생성자 설명: new Person()을 호출할 때 자동으로 실행되는 메서드입니다
    // 기본 생성자 (매개변수가 없는 생성자)
    public Person() {
        // 기본값으로 초기화 - 객체가 생성될 때 기본값들을 설정합니다
        this.name = "이름 없음";        // this.name = 이 객체의 name 필드를 의미
        this.age = 0;                   // this.age = 이 객체의 age 필드를 의미
        this.email = "이메일 없음";
        this.phoneNumber = "전화번호 없음";
        this.address = "주소 없음";
        System.out.println("기본 생성자로 Person 객체가 생성되었습니다.");
    }
    
    // 매개변수가 있는 생성자 (이름과 나이만 받는 생성자)
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        this.email = "이메일 없음";
        this.phoneNumber = "전화번호 없음";
        this.address = "주소 없음";
        System.out.println("이름: " + name + ", 나이: " + age + "로 Person 객체가 생성되었습니다.");
    }
    
    // 모든 정보를 받는 생성자
    public Person(String name, int age, String email, String phoneNumber, String address) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        System.out.println("모든 정보로 Person 객체가 생성되었습니다.");
    }
    
    // 3. Getter 메서드 - private 필드의 값을 읽어오는 메서드
    // 📖 Getter 설명: private 필드의 값을 안전하게 읽어오는 메서드입니다
    // 외부에서 person.getName()으로 호출하면 이 객체의 name 값을 반환합니다
    public String getName() {
        return name;  // 이 객체의 name 필드 값을 반환
    }
    
    public int getAge() {
        return age;
    }
    
    public String getEmail() {
        return email;
    }
    
    public String getPhoneNumber() {
        return phoneNumber;
    }
    
    public String getAddress() {
        return address;
    }
    
    // 4. Setter 메서드 - private 필드의 값을 설정하는 메서드
    // ✏️ Setter 설명: private 필드의 값을 안전하게 설정하는 메서드입니다
    // 유효성 검사를 통해 잘못된 값이 들어오는 것을 방지합니다
    public void setName(String name) {
        // 유효성 검사 - 입력된 값이 올바른지 확인합니다
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;  // 올바른 값이면 설정합니다
        } else {
            System.out.println("이름은 비어있을 수 없습니다.");  // 잘못된 값이면 경고 메시지
        }
    }
    
    public void setAge(int age) {
        // 유효성 검사
        if (age >= 0 && age <= 150) {
            this.age = age;
        } else {
            System.out.println("나이는 0세부터 150세까지 가능합니다.");
        }
    }
    
    public void setEmail(String email) {
        // 간단한 이메일 유효성 검사
        if (email != null && email.contains("@")) {
            this.email = email;
        } else {
            System.out.println("올바른 이메일 형식이 아닙니다.");
        }
    }
    
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
    
    // 5. 비즈니스 메서드 - 객체의 행동/기능을 나타냄
    // ⚙️ 비즈니스 메서드 설명: 객체가 실제로 할 수 있는 기능들을 정의합니다
    // Getter/Setter와 달리 실제 비즈니스 로직을 수행하는 메서드들입니다
    
    /**
     * 자기소개를 하는 메서드
     * 이 메서드를 호출하면 이 사람의 이름과 나이를 포함한 자기소개가 출력됩니다
     */
    public void introduce() {
        System.out.println("안녕하세요! 제 이름은 " + name + "이고, " + age + "세입니다.");
    }
    
    /**
     * 연락처 정보를 출력하는 메서드
     */
    public void showContactInfo() {
        System.out.println("=== 연락처 정보 ===");
        System.out.println("이름: " + name);
        System.out.println("이메일: " + email);
        System.out.println("전화번호: " + phoneNumber);
        System.out.println("주소: " + address);
    }
    
    /**
     * 나이를 한 살씩 증가시키는 메서드
     */
    public void haveBirthday() {
        age++;
        System.out.println(name + "의 생일! 이제 " + age + "세가 되었습니다.");
    }
    
    /**
     * 성인 여부를 확인하는 메서드
     * @return 성인이면 true, 미성년이면 false
     */
    public boolean isAdult() {
        return age >= 18;
    }
    
    /**
     * 나이대를 반환하는 메서드
     * @return 나이대 문자열
     */
    public String getAgeGroup() {
        if (age < 13) {
            return "어린이";
        } else if (age < 20) {
            return "청소년";
        } else if (age < 30) {
            return "20대";
        } else if (age < 40) {
            return "30대";
        } else if (age < 50) {
            return "40대";
        } else if (age < 60) {
            return "50대";
        } else {
            return "60대 이상";
        }
    }
    
    /**
     * 두 사람의 나이 차이를 계산하는 메서드
     * @param other 다른 Person 객체
     * @return 나이 차이 (절댓값)
     */
    public int getAgeDifference(Person other) {
        return Math.abs(this.age - other.age);
    }
    
    /**
     * 모든 정보를 문자열로 반환하는 메서드 (toString 오버라이드)
     * @return 사람의 모든 정보가 담긴 문자열
     */
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
    
    /**
     * 두 Person 객체가 같은지 비교하는 메서드 (equals 오버라이드)
     * @param obj 비교할 객체
     * @return 같으면 true, 다르면 false
     */
    @Override
    public boolean equals(Object obj) {
        // 같은 객체인지 확인
        if (this == obj) return true;
        
        // null이거나 다른 클래스인지 확인
        if (obj == null || getClass() != obj.getClass()) return false;
        
        // Person으로 캐스팅
        Person person = (Person) obj;
        
        // 이름과 나이가 같으면 같은 사람으로 간주
        return age == person.age && 
               (name != null ? name.equals(person.name) : person.name == null);
    }
}
