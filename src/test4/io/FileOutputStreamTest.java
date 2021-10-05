package test4.io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamTest {
	public static void main(String[] args) {
		try(FileOutputStream out = new FileOutputStream("c:\\temp\\test.txt")) {//auto-closable
			String data = "hello";
			byte[] b = data.getBytes(); 
			out.write(b);
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
}
