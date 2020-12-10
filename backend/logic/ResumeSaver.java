package backend.logic;

import backend.exception.UnableSavePdfException;
import backend.model.resume.Resume;

public interface ResumeSaver {
    void saveAsPdf(Resume resume) throws UnableSavePdfException;
}
