package org.gaeng.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.jdbc.SQL;
import org.gaeng.dto.BoardDTO;

@Mapper
public interface BoardDAO {
	
	List<BoardDTO> getBoardList() throws SQLException;

	void insertData(BoardDTO boardDTO) throws SQLException;
	
	BoardDTO getDetailList(long no) throws SQLException;
	
	BoardDTO modifyDataList(long no) throws SQLException;
	
	int updateData(BoardDTO boardDTO) throws SQLException;

	int deleteBoard(BoardDTO boardDTO) throws SQLException;

	void updateReadCount(long no) throws SQLException;

	List<BoardDTO> paging(int offset);
	int totalCount() throws SQLException;

}
