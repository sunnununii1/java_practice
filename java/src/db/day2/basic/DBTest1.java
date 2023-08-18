package db.day2.basic;

import java.sql.*;
import java.util.Scanner;

public class DBTest1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Connection con = null;
		String url = "jdbc:mysql://localhost:3306/test";
		System.out.print("DB 계정  : ");
		String dbId = sc.next();
		System.out.print("DB 비번  : ");
		String dbPw = sc.next();
		
		try {
			con = DriverManager.getConnection(url, dbId, dbPw);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("연결 성공");
		
		/*
		String sql = "insert into member(me_id, me_pw) values(?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			//회원가입한 아이디와 비번을 입력받음
			System.out.println("ID : ");
			String id = sc.next();
			System.out.println("PW : ");
			String pw = sc.next();
			//쿼리에 있는 ? 대신 입력한 아이디와 비번을 넣어줌
			//setXXX(index, value) => index는 ?의 위치(1부터 시작), value는 ?의 값
			ps.setString(1, id);
			ps.setString(2, pw);
			
			//쿼리를 실행
			int resultCount = ps.executeUpdate();
			if(resultCount != 0) {
				System.out.println("회원가입 성공!");
			}else {
				System.out.println("회원가입 실패!");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		*/
		
		/*
		String sql = "update member set me_board_count = ? where me_id = ?";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			//?에 들어갈 값을 설정
			System.out.print("ID : ");
			String id = sc.next();
			ps.setString(2, id);
			
			System.out.print("정수 : ");
			int count = sc.nextInt();
			ps.setInt(1, count);
			
			//쿼리를 실행
			int resultCount = ps.executeUpdate();
			if(count != 0) {
				System.out.println("수정 성공!");
			}else {
				System.out.println("수정 실패!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		*/
		
		//*의 순서는 me_id, me_pw, me_board_count < *자리에 직접 써도 됨
		String sql = "select * from member";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			//?설정 => ?가 없어서 생략
			
			//쿼리 실행
			ResultSet resultSet = ps.executeQuery();
			//select문은 반복문을 통해서 값을 읽어오기
			while(resultSet.next()) {
				String id = resultSet.getString(1); //순서 기입
				String pw = resultSet.getString(2);
				int boardCount = resultSet.getInt(3);
				System.out.println(id + " : " + pw + " : " + boardCount);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		//연결한 connection도 닫아주기 작업 필요
		try {
			if(con != null && !con.isClosed()) {
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		sc.close();
	}

}
