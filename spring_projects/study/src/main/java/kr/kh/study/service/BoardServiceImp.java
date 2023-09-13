package kr.kh.study.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kr.kh.study.dao.BoardDAO;
import kr.kh.study.pagination.Criteria;
import kr.kh.study.util.UploadFileUtils;
import kr.kh.study.vo.BoardVO;
import kr.kh.study.vo.FileVO;
import kr.kh.study.vo.MemberVO;

@Service
public class BoardServiceImp implements BoardService{
	
	@Autowired
	BoardDAO boardDao;
	
	//업로드할 파일 경로 설정
	String uploadPath = "D:\\uploadfiles"; 

	@Override
	public List<BoardVO> getBoardList(Criteria cri) {
		//cri 매개변수 체크
		if(cri == null) {
			cri = new Criteria();
		}
		//다오에게 게시글 리스트를 가져오라고 시킴
		List<BoardVO> list = boardDao.selectBoardList(cri);
		
		//가져오면 리턴
		return list;
	}

	@Override
	public BoardVO getBoard(Integer bo_num) {
		//매개변수 체크
		if(bo_num == null) {
			return null;
		}
		//다오에게 게시글번호 주며 게시글 가져오라 시킴
		BoardVO board = boardDao.selectBoard(bo_num);
		//가져오면 게시글을 돌려줌
		return board;
	}

	@Override
	public void updateViews(Integer bo_num) {
		//매개변수 체크
		if(bo_num == null) {
			return;
		}
		//다오에게 게시글 번호주며 조회수 1 증가시키라고 요청함
		boardDao.updateBoardViews(bo_num);
	}

	//게시글 글쓰기(첨부파일 없이)
	@Override
	public boolean insertBoard(BoardVO board, MemberVO user,  MultipartFile[] files) {
		//매개변수 체크
		if(user == null || user.getMe_id() == null) {
			return false;
		}
		if(board == null || board.getBo_title() == null || board.getBo_title().length() == 0) {
			return false;
		}
		//로그인한 회원아이디로 작성자 만들어줌
		
		board.setBo_me_id(user.getMe_id());
		//둘 다 아니라면 게시글 등록
		boolean res = boardDao.insertBoard(board);
		//게시글 등록 실패시 리턴
		if(!res) {
			return false;
		}
		//첨부파일 추가
		uploadFiles(files, board.getBo_num());
		return true;
	}
	//첨부파일 메서드
	private void uploadFiles(MultipartFile[] files, int bo_num) {
		//파일이름 없거나 파일내용 없으면 리턴할게 없음
		if(files == null || files.length == 0) {
			return;
		}
		if(bo_num <= 0) {
			return;
		}
		//반복문
		for(MultipartFile file : files) {
			//파일이 없거나, 파일명이 0글자면 건너뜀
			if(file == null || file.getOriginalFilename().length() == 0) {
				continue;
			}
			try {
				String fi_ori_name = file.getOriginalFilename();
				//try-catch문으로 감싸줌, uploadFile이 실제 파일업로드줄
				String fi_name = UploadFileUtils.uploadFile(uploadPath, fi_ori_name, file.getBytes());
				FileVO fileVo = new FileVO(fi_name, fi_ori_name, bo_num);
				boardDao.insertFile(fileVo);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public boolean update(BoardVO board, MemberVO user,
			MultipartFile[] files, int [] delNums) {
		//매개변수 체크
		if(user == null || user.getMe_id() == null) {
			return false;
		}
		if(board == null || board.getBo_title() == null || board.getBo_title().length() == 0) {
			return false;
		}
		//다오에게 요청
		BoardVO dbBoard = boardDao.selectBoard(board.getBo_num());
		if(dbBoard == null || !dbBoard.getBo_me_id().equals(user.getMe_id())) {
			return false;
		}
		//추가된 파일 업로드및 db에 추가
		uploadFiles(files, board.getBo_num());
		boolean res = boardDao.updateBoard(board);
		return res;
	}
	
	private void deleteFiles(int[] delNums) {
		if(delNums == null || delNums.length == 0) {
			return;
		}
		List<FileVO> fileList = new ArrayList<FileVO>();
		for(int fi_num : delNums) {
			FileVO fileVo = boardDao.selectFile(fi_num);
			fileList.add(fileVo);
		}
		deleteFiles(fileList);
	}

	@Override
	public boolean deleteBoard(Integer bo_num, MemberVO user) {
		if(user == null || user.getMe_id() == null) {
			return false;
		}
		if(bo_num == null) {
			return false;
		}
		//다오에게 게시글 정보 요청
		BoardVO board = boardDao.selectBoard(bo_num);
		//게시글이 비었거나, 작성자와 로그인회원이 같지않으면
		if(board == null || !board.getBo_me_id().equals(user.getMe_id())) {
			return false;
		}
		//첨부파일 먼저 삭제
		//게시글의 모든 첨부파일들 가져옴
		List<FileVO> fileList = boardDao.selectFileList(bo_num);
		
		//첨부파일 정보를 주고 삭제요청
		deleteFiles(fileList);
		
		return boardDao.deleteBoard(bo_num);
	}
	//첨부파일 삭제메서드
	private void deleteFiles(List<FileVO> fileList) {
		if(fileList == null || fileList.size() == 0) {
			return;
		}
		for(FileVO file : fileList) {
			if(file == null) {
				continue;
			}
			UploadFileUtils.deleteFile(uploadPath, file.getFi_name());
			boardDao.deleteFile(file.getFi_num());
		}
	}

	@Override
	public List<FileVO> getFileList(Integer bo_num) {
		//매개변수 체크
		if(bo_num == null) {
			return null;
		}
		//다오에게 게시글번호 주며 파일리스트 가져오라 요청
		return boardDao.selectFileList(bo_num);
	}

	//페이지메이커
	@Override
	public int getBoardTotalCount() {
		return boardDao.selectBoardTotalCount();
	}

	
}
