package sergioguerra.workout.session;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "session")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

/**
 *
 * @author sergioguerra
 */
public class Session {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String date;
    private String sessionName;
    private int numOfExercises;

    public Session(String date, String sessionName, int numOfExercises) {
        this.date = date;
        this.sessionName = sessionName;
        this.numOfExercises = numOfExercises;
    }
}
