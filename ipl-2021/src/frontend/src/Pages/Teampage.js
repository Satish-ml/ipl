import {React, useEffect, useState} from 'react';
import { MatchDetailCard } from '../Components/MatchDetailCard';
import { MatchSmallCard } from '../Components/MatchSmallCard';

export const Teampage = () =>{

  const [team, setTeam] = useState({matches: []});

useEffect(
     () => {
         const fetchMatches = async () => {

          const response = await fetch ('http://localhost:8126/team/Mumbai Indians');
          const data = await response.json();
          setTeam(data);

         };
        fetchMatches();
     }, []

      
    
  );

return (
      <div className="Teampage">

        <h1>{team.teamName}</h1>
        
        <MatchDetailCard match={team.matches[0]}/>
        {team.matches.slice(1).map(match => <MatchSmallCard match={match} />)}



      </div>

);

}


