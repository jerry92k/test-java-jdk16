package apitest;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamProduceTest {

    public static void main(String[] args){

        StreamProduceTest streamProduceTest = new StreamProduceTest();
        streamProduceTest.arrayToStreamTest();
        streamProduceTest.streamBuilderTest();
        streamProduceTest.streamGenerateTest();
        streamProduceTest.streamIterateTest();
    }

    public void arrayToStreamTest(){
        System.out.println("-- 참조타입(String) 스트림 변환 -- ");
        String[] strs={"abc","def","ghi","jkl"};
        Stream<String> stream= Arrays.stream(strs);
        stream.forEach(System.out::println);

        System.out.println("-- 기본타입(int) 스트림 변환 -- ");
        int[] nums={0,1,2,3};
        IntStream intStream= Arrays.stream(nums);
        intStream.forEach(System.out::println);
    }

    public void streamBuilderTest(){
        System.out.println("-- Stream Builder -- ");
        Stream<String> stream= Stream.<String>builder()
                .add("kim")
                .add("jerry")
                .add("lee")
                .add("park")
                .build();
        String result=stream.collect(Collectors.joining(" | "));
        System.out.println(result);
        System.out.println();
    }

    public void streamGenerateTest(){
        System.out.println("-- Stream generator -- ");
        System.out.println("1. 문자열 생성");
        Stream<String> stream= Stream.generate(()->"element").limit(3);
        String result=stream.collect(Collectors.joining(", "));
        System.out.println(result);
        System.out.println("2. 난수 생성");
        DoubleStream stream2= DoubleStream.generate(()->Math.random()).limit(3);
        stream2.forEach(System.out::println);
        System.out.println();
    }

    public void streamIterateTest(){
        System.out.println("-- Stream Iterator -- ");
        System.out.println("1. 제네릭 스트림 사용");
        Stream<Integer> stream= Stream.iterate(5, val -> val + 5).limit(10);
        OptionalInt sum=stream.mapToInt(Integer::intValue)
                .reduce((acc,val)->acc+val);
        System.out.println(sum.isPresent()?sum.getAsInt() : -1);

        System.out.println("2. primitive int를 다루는 IntStream 사용");
        IntStream primitiveStream = IntStream.iterate(5,val->val+5).limit(10);
        int primitiveSum =primitiveStream.sum();
        System.out.println(primitiveSum);

    }
}
