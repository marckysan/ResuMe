package backend.model.resume;

import java.util.Objects;

import static java.util.Objects.requireNonNull;
import static backend.util.ArgumentChecker.checkArgument;

public class ResumeName {

    public static final String RESUME_NAME_CONSTRAINTS_MESSAGE =
            "Resume names should not be blank or whitespace.";

    private final String name;

    public ResumeName(String name) {
        requireNonNull(name);
        checkArgument(isValidName(name), RESUME_NAME_CONSTRAINTS_MESSAGE);
        this.name = name;
    }

    public String getFullName() {
        return name;
    }

    public static boolean isValidName(String test) {
        return !(test == null || test.trim().isEmpty());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResumeName that = (ResumeName) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public String toString() {
        return name;
    }

}
