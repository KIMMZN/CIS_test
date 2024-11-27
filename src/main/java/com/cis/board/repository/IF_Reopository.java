package com.cis.board.repository;


import com.cis.board.vo.boardVO;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;


@Mapper
public interface IF_Reopository {
    public abstract void insertOne(boardVO boardvo) throws Exception;
    public List<boardVO> listAll() throws Exception;

    public void updateHits(int num)throws Exception;
    //게시글 보기
    public boardVO selectOne(int num)throws Exception;
    //삭제
    public void deleteOne(int number)throws Exception;
    //new 삭제

    public void deleteOnE(boardVO boardvo)throws Exception;

    //게시글 하나 수정
    public void updateOne(boardVO boardvo)throws Exception;
    //ifrepository.updateOne(boardvo);


}
