package sergioguerra.workout.session;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author sergioguerra
 */
@Service
public class SessionService {
    @Autowired
    SessionRepository repo;
    
    /**
     * Get all sessions
     * @return the list of users.
     */
    public List<Session> getAllSessions() {
        return repo.findAll();
    }

    /**
     * Find one session by ID.
     * @param id
     * @return the user
     */
    public Session getSession(long id) {
        return repo.getSessionById(id);
    }

    /**
     * Delete session by ID.
     * @param id 
     */
    public void deleteSession(long id) {
        repo.deleteSessionById(id);
    }

    /**
     * Save session entry. 
     * @param session 
     */
    public void saveSession(Session session) {
        repo.saveSession(session);
    }

    /**
     * Update existing session.
     * @param session
     */
    public void updateSession(Session session) {
        repo.updateSession(session);
    }
}
