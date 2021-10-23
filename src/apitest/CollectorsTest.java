package apitest;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectorsTest {

    public static void main(String[] args){
        CollectorsTest collectorsTest = new CollectorsTest();
        collectorsTest.collectSupplierConsumerTest();
        collectorsTest.collectorsTest();
    }

    public void collectSupplierConsumerTest(){
        StringBuilder sbResult= Stream.<String>builder()
                .add("je")
                .add("r")
                .add("ry")
                .add("st")
                .add("udy")
                .build()
                .collect(StringBuilder::new,
                        (sb, word)->sb.append(word),
                        (sb1,sb2)-> sb1.append(sb2));
        System.out.println(sbResult.toString());
    }

    public void collectorsTest(){
        Stream<String> stream= Arrays.asList("0.342","1.234","12.23","0.23").stream();
        Double avgDouble=stream.collect(Collectors.averagingDouble(val-> Double.valueOf(val)));
        System.out.println("avg Double : "+avgDouble);

        Stream<Integer> stream2=Arrays.asList(1,2,3,4,5,6,7,8,9,10).stream();
        Integer accumulateSum=stream2.collect(Collectors.reducing(0,Integer::intValue,(total, num)->total+num));
        System.out.println("reducing result: "+ accumulateSum);

        Stream<Integer> stream3=Arrays.asList(1,2,3,4,5,6,7,8,9,10).stream();
        Map<Boolean, List<Integer>> collect = stream3.collect(Collectors.partitioningBy(val -> val % 2 == 0));

        for(Map.Entry<Boolean,List<Integer>> entry : collect.entrySet()){
            System.out.println("key : "+ entry.getKey());
            System.out.println("value : "+ entry.getValue());
        }

        Person person1=new Person("jerry",10,new Car(1000,"avante"));
        Person person2=new Person("tom",20,new Car(2000,"audi"));
        Person person3=new Person("ford",30,new Car(3000,"toycar"));
        Person person4=new Person("leli",15,new Car(1000,"avante"));
        Person person5=new Person("amy",40,new Car(5000,"toycar"));
        List<Person> lists=new ArrayList<>();
        lists.add(person1);
        lists.add(person2);
        lists.add(person3);
        lists.add(person4);
        lists.add(person5);

        Map<String,List<Person>> groups = lists.stream().collect(Collectors.groupingBy(person -> person.getCar().getCarName()));
        for(Map.Entry<String,List<Person>> entry : groups.entrySet()){
            System.out.println("key : "+ entry.getKey());
            System.out.println("value : "+ entry.getValue());
        }

    }
}
