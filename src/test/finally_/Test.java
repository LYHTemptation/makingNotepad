package test.finally_;

public class Test {
	public static void main(String[] args) {
		try {
			char a = args[0].charAt(0);
			System.out.println(a);
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("argument�� �־��ּ���");
		}finally {
			System.out.println("�߿��� ��1");
		}
		System.out.println("�߿��� ��2");				
	}
}
