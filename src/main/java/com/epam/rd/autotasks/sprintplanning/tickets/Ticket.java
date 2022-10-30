package com.epam.rd.autotasks.sprintplanning.tickets;

public class Ticket {
    private final int id;
    private final String name;
    private final int estimate;
    private boolean complete;

    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    public Ticket(int id, String name, int estimate) {
        this.id = id;
        this.name = name;
        this.estimate = estimate;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isCompleted() {
        return complete;
    }

    public void complete() {
        if (!complete) {
            complete = true;
        }
    }

    public int getEstimate() {
        return estimate;
    }
}
