package backend.model.resume;

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
}
