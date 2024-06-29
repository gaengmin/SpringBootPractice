package org.gaeng.service;

import java.sql.SQLException;
import java.util.List;

import org.gaeng.dao.BoardDAO;
import org.gaeng.dto.BoardDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class BoardServiceImp implements BoardService {

	@Autowired
	private BoardDAO boardDAO;



	@Override
	public void insertData(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		try {
			boardDAO.insertData(boardDTO);
			System.out.println("++++++++++++++++++게시물 입력 성공+++++++++++++++++");
		} catch (Exception e) {
			e.getMessage();
		}
	}

	@Override
	public List<BoardDTO> getBoardList() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("++++++++++++++++++++++++++++++");
		return boardDAO.getBoardList();
	}

	@Override
	public BoardDTO getDetailList(long no) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("--------상세 게시물 확인---------");
		try {
			BoardDTO dto = boardDAO.getDetailList(no);
			return dto;
		} catch (Exception e) {
			e.getMessage();
			throw e;
		}
	}

	@Override
	public BoardDTO modifyDataList(long no) throws SQLException {
		// TODO Auto-generated method stub
		BoardDTO dto = boardDAO.modifyDataList(no);
		System.out.println("modifyData Confirm");
		
		return dto;
	}

	@Override
	public void updateData(BoardDTO boardDTO) throws Exception {
		try{
			if(boardDAO.updateData(boardDTO)==0){
				throw new RuntimeException("게시물이 존재하지 않거나 비밀번호가 일치하지 않음");
			}
		}catch (Exception e){
			log.info(e.getMessage());
			throw e;
		}
	}

	@Override
	public void deleteBoard(BoardDTO boardDTO) throws Exception {
		try{
			if(boardDAO.deleteBoard(boardDTO)==0){
				throw new RuntimeException("비밀번호가 일치 하지 않음");
			}
		}catch (Exception e){
			log.info(e.getMessage());
			throw e;
		}
	}

	@Override
	public void updateReadCount(long no) throws Exception {
		boardDAO.updateReadCount(no);
	}

	@Override
	public List<BoardDTO> paging(int offset) {

		return boardDAO.paging(offset);
	}

	@Override
	public int totalCount() throws Exception {
		return boardDAO.totalCount();
	}

}
