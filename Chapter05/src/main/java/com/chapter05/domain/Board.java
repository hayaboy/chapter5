package com.chapter05.domain;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString(exclude = "member")
@Entity
public class Board {
	
	@Id @GeneratedValue
	private Long seq;
	private String title;
//	private String writer;
	private String content;
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date createDate;
	private Long cnt;
	
	                                       //EAGER는 조인이 실행되어 연관관계에 있는 회원 정보까지 같이 조회된다. OUTER JOIN 이 되어 성능상 문제가 있다. 내부조인으로 변경하는 것이 좋다. 이때 Member.member 변수와 매핑되는 Member_ID 칼럼이 항상 참조값을 가진다는 의미로 @JoinColumn에 nullable속성을 추가하면 된다. 
	@ManyToOne(fetch = FetchType.EAGER)  //optional : 연관된 엔티티가 반드시 있어야 하는지의 여부 결정(true), false로 하면 항상 있어야 한다. fetch : 글로벌 페치 전략(EAGER는 연관 엔티티 동시 조회, LAZY는 실제 사용할 때 조회) cascade : 영속성 전이 기능 설정, 연관 엔티티를 같이 저장하거나 삭제할 때 사용
	@JoinColumn(name="MEMBER_ID", nullable = false) // 외래키 매핑을 위해 
	Member member;
	
	
	//게시판 객체에 회원 객체를 설정할 때, 회원이 소유한 게시 글 컬렉션에 자식(게시글)도 자동으로 저장될 있게 , 이렇게 해야 영속 객체가 아닌 단순한 일반 자바 객체 상태에서도 관련된 데이터를 사용할 수 있다.
	public void setMember(Member member){
		this.member=member;
		member.getBoardlist().add(this);
	}
	
	//위처럼 하면 자동으로 Member객체가 가진 boardList라는 컬력션에도 Member 객체가 설정
}
