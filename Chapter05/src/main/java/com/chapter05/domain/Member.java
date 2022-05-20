package com.chapter05.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(exclude = "boardlist") //exclude 옵션이 없을 경우 @ToString은 양방향 참조에서 상호 호출을 함 , 그럴  경우 순환참조에 빠짐, exclude 속성을 추가하여 상호 호출 고리를 끊어야 한다.     
@Entity
public class Member {
	
	
	/*
	 * 엔티티의 변수와 테이블의 칼럼을 매핑할 때 사용, 일반적으로 엔티티의 변수 이름과 칼럼 이름이 다를 때 사용, 생략하면 기본으로 변수 이름과 동일한 칼럼이 매핑된다.
	 * 속성은 많지만 name과 NULL 데이터 입력을 방지하는 nullable

@ name  칼럼 이름
@ unique unique 제약 조건(기본값 :false)
@ nullable null 상태 허용 여부 설정 (기본값 :false)
@ insertable INSERT를 생성할 때 이 칼럼을 포함할 것인지 결정(true)
@ updatable UPDATE를 생성할 때 이 칼럼을 포함할 것인지 결정(true)
@ columnDefinition 이 칼럼에 대한 DDL 문을 직접 기술
@ length 문자열 타입의 칼럼 길이를 지정한다.(기본값 : 255)
@ precision 숫자 타입의 전체 자릿수 지정(0
@ scale 숫자 타입의 소수점 자릿수 지정(0)

	 * 
	 * */
	
	
	@Id
	@Column(name="MEMBER_ID")
	private String id;
	private String password;
	private String name;
	private String role;
	
	
//	       //중요한 설정은 mappedBy 속성인다. 이것은 양방향 연관관계에서 연관관계의 주인을 지정할 때 사용, 객체에는 원래부터 양방향이라는 개념이 없고, 서로를 참조하는 단방향 관계 두 개가 필요한다. 하지만 테이블의 경우에는 외래키 하나로 양방향을 조회할 수 있다. 연관관계의 주인은 테이블에 외래 키가 있는 곳으로 정해야 한다. 
//	@OneToMany(mappedBy = "member", fetch = FetchType.EAGER)  //일대다 관계 매핑, fetch 속성은 회원 정보를 조회할 때 연관관계에 있는 게시판 정보도 같이 조회할 것이지 결정할 때 사용, 기본값은 LAZY, EAGER로 설정했기 때문에, 회원정보를 가져올 때 회원이 등록한 게시 글 목록도 같이 조회
//	List<Board> boardlist = new ArrayList<Board>();
	

	// cascade로 인해 BOARD 테이블과 MEMBER 테이블의 모든 데이터를 삭제하고 테스트 하면 이전과 동일하게 정상적으로 데이터가 등록
	@OneToMany(mappedBy = "member", fetch = FetchType.EAGER, cascade = CascadeType.ALL )   //ALL을 적용하면 회원 객체가 영속화되거나 수정, 또는 삭제될 때 회원과 관련된 게시판도 같이 변경될 것
	List<Board> boardlist = new ArrayList<Board>();
	

}
