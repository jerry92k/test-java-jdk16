import java.util.*;
import java.util.stream.Collectors;

public class StreamTest {

    ArrayList<String> names=new ArrayList<>(Arrays.asList("kim","lee","park","choi","jung","ku","yoon"));
    ArrayList<Integer> nums=new ArrayList<>(Arrays.asList(1,2,9,11,4,3,55,1,2));
    ArrayList<Car> cars=new ArrayList<>(Arrays.asList(new Car(1000,"아반떼")
            ,new Car(2000,"쏘나타")
            ,new Car(3000,"벤츠")
            ,new Car(4000,"아우디")));
    ArrayList<ArrayList<String>> twoDimensionNames=new ArrayList<>(Arrays.asList(new ArrayList<>(Arrays.asList("gang","do","jerry","lucy","tom"))
                                                                        ,new ArrayList<>(Arrays.asList("kim","lee","park","choi","jung","ku","yoon"))));

    public static void main(String[] args){
        StreamTest streamTest = new StreamTest();
       // streamTest.collectTest();
        //streamTest.filterTest();
//        streamTest.mapTest();
        streamTest.flatMapTest();
    }

    public void collectTest(){
        System.out.println("----collectTest Start----");

        // 예시1 : List 형태로 반환
        List<String> results=names.stream().collect(Collectors.toList());
        System.out.println(results);

        // 예시2 : Charsequence나 String을 joining 하여 하나의 String으로 반환
        String str=names.stream().collect(Collectors.joining());
        System.out.println(str);

        // 예시 3 : Set 형태로 반환

        Set<Car> results2=cars.stream().collect(Collectors.toSet());
        System.out.println(results2);

        System.out.println("----collectTest End----");
        System.out.println();


    }

    public void filterTest(){
        System.out.println("----filterTest Start----");

        // 예시1
        List<String> results=names.stream().filter(name-> name.equals("kim")).collect(Collectors.toList());
        System.out.println(results);

        // 예시2
        List<Integer> results2= nums.stream().filter(num->num>10).collect(Collectors.toList());
        System.out.println(results2);
        System.out.println("----filterTest End----");
    }

    public void mapTest(){
        System.out.println("----mapTest Start----");

        // 예시1
        List<String> results=names.stream().map(name-> name+"_added").collect(Collectors.toList());
        System.out.println(results);

        // 예시2
        List<Integer> results2= nums.stream().map(num-> num+100).collect(Collectors.toList());
        System.out.println(results2);

        // 예시3
        List<Car> results3= cars.stream().map(car-> {
            car.setCarName("changed car"+car.getCarName());
            return car;
        }).collect(Collectors.toList());
        System.out.println(results3);

        System.out.println("----mapTest End----");
    }

    public void flatMapTest(){
        System.out.println("---flatMapTest Start----");

        // map 예시 : List 안에 List가 있는 객체의 경우, map을 사용하면 내부 List는 Stream으로 직렬화 하지않고 객체 그 자체로 사용함
        List<String> results=twoDimensionNames.stream()
                .map(name-> name+"_added")
                .collect(Collectors.toList());
        System.out.println(results);

        // flatMap 예시 : flatMap을 이용하면 내부 List도 Stream으로 직렬화
        List<String> results2=twoDimensionNames.stream()
                .flatMap(names-> names.stream())
                .map(name->name+"_+")
                .collect(Collectors.toList());
        System.out.println(results2);
//
//        System.out.println(results3);

        System.out.println("----flatMapTest End----");
    }

    public void distinctTest(){

    }
}
