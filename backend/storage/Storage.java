package backend.storage;

import backend.exception.CorruptedPersonDataException;
import backend.exception.UnableSavePersonException;
import backend.model.account.Account;

import java.nio.file.Path;

public interface Storage {
    Account load() throws CorruptedPersonDataException;
    void save(Account person) throws UnableSavePersonException;
    boolean isExistingPath(Path filepath);
}
