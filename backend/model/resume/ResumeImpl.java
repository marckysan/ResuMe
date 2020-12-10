package backend.model.resume;

import java.util.Objects;

public class ResumeImpl implements Resume {

    public final ResumeName name;
    public final ResumeContents contents;

    public ResumeImpl(ResumeName name, ResumeContents contents) {
        this.name = name;
        this.contents = contents;
    }

    @Override
    public ResumeName getName() {
        return name;
    }

    @Override
    public ResumeContents getContents() {
        return contents;
    }

    @Override
    public String getFullName() {
        return name.getFullName();
    }

    @Override
    public String getFullContents() {
        return contents.getFullContents();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResumeImpl resume = (ResumeImpl) o;
        return Objects.equals(name, resume.name) &&
                Objects.equals(contents, resume.contents);
    }

}
