package backend;

import backend.exception.CorruptedPersonDataException;
import backend.exception.AchievementsNotSelectedYetException;
import backend.exception.ModifyOnGenerationException;
import backend.logic.ResumeGenerator;
import backend.logic.ResumeGeneratorImpl;
import backend.logic.ResumeSaver;
import backend.logic.ResumeSaverImpl;
import backend.model.achievement.Achievement;
import backend.model.achievement.PersonalProject;
import backend.model.person.Person;
import backend.model.person.PersonImpl;
import backend.model.resume.Resume;
import backend.storage.Storage;
import backend.storage.StorageImpl;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BackendController {

    private Person person;
    private ResumeGenerator generator = null;
    private final ResumeSaver saver = new ResumeSaverImpl();
    private final Storage storage = new StorageImpl();

    private static final BackendController BACKEND = new BackendController();

    private BackendController() {
        try {
            this.person = storage.load();
        } catch (CorruptedPersonDataException e) {
            System.out.println(e.getMessage());
            this.person = PersonImpl.DEFAULT_PERSON;
        }
    }

    public static BackendController getBackend() {
        return BACKEND;
    }

    @GetMapping("/achievements")
    public List<Achievement> getAllAchievements() {
        return person.getAchievementList().asList();
    }

    @GetMapping("/achievements/{index}")
    public ResponseEntity<Achievement> getAchievementByIndex(@PathVariable(value = "index") long index) {
        Achievement achievement = person.getAchievement((int) index);
        return ResponseEntity.ok().body(achievement);
    }

    @PostMapping("/achievements/add/personal-project/name='{name}'/description='{description}'")
    public ResponseEntity addPersonalProject(@PathVariable(value = "name") String name,
                                             @PathVariable(value = "description") String description) {
        if (generator != null) {
            throw new ModifyOnGenerationException();
        }
        Achievement project = PersonalProject.of(name, description);
        person.addAchievement(project);
        storage.save(person);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/achievements/{index}/delete")
    public ResponseEntity deleteAchievement(@PathVariable(value = "index") long index) {
        if (generator != null) {
            throw new ModifyOnGenerationException();
        }
        person.removeAchievement((int) index);
        storage.save(person);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/resumes")
    public List<Resume> getAllResumes() {
        return person.getResumeList().asList();
    }

    @GetMapping("/resumes/{index}")
    public ResponseEntity<Resume> getResumeByIndex(@PathVariable(value = "index") long index) {
        return ResponseEntity.ok().body(person.getResume((int) index));
    }

    @DeleteMapping("/resumes/{index}/delete")
    public ResponseEntity deleteResume(@PathVariable(value = "index") long index) {
        person.removeResume((int) index);
        storage.save(person);
        return ResponseEntity.ok().build();
    }

    @RequestMapping("/achievements/{index}/select")
    public ResponseEntity selectAchievement(@PathVariable(value = "index") long index) {
        if (generator == null) {
            generator = new ResumeGeneratorImpl(person.getNumAchievements());
        }
        generator.selectAchievement((int) index);
        return ResponseEntity.ok().build();
    }

    @RequestMapping("/achievements/{index}/deselect")
    public ResponseEntity deselectAchievement(@PathVariable(value = "index") long index) {
        if (generator == null) {
            generator = new ResumeGeneratorImpl(person.getNumAchievements());
        }
        generator.deselectAchievement((int) index);
        return ResponseEntity.ok().build();
    }

    @RequestMapping("/achievements/generate/name='{resumeName}'")
    public ResponseEntity generateAndAddResume(@PathVariable(value = "resumeName") String resumeName) {
        if (generator == null) {
            throw new AchievementsNotSelectedYetException();
        }
        Resume resume = generator.generateResume(person.getAchievementList(), resumeName);
        person.addResume(resume);
        generator = null;
        storage.save(person);
        return ResponseEntity.ok().build();
    }

    @RequestMapping("/resumes/{index}/save")
    public ResponseEntity saveAsPdf(@PathVariable(value = "index") long index) {
        saver.saveAsPdf(person.getResume((int) index));
        return ResponseEntity.ok().build();
    }

}
