package com.satish.ipl2021.repository;

import org.springframework.data.repository.CrudRepository;

import com.satish.ipl2021.model.Team;



public interface TeamRepository extends CrudRepository<Team, Long>  {

    Team findByTeamName(String teamName);
    
}
