package day18.homework;

import java.util.Scanner;

public class ImgEx {

	public static void main(String[] args) {
		//파일명 입력받아 파일이 이미지인지 확인하는 코드(이미지 확장자:jpg, bmp, png)
		/* input : dog.jpg
		 * dog.jpg : Image
		 * input : dog.exe
		 * dog.exe : Not Image
		 */
		
		Scanner sc = new Scanner(System.in);
		
		//split : 구분자를 구준으로 문자열 추출 후 순서대로 배열에 저장
		String str = "jpg,bmp,png";
		String imageList[] = str.split(",");
		
		//배열에 저장한 형식이면 Image 출력 
		for(String file : imageList) {
			System.out.println("input : ");
			String image = sc.nextLine();
		//아니라면 Not Image 출력
			while(true) {
				int index = str.indexOf("jpg",4);
				System.out.println(image + " : Image");
				break;
			}
			
		}
		sc.close();
		
	}

}
