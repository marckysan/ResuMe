package backend.model.resume;

import backend.exception.DuplicateResumeException;
import backend.exception.InvalidIndexException;
import backend.exception.ResumeNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ResumeListImpl implements ResumeList {

    private static final String EMPTY_RESUME_LIST_MESSAGE = "Resume list is empty!";

    private final List<Resume> internalList = new ArrayList<>();

    private ResumeListImpl() {}

    public static ResumeListImpl getEmptyList() {
        return new ResumeListImpl();
    }

    @Override
    public boolean isEmpty() {
        return internalList.isEmpty();
    }

    @Override
    public boolean contains(Resume resume) {
        return internalList.contains(resume);
    }

    @Override
    public int getNumResumes() {
        return internalList.size();
    }

    @Override
    public Resume get(int index) throws InvalidIndexException {
        try {
            return internalList.get(index);
        } catch (IndexOutOfBoundsException e) {
            throw new InvalidIndexException();
        }
    }

    @Override
    public ResumeName getResumeName(int index) {
        try {
            return internalList.get(index).getName();
        } catch (IndexOutOfBoundsException e) {
            throw new InvalidIndexException();
        }
    }

    @Override
    public ResumeContents getResumeContents(int index) {
        try {
            return internalList.get(index).getContents();
        } catch (IndexOutOfBoundsException e) {
            throw new InvalidIndexException();
        }
    }

    @Override
    public void add(Resume resume) throws DuplicateResumeException {
        if (this.contains(resume)) {
            throw new DuplicateResumeException();
        }
        assert (!this.contains(resume));
        internalList.add(resume);
    }

    @Override
    public void remove(Resume resume) throws ResumeNotFoundException {
        if (!this.contains(resume)) {
            throw new ResumeNotFoundException();
        }
        assert (this.contains(resume));
        internalList.remove(resume);
    }

    @Override
    public void remove(int index) throws InvalidIndexException {
        try {
            internalList.remove(index);
        } catch (IndexOutOfBoundsException e) {
            throw new InvalidIndexException();
        }
    }

    @Override
    public List<Resume> asList() {
        return internalList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResumeListImpl that = (ResumeListImpl) o;
        return Objects.equals(internalList, that.internalList);
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return EMPTY_RESUME_LIST_MESSAGE;
        }
        String resumes = "Resume list:" + "\n";
        int count = 0;
        for (Resume resume : internalList) {
            resumes += Integer.toString(count) + ". "
                    + resume.getFullName() + "\n";
            count++;
        }
        return resumes;
    }

}
