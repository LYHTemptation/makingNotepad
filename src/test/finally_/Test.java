package test.finally_;

public class Test {
	public static void main(String[] args) {
		try {
			char a = args[0].charAt(0);
			System.out.println(a);
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("argument를 넣어주세요");
		}finally {
			System.out.println("중요한 일1");
		}
		System.out.println("중요한 일2");				
	}
}
