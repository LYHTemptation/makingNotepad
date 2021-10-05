package test4.io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderTest {
	public static void main(String[] args) {
		try(BufferedReader in = new BufferedReader(new FileReader("c:\\temp\\main.txt"))) {
			String oneLine = "";
			while((oneLine =in.readLine())!=null) {
				System.out.println(oneLine);
			}
			System.out.println(oneLine);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
