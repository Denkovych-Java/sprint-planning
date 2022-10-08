package com.epam.rd.autotasks.sprintplanning.tickets;

/*
UserStory
UserStory (пользовательская история) представляет ticket, который может содержать зависимости. Зависимости — это другие экземпляры UserStory, которые должны быть завершены в первую очередь,
чтобы затем получилось завершить и зависящую от них UserStory. Зависимости передаются через конструктор класса UserStory.
complete() - как и метод Ticket#complete() — переводит ticket в завершенное состояние. Разница лишь в том, что история пользователя может не быть завершена, если его зависимости еще не завершены.
getDependencies() - возвращает защитную копию массива зависимостей.
toString() - возвращает строку, представляющую историю пользователя, используя ее идентификатор и имя. Пример: "[US 1] Объект регистрации пользователя".
Bug
Багом считается ticket, относящийся к завершенной UserStory. Баги не существуют сами по себе, без соответствующего им экземпляра UserStory.
createBug(int id, String name, int estimate, UserStory userStory) - статический метод создания экземпляра Bug. Возвращает null, если UserStory имеет значение null или не завершена.
 В противном случае возвращает созданный экземпляр Bug.
toString() - возвращает строковое представление этого бага, используя идентификатор, имя и имя соответствующей UserStory. Пример: с идентификатором = 2, именем бага = "Добавить повторяющийся пароль" и
 именем соответствующей UserStory = "Форма регистрации" в результате получим "[Bug 2] Форма регистрации: Добавить повторяющийся пароль".
Sprint
Спринты имеют временную емкость и ограничение количества ticket’ов, которые задаются через конструктор. Спринт не может содержать ticket’ы с суммарной оценкой времени выполнения, превышающей временную емкость спринта.
 Не допускается, чтобы спринт содержал больше ticket’ов, чем определено ограничением количества ticket’ов для этого спринта. Спринт должен принимать ticket’ы с помощью методов add*.
Єти методы возвращают true, когда входной ticket был принят в спринт, и false в противном случае. Обратите внимание, что спринт не должен принимать:
Значения null.
ticket’ы, которые уже завершены.
ticket’ы, имеющие значение оценки времени выполнения, которое, в случае добавления ticket’а, приведёт к переполнению временной емкость спринта.
Любой ticket, если достигнут предел количества ticket’ов в спринте.
addUserStory(UserStory userStory) - принимает userStory, если она не равна null, не завершена и её незавершенные зависимости, если такие есть, уже приняты в спринт.
Возвращает true, если история пользователя принята, в противном случае false.
addBug(Bug bugReport) - принимает bug, если он не равен null и не завершен. Возвращает true, если баг принят, в противном случае false.
getTickets() - возвращает защитную копию массива ticket’ов на спринт. Убедитесь, что ticket’ы расположены в том же порядке, в каком они были приняты в спринт.
getTotalEstimate() - возвращает сумму оценок времени выполнения всех ticket’ов, принятых на спринт.
Важное ограничение: обратите внимание, что в этом упражнении вы не можете использовать коллекции и потоки.

 */

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
