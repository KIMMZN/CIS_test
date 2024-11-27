package com.cis.board.controller;

import com.cis.board.service.IF_board_service;
import com.cis.board.vo.boardVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class BoardController {

    private final IF_board_service ifboardservice;

    @GetMapping(value = "/board_gj")
    public String board(Model model)throws Exception {

        List<boardVO> boardvolist = ifboardservice.viewAll();

        model.addAttribute("boardvolist", boardvolist);
        System.out.println(boardvolist.size()+ boardvolist.toString());
        System.out.println(boardvolist);

        return "/board/board_gj";

    }

    @GetMapping(value = "/write_gj")
    public String write_gj()throws Exception {


        return "/board/write_gj";
    }

    @GetMapping(value = "/board_write_one")
    public String board_write_one(@ModelAttribute boardVO boardvo)throws Exception {
        System.out.println("테스트");
        System.out.println(boardvo.toString());
        ifboardservice.writeOne(boardvo);

        return "redirect:/board_gj";
    }




    @GetMapping(value = "/board_fr")
    public String board_fr(Model model)throws Exception {

        return "/board/board_fr";
    }

    @GetMapping(value = "/write_fr")
    public String write_fr()throws Exception {


        return "/board/write_fr";
    }

    //글 read? 공지사항
    @GetMapping(value = "/gj_preview/{board_num}")
    public String gj_preview(@PathVariable("board_num") int num, Model model)throws Exception {
        System.out.println(num + "  게시글넘버");
        //조회수
        ifboardservice.readBoard(num);
        //내용 옮기기
        boardVO boardvo = ifboardservice.viewOne(num);
        model.addAttribute("boardvo", boardvo);
        System.out.println(boardvo.toString() + "boardvo");
        return "/board/gj_preview";
    }

    //글 삭제 (num,category)
    @PostMapping(value = "/gj_preview/delOne/{num}")
    public String gj_preview_delOne(@PathVariable("num") int num,@ModelAttribute boardVO boardvo)throws Exception {
        boardvo.setBoard_num(num);
        
        //System.out.println(boardvo.toString()+"   !!!!tostiong 테스트");

        ifboardservice.deleteOne(boardvo);
        //System.out.println(boardvo.getCategory() + "카테고리");
        //System.out.println(num+"게시글넘버");


        return "redirect:/board_gj";
    };

    //수정
    @PostMapping(value = "/gj_preview/modifyOne/{num}")
    public String gj_modifyOne(@ModelAttribute boardVO boardvo)throws Exception {


        ifboardservice.modOne(boardvo);
        //System.out.println(num + "     a asdf");
        System.out.println(boardvo.toString()+"   boardvo테스트");

        return "redirect:/board_gj";
    }




}