package backend.storage;

import backend.model.achievement.AchievementListImpl;
import backend.model.person.Person;
import backend.model.person.PersonImpl;
import backend.model.person.PersonName;
import backend.model.resume.ResumeListImpl;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class StorageImpl implements Storage {

    private static final Path DIRECTORY_FILEPATH = Paths.get("data");
    private static final Path PERSON_DATA_FILEPATH = Paths.get("data", "person.json");

    public StorageImpl() {}

    @Override
    public Person load() {
        // TODO
        PersonImpl placeholder = new PersonImpl(new PersonName("Joshua Chew"), new AchievementListImpl(), new ResumeListImpl());
        return placeholder;
    }

    @Override
    public void save(Person person) {
        if (!isExistingPath(DIRECTORY_FILEPATH)) {
            File data = new File(DIRECTORY_FILEPATH.toUri());
            data.mkdir();
        }
        JsonSerializablePerson serializablePerson = new JsonSerializablePerson(person);
        try {
            FileWriter file = new FileWriter(PERSON_DATA_FILEPATH.toString());
            file.write(serializablePerson.toJsonString());
            file.flush();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    @Override
    public boolean isExistingPath(Path filepath) {
        return filepath.toFile().exists();
    }

}
