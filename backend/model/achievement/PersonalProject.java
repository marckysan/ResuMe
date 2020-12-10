package backend.model.achievement;

import java.util.Objects;

public class PersonalProject implements Achievement {

    public AchievementName name;
    public AchievementContents description;

    public PersonalProject(AchievementName name, AchievementContents description) {
        this.name = name;
        this.description = description;
    }

    public static PersonalProject of(String name, String description) {
        return new PersonalProject(new AchievementName(name), new AchievementContents(description));
    }

    @Override
    public AchievementName getName() {
        return name;
    }

    @Override
    public AchievementContents getContents() {
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
        return "Personal Project: " + getName() + " | " + getContents();
    }

}
