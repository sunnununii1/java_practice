package kr.kh.study.util;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.UUID;

import org.springframework.util.FileCopyUtils;

public class UploadFileUtils {
	
	/***
	 *파일을 uploadPath에 복사한 후 복사한 파일경로와 이름을 합쳐서 문자열로 반환하는 메서드
	 *파일을 업로드한 날짜에 맞춰서 년/월/일 폴더가 생성되고 그 안에 업로드 
	 *  @param uploadPath
	 *  @param originalFileName
	 *  @param fileData
	 *  @return
	 * @throws IOException 
	 */
	
	public static String uploadFile(String uploadPath, String originalFileName, byte[] fileData) throws IOException {
		//같은 파일명을 가지는 파일을 업로드할 때 덮어쓰기 되지않게 처리
		UUID uuid = UUID.randomUUID();
		String savedFileName = uuid.toString() + "_" + originalFileName; //8-4-4-4-12_파일명
		
		//한 폴더에 파일이 몰리지 않게 날짜별로 업로드 파일을 관리
		// ex. 2023/09/01
		String savedPath = calcPath(uploadPath); // 업로드 날짜 기준, 년/월/일 폴더 없음 생성-생성경로 반환
		
		//실제 파일 복사
		//빈 파일 생성
		File target = new File(uploadPath + savedPath, savedFileName);
		//파일 복사
		FileCopyUtils.copy(fileData, target);
		return uploadFileName(savedPath, savedFileName);
	}
	
	private static String uploadFileName(String savedPath, String savedFileName) {
		String fileName = savedPath + File.separator + savedFileName;
		return fileName.replace(File.separator, "/");
		//운영체제 상관없이 경로가 '/'로 저장되도록
	}

	/***
	 * uploadPath에 오늘 날짜에 맞는 년/월/일 폴더 없으면 생성, 경로 반환하는 메서드
	 * @param uploadPath 년/월/일 폴더를 만들 부모폴더
	 * @return 기준 년/월/일 폴더 경로
	 */
	private static String calcPath(String uploadPath) {
		Calendar cal = Calendar.getInstance(); //현재 날짜를 달력 형태로 받음
		// => \\2023\\09\\01 출력
		String yearPath = File.separator + cal.get(Calendar.YEAR); //년 추출 (File.separator는 자동으로 구분자 추출해줌)
		String monthPath = yearPath + File.separator + new DecimalFormat("00").format(cal.get(Calendar.MONTH)+1); //월. new DecimalFormat("00").format(); 은 월을 2자리로. +1은 기본 0~11리턴이므로  
		String datePath = monthPath + File.separator + new DecimalFormat("00").format(cal.get(Calendar.DATE)); //일

		//폴더 생성
		makeDir(uploadPath, yearPath, monthPath, datePath);
		return datePath;
	}
	//매개변수가 다변일 때, ...path(중복된 이름)s 해주면 코드 간략해짐
	private static void makeDir(String uploadPath, String...paths) {
		//datePath가 이미 존재하면 이미 폴더가 있어서 폴더 더 만들 필요 없다.
		if(new File(uploadPath + paths[paths.length-1]).exists()) {
			return;
		}
		for(String path : paths) {
			File dir = new File(uploadPath + path);
			if(!dir.exists()) {
				dir.mkdir();
			}
		}
	}

	public static void deleteFile(String uploadPath, String fi_name) {
		File file = new File(uploadPath+fi_name);
		if(file.exists()) {
			file.delete();
		}
		
	}

}
