package production.model.resume;

import production.model.exception.DuplicateResumeException;
import production.model.exception.ResumeNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ResumeListImpl implements ResumeList {

    private final List<Resume> internalList = new ArrayList<>();

    public ResumeListImpl() {}

    @Override
    public boolean isEmpty() {
        return internalList.isEmpty();
    }

    @Override
    public boolean contains(Resume resume) {
        return internalList.contains(resume);
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResumeListImpl that = (ResumeListImpl) o;
        return Objects.equals(internalList, that.internalList);
    }

}
