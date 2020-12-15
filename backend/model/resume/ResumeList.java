package backend.model.resume;

import java.util.List;

public interface ResumeList {
    boolean isEmpty();
    boolean contains(Resume resume);
    int getNumResumes();
    Resume get(int index);
    ResumeName getResumeName(int index);
    ResumeContents getResumeContents(int index);
    void add(Resume resume);
    void remove(Resume resume);
    void remove(int index);
    List<Resume> asList();
}
