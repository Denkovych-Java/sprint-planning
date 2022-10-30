package com.epam.rd.autotasks.sprintplanning;

import com.epam.rd.autotasks.sprintplanning.tickets.Bug;
import com.epam.rd.autotasks.sprintplanning.tickets.Ticket;
import com.epam.rd.autotasks.sprintplanning.tickets.UserStory;

public class Sprint {
    Ticket[] sprint;

    private final int capacity;
    private int index;
    private int countLimit;
    private final int ticketsLimit;
    private int countCapacity = 0;

    public Sprint(int capacity, int ticketsLimit) {
        this.capacity = capacity;
        this.ticketsLimit = ticketsLimit;
        sprint = new Ticket[ticketsLimit];
    }


    public boolean addUserStory(UserStory userStory) {
        if (userStory == null) return false;
        countLimit++;
        if (countLimit > ticketsLimit) {
            countLimit--;
            return false;
        }
        countCapacity += userStory.getEstimate();
        if (countCapacity > capacity) {
            countCapacity -= userStory.getEstimate();
            return false;
        }
        if ((!userStory.isCompleted())) {
            if (userStory.getDependencies().length != 0) {
                if (isDependency(userStory)) {
                    sprint[index++] = userStory;
                    return true;
                } else {
                    countLimit--;
                    countCapacity -= userStory.getEstimate();
                    return false;
                }
            }
            sprint[index++] = userStory;
            return true;
        }
        countLimit--;
        countCapacity -= userStory.getEstimate();
        return false;
    }

    private boolean isDependency(UserStory userStory) {
        int countDep = 0;
        for (int i = 0; i < userStory.getDependencies().length; i++) {
            for (int j = 0; j < index; j++) {
                if (sprint[j].getId() == userStory.getDependencies()[i].getId()) countDep++;
                if (countDep == userStory.getDependencies().length) return true;
            }
        }
        return false;
    }

    public boolean addBug(Bug bugReport) {
        if (bugReport == null) return false;
        countLimit++;
        if (countLimit > ticketsLimit) {
            countLimit--;
            return false;
        }
        countCapacity += bugReport.getEstimate();
        if (countCapacity > capacity) {
            countCapacity -= bugReport.getEstimate();
            return false;
        }
        if (!bugReport.isCompleted()) {
            sprint[index++] = bugReport;
            return true;
        }
        return false;
    }

    public Ticket[] getTickets() {
        Ticket[] temp = new Ticket[index];
        System.arraycopy(sprint, 0, temp, 0, index);
        return temp;
    }

    public int getTotalEstimate() {
        int sum = 0;
        for (int i = 0; i < index; i++) {
            sum += sprint[i].getEstimate();
        }
        return sum;
    }
}
