package test4.io;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterTest {
	public static void main(String[] args) {
		try(FileWriter out = new FileWriter("c:\\temp\\test.txt")) {//auto-closable
			String data = "hello";
			out.write(data);
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
}
