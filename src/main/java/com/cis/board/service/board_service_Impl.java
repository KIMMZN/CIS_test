package com.cis.board.service;


import com.cis.board.repository.IF_Reopository;
import com.cis.board.vo.boardVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class board_service_Impl implements IF_board_service {


     private final IF_Reopository ifrepository;


    @Override
    public void writeOne(boardVO boardvo) throws Exception {

                ifrepository.insertOne(boardvo);

    }

    //공지 all
    @Override
    public List<boardVO> viewAll() throws Exception {


        List<boardVO> lista = ifrepository.listAll();
        System.out.println(lista + "서비스단 리스트 확인");
        return lista;
    }
    //자유게시판 all
    
    //하나보기
    @Override
    public void readBoard(int num) throws Exception {

        ifrepository.updateHits(num);

    }
    //선택 게시글 보기
    @Override
    public boardVO viewOne(int num) throws Exception {

        return ifrepository.selectOne(num);
    }

    //삭제
    @Override
    public void delOne(int number) throws Exception {

        ifrepository.deleteOne(number);
    }

    @Override
    public void deleteOne(boardVO boardvo) throws Exception {

        ifrepository.deleteOnE(boardvo);
    }


    //수정
    @Override
    public void modOne(boardVO boardvo) throws Exception {

        ifrepository.updateOne(boardvo);
    }


}
