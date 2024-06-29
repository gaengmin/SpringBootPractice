package org.gaeng.test;

import org.gaeng.dto.BoardDTO;
import org.gaeng.service.BoardService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class GetList {

	@Autowired
	private BoardService boardServie;

//	@DisplayName("데이터 삭제")
//	@Test
//	public void deleteData() throws Exception{
//		System.out.println("삭제 하는 중");
//		BoardDTO dto = new BoardDTO();
//		dto.setNo(23);
//		dto.setPassword("1234");
//		boardServie.deleteBoard(dto);
//	}

//	@DisplayName("데이터 업데이트 확인")
//	@Test
//	public void updateTest() throws Exception{
//		BoardDTO dto = new BoardDTO();
//		dto.setNo(24);
//		dto.setPassword("1234");
//		dto.setName("수정완료");
//		dto.setContent("수정하는 중입니다.");
//		dto.setTitle("그렇다");
//		boardServie.updateData(dto);
//	}

//	@DisplayName("상세게시물확인")
//	@Test
//	public void modifyData() throws Exception{
//		System.out.println("=====================================");
//		System.out.println(boardServie.modifyDataList(1).toString());
//		}
//
	
//	
	@DisplayName("상세게시물확인")
	@Test
	public void getDetail() throws Exception{
		System.out.println("=====================================");
		boardServie.updateReadCount(27);
		System.out.println(boardServie.getDetailList(27).toString());
		}

	
//	@DisplayName("list확")
//	@Test
//	public void getList() throws Exception{
//		List<BoardDTO> list = boardServie.getBoardList();
//		System.out.println("==========================");
//		for(BoardDTO dto : list) {
//			System.out.println(dto.toString());
//		}
//		
//	}
//	
//	@DisplayName("데이터입력하기")
//	@Test
//	public void insertTest() throws Exception{
//		BoardDTO boardDTO = new BoardDTO();
//		boardDTO.setContent("데이터 테스트 하기123123");
//		boardDTO.setName("gaeng1");
//		boardDTO.setTitle("무음");
//		boardDTO.setPassword("1234");
//		boardServie.insertData(boardDTO);
//	}
	

}
