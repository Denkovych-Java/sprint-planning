package com.epam.rd.autotasks.sprintplanning.tickets;

/*Ticket
 аждый ticket имеет свой идентификатор, им€ и примерное врем€ дл€ его выполнени€. Ёти значени€ предоставл€ютс€ через конструктор класса Ticket.
Ticket может считатьс€ завершенным или незавершенным. “олько что созданный ticket считаетс€ незавершенным.
getId() - возвращает идентификатор ticketТа.
getName() - возвращает им€ ticketТа.
getEstimate() - возвращает оценку ticketТа.
isCompleted() - возвращает true, если ticket завершен, в противном случае Ч false.
complete() - переводит ticket в завершенное состо€ние.

 */
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
