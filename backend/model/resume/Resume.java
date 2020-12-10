package backend.model.resume;

public interface Resume {
    ResumeName getName();
    ResumeContents getContents();
    String getFullName();
    String getFullContents();
}
