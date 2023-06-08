package day7.breakex;

public class HelloWorldEx {

	public static void main(String[] args) {
		
		
		int i = 1;
		while(true) {
			System.out.println("Hello World!");
			
			if( i == 5 ) {
				break;
			 // break문도 반드시 if문과 사용 (continue문도 마찬가지)
			}
			i++;
		}
	}

}
