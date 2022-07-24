package com.woosan.root.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.woosan.root.dto.TradeBoardDTO;
import com.woosan.root.dto.TradeBoardReply;

@Repository
public interface TradeBoardMapper {
	public List<TradeBoardDTO> tradeBoardView();
	public void writeBoard(TradeBoardDTO dto);
	public TradeBoardDTO searchNum(String write_no);
	public void updateHit(String write_no);
	public List<TradeBoardReply> tradeReplyView(String write_no);
	public int nextReplyNo();
	public void writeReply(TradeBoardReply tr);
	public void updateTrade(TradeBoardDTO dto);
	public void tradeDelete(String write_no);
	public void tradeReplyDelete(String write_no);
	public TradeBoardDTO chatSetup(String id);
}
