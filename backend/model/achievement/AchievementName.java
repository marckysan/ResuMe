package backend.model.achievement;

import java.util.Objects;

import static java.util.Objects.requireNonNull;
import static backend.util.ArgumentChecker.checkArgument;

public class AchievementName {

    public static final String ACHIEVEMENT_NAME_CONSTRAINTS_MESSAGE =
            "Achievement names should not be blank or whitespace.";

    public final String name;

    public AchievementName(String name) {
        requireNonNull(name);
        checkArgument(isValidName(name), ACHIEVEMENT_NAME_CONSTRAINTS_MESSAGE);
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
        AchievementName that = (AchievementName) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public String toString() {
        return name;
    }

}
