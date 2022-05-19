package com.chapter05;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import com.chapter05.domain.Board;
import com.chapter05.persistence.BoardRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class QueryMethodTest {
	
	@Autowired
	private BoardRepository boardRepo;
	
//	@Before
//	public void dataPrepare() {
//	for (int i = 1; i <= 200; i++) {
//		Board board = new Board();
//		board.setTitle("테스트 제목 " + i);
//		board.setWriter("테스터");
//		board.setContent("테스트 내용 " + i);			
//		board.setCreateDate(new Date());	
//		board.setCnt(0L);
//		boardRepo.save(board);
//	}
//}
	
	
//	@Test
//	public void testFindByTitle() {
//		List<Board> boardList = boardRepo.findByTitle("테스트 제목 10");
//		
//		System.out.println("검색 결과");
//		for (Board board : boardList) {
//			System.out.println("---> " + board.toString());
//		}
//	}
	
	
	
//	@Test
//	public void testByContentContaining() {
//		List<Board> boardList = boardRepo.findByContentContaining("17"); //특정단어가 포함된 목록을 검색하려면 Containing 키워드 사용
//
//		
//		System.out.println("검색 결과");
//		for (Board board : boardList) {
//			System.out.println("---> " + board.toString());
//		}
//	}

	
	
//	@Test
//	public void testFindByTitleContainingOrContentContaining() {
//		List<Board> boardList = 
//			boardRepo.findByTitleContainingOrContentContaining("게시", "잘");
//		
//		System.out.println("검색 결과");
//		for (Board board : boardList) {
//			System.out.println("---> " + board.toString());
//		}
//	}
	
	
//	@Test
//	public void testFindByTitleContainingOrderBySeqDesc() {
//		List<Board> boardList = 
//			boardRepo.findByTitleContainingOrderBySeqDesc("17");
//		
//		System.out.println("검색 결과");
//		for (Board board : boardList) {
//			System.out.println("---> " + board.toString());
//		}
//	}
	
	
//	@Test
//	public void testFindByTitleContaining() {
//		Pageable paging = PageRequest.of(0, 5, Sort.Direction.DESC, "seq"); // 0은 페이지 번호인데, 0부터 시작하기 때문에 첫번째 페이지를 보고 싶으면 0, 5는 검색할 데이터의 개수
//		                                                                    //Sort.Direction.DESC 정렬방향, "seq" 정렬 대상
//		List<Board> boardList = boardRepo.findByTitleContaining("제목", paging);		
//		
//		System.out.println("검색 결과");
//		for (Board board : boardList) {
//			System.out.println("---> " + board.toString());
//		}
//	
//	}
	
	
	@Test
	public void testFindByTitleContaining() {
		Pageable paging = PageRequest.of(0, 10, Sort.Direction.DESC, "seq"); // 0은 페이지 번호인데, 0부터 시작하기 때문에 첫번째 페이지를 보고 싶으면 0, 5는 검색할 데이터의 개수
		                                                                    //Sort.Direction.DESC 정렬방향, "seq" 정렬 대상
		
		Page<Board> pageInfo = boardRepo.findByTitleContaining("제목", paging);		
		
		System.out.println("PAGE SIZE : " + pageInfo.getSize());
		System.out.println("TOTAL PAGES : " + pageInfo.getTotalPages());
		System.out.println("TOTAL COUNT : " + pageInfo.getTotalElements());
		System.out.println("NEXT : " + pageInfo.nextPageable());
		
		List<Board> boardList = pageInfo.getContent();
		System.out.println("검색 결과");
		for (Board board : boardList) {
			System.out.println("---> " + board.toString());
		}
	
	}
	
	
	
	
	
}
