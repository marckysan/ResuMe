package achievement;

import java.util.Objects;

public class PersonalProject implements Achievement {

    public String name;
    public String description;

    public PersonalProject(String name, String description) {
        this.name = name;
        this.description = description;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonalProject that = (PersonalProject) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(description, that.description);
    }

    @Override
    public String toString() {
        return "Personal Project: " + getName() + " | " + getDescription();
    }

}
