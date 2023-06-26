package day19.exception;

public class ThrowsEx {

	public static void main(String[] args) throws Exception {
		int num1 = 1, num2 = 0;
		int res;
		int arr[] = {1, 3, 5};
		try {
			arr = null;
			printArray(arr);
		
			//res = mod1(num1, num2);
			res = mod2(num1, num2);
		
			res = mod2(num1, num2);
			System.out.println(res);
		} catch (Exception e) {
			//System.out.println("Exception : / by zero");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

		System.out.println("EXIT");
	}

	//try-catch를 이용해서 예외 직접 처리
	public static int mod1(int num1, int num2) {
		try{
			int res = num1 % num2;
			return res;
		}catch(Exception e) {
			System.out.println("Exception : / by zero");
			return 0;
		}
	}
	
	//throws를 이용해서 예외 처리 미루기
	public static int mod2(int num1, int num2) throws Exception {
		return num1 % num2;
	}
	
	public static void printArray(int arr[]) throws Exception {
		if(arr == null) {
			throw new Exception("Array is null.");
		}
		
		for(int tmp : arr){
			System.out.println(tmp);
		}
	}
}
