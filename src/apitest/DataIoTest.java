package apitest;

import java.io.*;
import java.nio.charset.Charset;

public class DataIoTest {

    public static void main(String[] args){
        DataIoTest dataIoTest = new DataIoTest();
        String filename="fileoutputtest.txt";
        dataIoTest.fileOutputStreamTest(filename);
        dataIoTest.fileWriterTest(filename);
        dataIoTest.fileInputStreamTest(filename);
        dataIoTest.fileReadTest(filename);
    }

    public void fileOutputStreamTest(String filename){
        String data="this is output Stream test";
        byte[] bytes = data.getBytes();
        try (OutputStream out = new FileOutputStream(filename)) {
            out.write(bytes);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void fileWriterTest(String filename){
        String data="this is writer test";
        try(Writer fileWriter=new FileWriter(filename,true)){
         try(BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)){
             bufferedWriter.newLine();
             bufferedWriter.write(data);
         }
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void fileInputStreamTest(String filename){

        try(InputStream in = new FileInputStream(filename)) {
            byte[] bytes = in.readAllBytes(); // 바이너리 데이터를 그대로 읽어서
            String data = new String(bytes,Charset.defaultCharset()); // 두번째 파라미터로 인코딩 형식을 지정할 수 있음
            System.out.println("inputstream : "+data);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void fileReadTest(String filename){
        try (Reader fileReader=new FileReader(filename)){
            try(BufferedReader br = new BufferedReader(fileReader)){
                String line=null;
                while((line=br.readLine())!=null){
                    System.out.println("Reader : "+line);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
