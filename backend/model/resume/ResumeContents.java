package backend.model.resume;

import java.util.Objects;

public class ResumeContents {

    private final String contents;

    public ResumeContents(String contents) {
        this.contents = contents;
    }

    public String getFullContents() {
        return contents;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResumeContents that = (ResumeContents) o;
        return Objects.equals(contents, that.contents);
    }

    @Override
    public String toString() {
        return contents;
    }

}
