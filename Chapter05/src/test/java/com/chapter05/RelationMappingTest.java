package com.chapter05;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.chapter05.domain.Board;
import com.chapter05.domain.Member;
import com.chapter05.persistence.BoardRepository;
import com.chapter05.persistence.MemberRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RelationMappingTest {
	@Autowired
	private BoardRepository boardRepo;
	
	@Autowired
	private MemberRepository memberRepo;
	
	
//	@Test
//	public void testManyToOneInsert() {
//		Member member1 = new Member();
//		member1.setId("member1");
//		member1.setPassword("member111");
//		member1.setName("둘리");
//		member1.setRole("User");
//		//memberRepo.save(member1);
//		
//		Member member2 = new Member();
//		member2.setId("member2");
//		member2.setPassword("member222");
//		member2.setName("도우너");
//		member2.setRole("Admin");
//		//memberRepo.save(member2);
//		
//		for (int i = 1; i <= 3; i++) {
//			Board board = new Board();
//			board.setMember(member1);      //중요한 것은 엔티티를 저장할 때 연관관계에 있는 엔티티가 있다면 해당 엔티티도 영속 상태에 있어야 한다. 따라서 게시글과 연관관계에 있는 회원 엔티티를 먼저 영속성 컨텍스트에 저장하고 이후에 게시글 엔티틸를 저장한 것이다.
//			board.setTitle("둘리가 등록한 게시글 " + i);
//			board.setContent("둘리가 등록한 게시글 내용 " + i);
//			board.setCreateDate(new Date());
//			board.setCnt(0L);
//			//boardRepo.save(board);   //Member 객체만 영속화시키면 Member가 가진 boardList 컬렉션에 저장된 모든 Board 객체도 자동으로 영속화된다.
//		}
//		memberRepo.save(member1);
//		
//		for (int i = 1; i <= 3; i++) {
//			Board board = new Board();
//			board.setMember(member2);
//			board.setTitle("도우너가 등록한 게시글 " + i);
//			board.setContent("도우너가 등록한 게시글 내용 " + i);
//			board.setCreateDate(new Date());
//			board.setCnt(0L);
//		//	boardRepo.save(board);
//		}
//		memberRepo.save(member2);
//	}
	

//	@Test
//	public void testManyToOneSelect() {		
//		Board board = boardRepo.findById(5L).get();
//		
//		System.out.println("[ " + board.getSeq() + "번 게시글 정보 ]");
//		System.out.println("제목 : " + board.getTitle());
//		System.out.println("내용 : " + board.getContent());
//		System.out.println("작성자 : " + board.getMember().getName());
//		System.out.println("작성자 권한 : " + board.getMember().getRole());
//	}
	
	
	
//	@Test
//	public void testTwoWayMapping() {		
//		Member member = memberRepo.findById("member1").get();
//		
//		System.out.println("===========================");
//		System.out.println(member.getName() + "가(이) 저장한 게시글 목록");
//		System.out.println("===========================");
//		List<Board> list = member.getBoardlist();
//		for (Board board : list) {
//			System.out.println(board.toString());
//		}
//	}

	@Test
	public void testCascadeDelete() {			
		memberRepo.deleteById("member2");
	}
}
	
	
	

	
	
