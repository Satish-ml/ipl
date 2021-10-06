package com.satish.ipl2021.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.satish.ipl2021.model.Team;
import com.satish.ipl2021.repository.MatchRepository;
import com.satish.ipl2021.repository.TeamRepository;

@RestController
@CrossOrigin
public class TeamController {
	@Autowired
	private TeamRepository teamRepository;
	
	@Autowired
	private MatchRepository matchRepository;
	//with this controller we have autowired TeamRepository
//	public TeamController(TeamRepository teamRepository) {
//		
//		this.teamRepository = teamRepository;
//	}



	@GetMapping("/team/{teamName}")
	public Team getTeam(@PathVariable String teamName) {
		Team team = this.teamRepository.findByTeamName(teamName);
		
		team.setMatches(matchRepository.findLatestMatchedByTeam(teamName, 4));
		return team;
		
	}

}
