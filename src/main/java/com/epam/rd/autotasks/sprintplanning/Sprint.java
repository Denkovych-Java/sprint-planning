package com.epam.rd.autotasks.sprintplanning;

import com.epam.rd.autotasks.sprintplanning.tickets.Bug;
import com.epam.rd.autotasks.sprintplanning.tickets.Ticket;
import com.epam.rd.autotasks.sprintplanning.tickets.UserStory;

/*        Sprint
        —принты имеют временную емкость и ограничение количества ticketТов, которые задаютс€ через конструктор. —принт не может содержать ticketТы с суммарной оценкой времени выполнени€, превышающей временную емкость спринта.
        Ќе допускаетс€, чтобы спринт содержал больше ticketТов, чем определено ограничением количества ticketТов дл€ этого спринта. —принт должен принимать ticketТы с помощью методов add*.
        ™ти методы возвращают true, когда входной ticket был прин€т в спринт, и false в противном случае. ќбратите внимание, что спринт не должен принимать:
        «начени€ null.
        ticketТы, которые уже завершены.
        ticketТы, имеющие значение оценки времени выполнени€, которое, в случае добавлени€ ticketТа, приведЄт к переполнению временной емкость спринта.
        Ћюбой ticket, если достигнут предел количества ticketТов в спринте.
        addUserStory(UserStory userStory) - принимает userStory, если она не равна null, не завершена и еЄ незавершенные зависимости, если такие есть, уже прин€ты в спринт.
        ¬озвращает true, если истори€ пользовател€ прин€та, в противном случае false.
        addBug(Bug bugReport) - принимает bug, если он не равен null и не завершен. ¬озвращает true, если баг прин€т, в противном случае false.
        getTickets() - возвращает защитную копию массива ticketТов на спринт. ”бедитесь, что ticketТы расположены в том же пор€дке, в каком они были прин€ты в спринт.
        getTotalEstimate() - возвращает сумму оценок времени выполнени€ всех ticketТов, прин€тых на спринт.
        ¬ажное ограничение: обратите внимание, что в этом упражнении вы не можете использовать коллекции и потоки.*/
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
