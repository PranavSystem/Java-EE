package dao;
import static utils.DBUtils.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pojos.Candidate;

public class CandidateDaoImpl implements CandidateDao {
	private static Connection cn;
	private PreparedStatement pst1,pst2;
	
	public CandidateDaoImpl(String url,String userName,String pass) throws SQLException {
		cn=openConnection(url, userName, pass);
		pst1=cn.prepareStatement("Select * from candidates");
		pst2=cn.prepareStatement("update candidates set votes=votes+1 where id=?");
		System.out.println("Candidate Dao created");
	}

	@Override
	public List<Candidate> getAllCandidate() throws SQLException {
		List<Candidate> candidates=new ArrayList<>();
		try(ResultSet rst1=pst1.executeQuery()) {
			if(rst1.next())
				candidates.add(new Candidate(rst1.getInt(1),rst1.getString(2),rst1.getString(3),rst1.getInt(4)));
		}
		return candidates;
	}

	@Override
	public String incrementCandidateVotes(int candidateId) throws SQLException {
		// set in para
		pst2.setInt(1,candidateId);
		int updateCount=pst2.executeUpdate();
		if(updateCount==1)
			return "Updated vote count";
		return "Vote count not updated";
	}

	//clean up
	public void cleanUp() throws SQLException {
		if(pst1!=null)
			pst1.close();
		if(pst2!=null)
			pst2.close();
		closeConnection();
		System.out.println("Candidate Dao cleaned");
	}
		

	
}
