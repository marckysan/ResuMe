package backend.model.person;

import static java.util.Objects.requireNonNull;
import static backend.util.ArgumentChecker.checkArgument;

public class PersonName {

    private static final String DEFAULT_NAME = "Default Name";

    public static final String INVALID_PERSON_NAME_MESSAGE =
            "Your name should only contain alphanumeric characters and spaces, " +
                    "and it should not be blank." +
                    "Unless your father is Elon Musk, of course.";

    /*
     * The first character of the address must not be a whitespace,
     * otherwise " " (a blank string) becomes a valid input.
     */
    private static final String VALIDATION_REGEX = "[\\p{Alnum}][\\p{Alnum} ]*";

    private final String fullName;

    public PersonName(String name) {
        requireNonNull(name);
        checkArgument(isValidName(name), INVALID_PERSON_NAME_MESSAGE);
        fullName = name;
    }

    public static PersonName getDefaultName() {
        return new PersonName(DEFAULT_NAME);
    }

    public String getFullName() {
        return fullName;
    }

    public static boolean isValidName(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return fullName;
    }

    @Override
    public boolean equals(Object other) {
        return other == this
                || (other instanceof PersonName
                && fullName.equals(((PersonName) other).fullName));
    }

}
