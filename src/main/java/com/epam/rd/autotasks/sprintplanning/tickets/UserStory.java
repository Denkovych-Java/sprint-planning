package com.epam.rd.autotasks.sprintplanning.tickets;

public class UserStory extends Ticket {
    private final UserStory[] dependsOn;

    public UserStory(int id, String name, int estimate, UserStory... dependsOn) {
        super(id, name, estimate);
        this.dependsOn = dependsOn;
    }

    @Override
    public void complete() {
        int count = 0;
        for (UserStory userStory : dependsOn) {
            if (userStory.isCompleted()) {
                count++;
            }
        }
        if (dependsOn.length == count) setComplete(true);
    }

    public UserStory[] getDependencies() {
        return copyFullArrayUsingClone(dependsOn);
    }

    @Override
    public String toString() {
        return "[US " + getId() + "] " + getName();
    }

    private static UserStory[] copyFullArrayUsingClone(UserStory[] dependsOn) {
        return dependsOn.clone();
    }
}
