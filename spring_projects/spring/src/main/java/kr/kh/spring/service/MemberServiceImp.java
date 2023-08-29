package kr.kh.spring.service;

import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import kr.kh.spring.dao.MemberDAO;
import kr.kh.spring.vo.MemberVO;

@Service //@Service�� ������ @Atuowired �ν� �Ұ�(��Ʈ)
public class MemberServiceImp implements MemberService{

	//@Atuowired�� dy�� �ٸ��� ������(try-catch��) ������������
	@Autowired 
	private MemberDAO memberDao;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Override
	public boolean signup(MemberVO member) {
		if(member == null) {
			return false;
		}
		
		//���̵� �ߺ�Ȯ�� -> Dao���� ȸ������(id) ��û
		MemberVO dbMember = memberDao.selectMember(member.getMe_id());
		//�����Ϸ��� ���̵� �̹� ���Ե� ���
		if(dbMember != null) {
			return false;
		}
		//���̵�, ��� nullüũ + ��ȿ�� �˻�
		String idRegex = "^[a-zA-Z][a-zA-Z0-9]{5,14}$"; //�������� ����, 5~14��
		String pwRegex = "^[a-zA-Z0-9!@#$%]{6,15}$"; //����,����,!@#$%�� 6~15��
		//���̵� ��ȿ���� ���� ������
		if(!Pattern.matches(idRegex, member.getMe_id())) {
			return false;
		}
		//����� ��ȿ���� ���� ������
		if(!Pattern.matches(pwRegex, member.getMe_pw())) {
			return false;
		}
		//��� ��ȣȭ
		String encPw = passwordEncoder.encode(member.getMe_pw());
		member.setMe_pw(encPw); //��ȣȭ�� ����� �ٽ� ����
		//ȸ������ ����
		return memberDao.insertMember(member);
	}

	@Override
	public MemberVO login(MemberVO member) {
		if(member == null) {
			return null;
		}
		MemberVO dbMember = memberDao.selectMember(member.getMe_id());
		
		//���̵�� ��ġ�ϴ� ������ ������
		if(dbMember == null) {
			return null;
		}
		//��� Ȯ��(��ȣȭ �ȵ� ���ڿ�, ��ȣȭ�� ���ڿ�)
		if(passwordEncoder.matches(member.getMe_pw(), dbMember.getMe_pw())){
			return dbMember;
		}
		return null;
	}


}
