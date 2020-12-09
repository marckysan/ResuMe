package backend.storage;

import backend.model.person.Person;

import java.io.IOException;
import java.nio.file.Path;

public interface Storage {
    Person load();
    void save(Person person);
    boolean isExistingPath(Path filepath);
}
