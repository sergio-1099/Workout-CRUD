package sergioguerra.workout.session;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

/**
 *
 * @author sergioguerra
 */
@Repository
public class SessionRepository {
    @Autowired
    NamedParameterJdbcTemplate template;
    
    List<Session> findAll() {

        String query = "select id, date, session_name, num_of_exercises from session";
        return template.query(query,
                (result, rowNum)
                -> new Session(result.getLong("id"),
                        result.getString("date"), result.getString(
                        "session_name"), result.getInt("num_of_exercises")));
        
    }
    
    public Session getSessionById(long id) {
        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue(
                "id", id);
        String query = "select * from session where id=:id ";
        return template.queryForObject(query, namedParameters,
                BeanPropertyRowMapper.newInstance(Session.class));
    }
    
    public int saveSession(Session session) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("date", session.getDate());
        paramMap.put("session_name", session.getSessionName());
        paramMap.put("num_of_exercises", session.getNumOfExercises());
        String query = "INSERT INTO session(date,session_name,num_of_exercises) VALUES(:date, :session_name, :num_of_exercises)";
        return template.update(query, paramMap);
    }
    
    void deleteSessionById(long id) {

        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue(
                "id", id);
        String query = "delete from session where id=:id";
        template.update(query, namedParameters);
    }
    
    void updateSession(Session session) {

        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("id", session.getId());
        paramMap.put("date", session.getDate());
        paramMap.put("session_name", session.getSessionName());
        paramMap.put("num_of_exercises", session.getNumOfExercises());
        String query = "update session set date=:date, session_name=:session_name, num_of_exercises=:num_of_exercises where id=:id ";
        template.update(query, paramMap);
    }
}
