package apitest;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.regex.MatchResult;
import java.util.stream.Stream;

public class ScannerTest {

    public static void main(String[] args){
        ScannerTest scannerTest = new ScannerTest();
//        scannerTest.scanPathToFileTest();
//        scannerTest.scanFindAllPatStringTest();
//        scannerTest.scanFindWitinHorizonTest();
        scannerTest.scanFindInLine();
    }

    public void scanPathToFileTest(){
        Scanner scanner= null;
        try {
            scanner = new Scanner(Paths.get("./fileoutputtest.txt"));
            while(scanner.hasNext()){
                System.out.println(scanner.next());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            scanner.close();
        }

    }

    public void scanFindAllPatStringTest(){

        try(Scanner scanner= new Scanner(Paths.get("./fileoutputtest.txt"))) {
            // 파일에 없는 패턴을 찾을 경우
            System.out.println("파일에 없는 단어로 매칭 테스트");
            Stream<MatchResult> unMatchedResults=scanner.findAll("thos is");
            System.out.println("matched result size : "+ unMatchedResults.count());

            System.out.println();
            // 파일에 있는 패턴을 찾을 경우
            System.out.println("파일에 있는 단어로 매칭 테스트");
            Stream<MatchResult> matchedResults=scanner.findAll("this is");
            // 매칭 결과 정보로 MatchResult 객체 2개 생성 확인
            matchedResults.forEach(result -> System.out.println(result.toString()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void scanFindWitinHorizonTest(){
        try(Scanner scanner= new Scanner(Paths.get("./fileoutputtest.txt"))) {
            String result=scanner.findWithinHorizon("this is", 7);
            System.out.println(result);
            scanner.next();
            result=scanner.findWithinHorizon("this is", 7);
            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void scanFindInLine(){
        try(Scanner scanner= new Scanner(Paths.get("./fileoutputtest.txt"))) {
            String result=null;
            String result2=null;
            while(scanner.hasNext()){
                result=scanner.findInLine("output");
                System.out.println("find output : " +result);
                result2=scanner.findInLine("writer");
                System.out.println("find writer : " +result2);
                System.out.println();
                scanner.reset();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
