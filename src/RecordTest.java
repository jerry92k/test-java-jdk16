public final class RecordTest {

    public static void main(String[] args){
//        BasicRecord basicRecord1 = new BasicRecord(1,"jerry",51);
//        System.out.println(basicRecord1);
        BasicRecord basicRecord2 = new BasicRecord(2,"kim",30);
        System.out.println(basicRecord2);
        BasicRecord basicRecord3 =new BasicRecord(2,"kim",30);

        System.out.println("name is "+ basicRecord2.name());
        System.out.println("hashcode test : "+ basicRecord2.hashCode());
        System.out.println("equals test :"+ basicRecord2.equals(basicRecord3));

    }
}
