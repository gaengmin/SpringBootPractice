package org.gaeng.service;

import java.sql.SQLException;
import java.util.List;

import org.gaeng.dto.BoardDTO;

public interface BoardService {
	void insertData(BoardDTO boardDTO) throws Exception;

	List<BoardDTO> getBoardList() throws Exception;

	BoardDTO getDetailList(long no) throws Exception;

	BoardDTO modifyDataList(long no) throws Exception;

	void updateData(BoardDTO boardDTO) throws Exception;

	void deleteBoard(BoardDTO boardDTO) throws Exception;

	void updateReadCount(long no) throws Exception;
	List<BoardDTO> paging(int offset);
	int totalCount() throws Exception;
}
