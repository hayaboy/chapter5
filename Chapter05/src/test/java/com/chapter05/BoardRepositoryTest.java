package com.chapter05;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.chapter05.domain.Board;
import com.chapter05.persistence.BoardRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BoardRepositoryTest {

	
	@Autowired
	private BoardRepository boardRepo;
	
	@Test
	public void testDeleteBoard() {
		boardRepo.deleteById(1L);
	}
	
//	@Test
//	public void testGetBoard() {
//		Board board = boardRepo.findById(1L).get();
//		System.out.println(board.toString());
//	} 
	
//	@Test	
//	public void testUpdateBoard() {
//		System.out.println("=== 1번 게시글 조회 ===");
//		Board board = boardRepo.findById(1L).get();
//		
//		System.out.println("=== 1번 게시글 제목 수정 ===");
//		board.setTitle("제목을 수정했습니다.");
//		boardRepo.save(board);
//	} 
	
//	@Test
//	public void testInsertBoard() {
//		Board board = new Board();
//		board.setTitle("첫 번째 게시글");
//		board.setWriter("테스터");
//		board.setContent("잘 등록되나요?");
//		board.setCreateDate(new Date());
//		board.setCnt(0L);
//		
//		boardRepo.save(board);
//		
//		//엔티티를 영속성 컨텍스트에 저장하기 위해서는 원래 JPA의 persist()메소드를 사용했었다. 
//		//하지만 CurdRepository 인터페이스를 사용할 때는 save() 메소드를 이용해서 등록한다.
//	}
	
}
