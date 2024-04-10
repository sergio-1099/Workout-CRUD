package sergioguerra.workout.session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author sergioguerra
 */
@Controller
@RequestMapping("/session")
public class SessionController {
    @Autowired
    private SessionService service;
    
    @GetMapping("/all")
    public String getAllSessions(Model model) {
        model.addAttribute("sessionList", service.getAllSessions());
        return "session/list-sessions";
    }
    
    @GetMapping("/{id}")
    public String getSession(@PathVariable long id, Model model) {
        model.addAttribute("sessionElement", service.getSession(id));
        return "session/session-detail";
    }

    @GetMapping("/delete/{id}")
    public String deleteSession(@PathVariable long id, Model model) {
        service.deleteSession(id);
        return "redirect:/session/all";
    }

    @PostMapping("/create")
    public String createSession(Session session) {

        service.saveSession(session);
        return "redirect:/session/all";
    }

    @PostMapping("/update")
    public String updateSession(Session session) {
        service.updateSession(session);
        return "redirect:/session/all";
    }

    @GetMapping("/new-session")
    public String newSessionForm(Model model) {
        return "session/new-session";
    }

    @GetMapping("/update/{id}")
    public String updateSessionForm(@PathVariable long id, Model model) {
        model.addAttribute("session", service.getSession(id));
        return "session/update-session";
    }
}
