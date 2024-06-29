package org.gaeng.controller;

import org.gaeng.dto.BoardDTO;
import org.gaeng.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BoardController {
    @Autowired
    private BoardService boardService;

    @GetMapping({ "list2", "list2?page={page}" })
    public String list2(@RequestParam(value = "page", defaultValue = "1") int page, Model model) throws Exception {
        int totalCount;
        System.out.println("page 값 :" +page);
        try {
            totalCount = boardService.totalCount();
            System.out.println(totalCount);
            int articlesPerPage = 5; // 한 페이지에 표시할 게시물 수
            int totalPages = (int) Math.ceil((double) totalCount / articlesPerPage);
            model.addAttribute("list", boardService.paging(page));
            model.addAttribute("currentPage", page);
            model.addAttribute("totalPages", totalPages);
            List<BoardDTO> list = boardService.paging(page);
            model.addAttribute("list", list);
            return "board/list2";
        } catch (Exception e) {
            // 에러 처리
            return "error";
        } // end try

    }// end list


/*    @GetMapping("list")
    public String list(Model model) throws Exception {
        try {
            List<BoardDTO> list = boardService.getBoardList();
            model.addAttribute("list", list);
            return "board/list";
        } catch (Exception e) {
            e.getMessage();
            throw e;
        }
    }*/

    @GetMapping("insert")
    public String insert() throws Exception {

        return "board/insert";
    }

    @PostMapping("insert")
    public String insert(@ModelAttribute BoardDTO dto, Model model) throws Exception {
        System.out.println(dto.toString());
        try {
            boardService.insertData(dto);
            return "redirect:list";
        } catch (Exception e) {
            model.addAttribute("msg", "게시물 등록 오류입니다");
            model.addAttribute("url", "javascript:history.back();");
            return "board/result";
        }
    }

    @GetMapping("detail")
    public String detail(@RequestParam(defaultValue = "0") long no, Model model) throws Exception {
        try {
            boardService.updateReadCount(no);
            BoardDTO boardDTO = boardService.getDetailList(no);
            model.addAttribute("boardDTO", boardDTO);
            return "board/detail";
        } catch (Exception e) {
            model.addAttribute("msg", "접근불가");
            model.addAttribute("url", "list");
            return "board/result";
        }
    }

    @GetMapping("delete")
    public String deleteData(@RequestParam long no, Model model){
            model.addAttribute("no", no);

        return "board/delete";
    }

    @PostMapping("delete")
    public String delete(@ModelAttribute BoardDTO boardDTO, Model model) throws Exception {
        try{
            boardService.deleteBoard(boardDTO);
            model.addAttribute("msg", boardDTO.getNo()+"번이 삭제 완료");
            model.addAttribute("url", "list");
            return "board/result";

        }catch (Exception e){
            model.addAttribute("msg", boardDTO.getNo()+"번이 삭제 실패");
            model.addAttribute("url", "javascript:history.back()");
            return "board/result";

        }
    }

    @GetMapping("modify")
    public String modify(@RequestParam long no, Model model) throws Exception {
        System.out.println("++++++++++++++++++++++++++++="+no);
        try {
            BoardDTO boardDTO = boardService.modifyDataList(no);
            model.addAttribute("boardDTO", boardDTO);
            return "board/modify";

        } catch (Exception e) {
            model.addAttribute("msg", "접근불가");
            model.addAttribute("url", "list");
            return "board/result";
        }
    }

    @PostMapping("modify")
    public String update(@ModelAttribute BoardDTO dto, Model model) throws Exception {
        System.out.println(dto.toString());
        try {
            boardService.updateData(dto);
            return "redirect:detail?no="+dto.getNo();
        } catch (Exception e) {
            model.addAttribute("msg", "게시물 등록 오류입니다");
            model.addAttribute("url", "javascript:history.back();");
            return "board/result";
        }
    }
}
