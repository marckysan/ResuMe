package production.resume;

public interface ResumeList {
    boolean isEmpty();
    boolean contains(Resume resume);
    void add(Resume resume);
    void remove(Resume resume);
}
