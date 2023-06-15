package beans;

import java.sql.SQLException;
import java.util.List;
import dao.TeamDaoImpl;
import pojos.Team;

public class IplBean {
	//state : dep : dao
	private Team team;
	private TeamDaoImpl teamdao;
	
	public IplBean() throws SQLException {
		// dao instance creation
		teamdao=new TeamDaoImpl();
		System.out.println("ipl bean created");
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public TeamDaoImpl getTeamdao() {
		return teamdao;
	}

	public void setTeamdao(TeamDaoImpl teamdao) {
		this.teamdao = teamdao;
	}
	
	// add business logic
	public List<Team> getAllTeams() throws SQLException {
		// invoke dao's method
		return teamdao.getSelectedDetails();
	}
	
	
	
}
