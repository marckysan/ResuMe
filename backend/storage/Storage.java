package backend.storage;

import backend.exception.CorruptedPersonDataException;
import backend.exception.UnableSavePersonException;
import backend.model.person.Person;

import java.nio.file.Path;

public interface Storage {
    Person load() throws CorruptedPersonDataException;
    void save(Person person) throws UnableSavePersonException;
    boolean isExistingPath(Path filepath);
}
