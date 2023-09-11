package kr.kh.study.vo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class MemberVO {
	private String me_id;
	private String me_pw;
	private String me_email;
	private String me_role;
	public boolean isAutoLogin;
	private String me_session_id;
	private Date me_session_limit;
	}

