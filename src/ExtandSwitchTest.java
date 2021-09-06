// jdk 16 기반으로 테스트

public class ExtandSwitchTest {

    public static void main(String[] args){

        ExtandSwitchTest extandSwitchTest = new ExtandSwitchTest();

        System.out.println("---- without result test ---");
        System.out.println("input name : kim");
        extandSwitchTest.arrowSwitchWithoutResult("kim"); // 기존 switch문과 달리 조건에 해당하는 구문만 실행
        System.out.println("input name : jerry");
        extandSwitchTest.arrowSwitchWithoutResult("jerry"); // 기존 switch문과 달리 조건에 해당하는 구문만 실행

        System.out.println("---- with result test ---");
        System.out.println("input name : lee");
        extandSwitchTest.arrowSwitchWithResult("lee");
        System.out.println("input name : jerry");
        extandSwitchTest.arrowSwitchWithResult("jerry");
        System.out.println("input name : lucy");
        extandSwitchTest.arrowSwitchWithResult("lucy");
    }

    public void arrowSwitchWithoutResult(String name){
        switch (name){
            case "kim" -> System.out.println("name : kim");
            case "lee" -> System.out.println("name : lee");
            case "jerry" -> {
                System.out.println("before yield");
               // yield 0;  // 리턴 받지 않는 경우는 yield 사용하지 않
            }
            default -> System.out.println("not fount");
        }
    }
    public void arrowSwitchWithResult(String name){
       String result= switch (name){
            case "kim" -> "called kim";
            case "lee" -> "called lee";
            case "jerry" -> {
                System.out.println("before yield jerry");
                yield "jerry";
            }
            case "lucy" ->{
                System.out.println("before yield lucy");
                yield "lucy";
              //  System.out.println("after yield lucy"); // unreachable statement. yield 이후에 statement가 있으면 컴파일 오류
            }
            default -> "not found";
        };
        System.out.println("result : "+result);
    }
}

