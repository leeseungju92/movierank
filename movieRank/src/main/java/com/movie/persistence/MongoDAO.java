package com.movie.persistence;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.movie.domain.MovieDTO;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Repository
public class MongoDAO {
	
	@Autowired
	private MongoOperations mongoOper;
	
	public void save(MovieDTO mDto) {
		// TODO Auto-generated method stub
		log.info(">>>>영화랭킹정보 몽고디비에 저장");
		mongoOper.save(mDto);
	}


	public List<MovieDTO> movieList() {
		log.info(">>>>>>>>영화랭킹정보 몽고디비에서 셀렉트");

//		List<MovieDTO>list = mongoOper.find(query,entityclass);
		Criteria cri = new Criteria();
		//Criteria cri = new Criteria(key);
		//cri.is(value);
		Query query = new Query(cri);
		List<MovieDTO> list = mongoOper.find(query, MovieDTO.class,"movie");
		for(MovieDTO one : list){
			log.info(one.toString());
		}
		return list;
	}


	public void dropCol() {
		// TODO Auto-generated method stub
		mongoOper.dropCollection("movie");
	}
	
}
