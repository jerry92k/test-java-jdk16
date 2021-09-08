package jigsaw.person;

import jigsaw.car.Car;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Optional;
import java.util.Spliterator;
import java.util.function.*;
import java.util.stream.*;
//import jigsaw.car.notexported.PrivateCar;
/* com.jigsawtest1 모듈에 exports 되어있지 않은 패키지이므로 import해도 오류발생
Package 'jigsaw.car.notexported' is declared in module 'com.jigsawtest1',
 which does not export it to module 'org.jigsawtest2' */

public class jigsawTest {

    public static void main(String[] args){
        Car car=new Car(10000,"super car");
        System.out.println(car);
        Person person=new Person("jerry",30,car);
        person.car.changeCarName("bmw");
        System.out.println(car);

       // PrivateCar privateCar = new PrivateCar(10000,"super car");
    }
}
