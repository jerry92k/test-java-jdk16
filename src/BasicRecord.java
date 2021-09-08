public record BasicRecord(
    int id,
    String name,
    int age
){
//    public BasicRecord(int id, String name, int age){
//        if(age<10){
//            throw new IllegalArgumentException("age는 10 이상이어야 합니다.");
//        }
//        this.id=id;
//        this.name=name;
//        this.age=age;
//    }

    public BasicRecord{ // 생성자에 parameter 생략 가능
        if(age<10){
            throw new IllegalArgumentException("age는 10 이상이어야 합니다.");
        }
//        age=10; // 인스턴스 변수에 할당됨.
    }
}
