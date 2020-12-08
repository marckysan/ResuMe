package production.model.achievement;

import java.util.Objects;

import static java.util.Objects.requireNonNull;
import static production.util.ArgumentChecker.checkArgument;

public class AchievementDescription {

    public static final String ACHIEVEMENT_DESCRIPTION_CONSTRAINTS_MESSAGE =
            "Achievement description should not be blank or whitespace.";

    public final String description;

    public AchievementDescription(String description) {
        requireNonNull(description);
        checkArgument(isValidDescription(description), ACHIEVEMENT_DESCRIPTION_CONSTRAINTS_MESSAGE);
        this.description = description;
    }

    public static boolean isValidDescription(String test) {
        return !(test == null || test.trim().isEmpty());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AchievementDescription that = (AchievementDescription) o;
        return Objects.equals(description, that.description);
    }

    @Override
    public String toString() {
        return description;
    }

}
