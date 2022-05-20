package com.chapter05.persistence;

import org.springframework.data.repository.CrudRepository;

import com.chapter05.domain.Member;

public interface MemberRepository extends CrudRepository<Member, String>{

}
