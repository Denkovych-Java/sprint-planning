package com.epam.rd.autotasks.sprintplanning.tickets;

import com.epam.rd.autotasks.sprintplanning.Sprint;

public class Main {

    public static void main(String[] args) {
        int nextId = 1;
        Sprint sprint = new Sprint(40, 3);
        sprint.addUserStory(new UserStory(nextId++,"User Registration Entity",8));
        sprint.addUserStory(new UserStory(nextId++,"User Registration Form",16));
        sprint.addUserStory(new UserStory(nextId++,"User Registration. Apply Captcha",16));
        Ticket[] tickets = sprint.getTickets();
        System.out.println(tickets[0].toString());
        System.out.println(tickets[1].toString());
        System.out.println(tickets[2].toString());
        System.out.println(sprint.getTotalEstimate());

    }
}
