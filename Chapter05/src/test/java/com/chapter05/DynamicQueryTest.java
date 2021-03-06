package com.chapter05;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import com.chapter05.domain.Board;
import com.chapter05.domain.QBoard;
import com.chapter05.persistence.DynamicBoardRepository;
import com.querydsl.core.BooleanBuilder;


@RunWith(SpringRunner.class)
@SpringBootTest
public class DynamicQueryTest {
	
	@Autowired
	private DynamicBoardRepository boardRepo;
	@Test
	public void testDynamicQuery() {
		String searchCondition = "CONTENT";
		String searchKeyword = "테스트 내용 10";
		BooleanBuilder builder = new BooleanBuilder();  //가변적인 파라미터 값에 따라 동적으로 AND나 OR에 해당하는 조건을 추가할 수 있다.따라서 searchCondition 값에 따라서 제목 검색을 하거나 내용 검색을 할 수 있다.
		QBoard qboard = QBoard.board;
		if(searchCondition.equals("TITLE")) {
			builder.and(qboard.title.like("%" + searchKeyword + "%"));
		} else if(searchCondition.equals("CONTENT")) {
			builder.and(qboard.content.like("%" + searchKeyword + "%"));
		}
		
		
		Pageable paging = PageRequest.of(0, 5);
		
		
		Page<Board> boardList = boardRepo.findAll(builder, paging);
		
		
		System.out.println("검색 결과");
		for (Board board : boardList) {
			System.out.println("---> " + board.toString());
		}
		
		
	}

}
