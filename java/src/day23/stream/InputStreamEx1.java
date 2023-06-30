package day23.stream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class InputStreamEx1 {

	public static void main(String[] args) {
		
		FileInputStream fis = null;
		
		try {
			/* test.txt는 상대 경로임(기준이 프로젝트 폴더!) 
			 * */
			fis = new FileInputStream("test.txt");
		} catch (FileNotFoundException e) {
			System.out.println("File not found.");
		} finally {
			//프로그램 종료 전 사용했던 파일을 닫아줌
			if(fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		//간소화 버전
		try(FileInputStream fis2 = new FileInputStream("test.txt")){
			
		}catch(FileNotFoundException e) {
			System.out.println("File not found.");
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}
