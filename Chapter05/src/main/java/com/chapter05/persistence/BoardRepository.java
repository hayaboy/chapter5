package com.chapter05.persistence;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.chapter05.domain.Board;

public interface BoardRepository extends CrudRepository<Board, Long>{

		List<Board> findByTitle(String seachKeyword);
		List<Board> findByContentContaining(String searchKeyword);
		

		List<Board> findByTitleContainingOrContentContaining(String title, String content);

		List<Board> findByTitleContainingOrderBySeqDesc(String searchKeyword);
		
//		List<Board> findByTitleContaining(String searchKeyword, Pageable paging);
		
		Page<Board> findByTitleContaining(String searchKeyword, Pageable paging);
		
		//@Query로 등록한 SQL들은 애플리케이션이 실행되는 시점에 일괄적으로 메모리에 로딩된다. 그런데 Board 엔티티에 Writer 변수를 주석 처리 했기 때문에 @Query로 등록한 SQL에서 문제가 발생
//	    @Query("SELECT b FROM Board b " + "WHERE b.title like %:searchKeyword%  " + "ORDER BY b.seq DESC")
//		List<Board> queryAnnotationTest1(@Param("searchKeyword") String searchKeyword);
		
	    
//		@Query(value = "select seq, title, writer, create_date " + "from board where title like '%'||?1||'%' "
//				+ "order by seq desc", nativeQuery = true)
//		List<Object[]> queryAnnotationTest3(String searchKeyword);
//		
//		
//		
//		@Query("SELECT b FROM Board b ORDER BY b.seq DESC")
//		List<Board> queryAnnotationTest4(Pageable paging);
	    
}
