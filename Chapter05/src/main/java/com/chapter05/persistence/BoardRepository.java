package com.chapter05.persistence;

import org.springframework.data.repository.CrudRepository;

import com.chapter05.domain.Board;

public interface BoardRepository extends CrudRepository<Board, Long>{

}
