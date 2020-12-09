package backend.model.achievement;

import java.util.Objects;

import static java.util.Objects.requireNonNull;
import static backend.util.ArgumentChecker.checkArgument;

public class AchievementContents {

    public static final String ACHIEVEMENT_DESCRIPTION_CONSTRAINTS_MESSAGE =
            "Achievement description should not be blank or whitespace.";

    public final String contents;

    public AchievementContents(String contents) {
        requireNonNull(contents);
        checkArgument(isValidDescription(contents), ACHIEVEMENT_DESCRIPTION_CONSTRAINTS_MESSAGE);
        this.contents = contents;
    }

    public String getFullContents() {
        return contents;
    }

    public static boolean isValidDescription(String test) {
        return !(test == null || test.trim().isEmpty());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AchievementContents that = (AchievementContents) o;
        return Objects.equals(contents, that.contents);
    }

    @Override
    public String toString() {
        return contents;
    }

}
