package com.satish.ipl2021.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.satish.ipl2021.model.Match;
import com.satish.ipl2021.model.Team;



public interface MatchRepository extends CrudRepository<Match, Long>{
	List<Match> getByTeam1OrTeam2OrderByDateDesc(String teamName1, String teamName2,Pageable pagable);

		default List<Match> findLatestMatchedByTeam(String teamName,int count){
			return getByTeam1OrTeam2OrderByDateDesc(teamName, teamName,PageRequest.of(0, count));
		}
}
