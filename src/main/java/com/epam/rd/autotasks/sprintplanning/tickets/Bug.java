package com.epam.rd.autotasks.sprintplanning.tickets;

/*Bug
        Багом считается ticket, относящийся к завершенной UserStory. Баги не существуют сами по себе, без соответствующего им экземпляра UserStory.
        createBug(int id, String name, int estimate, UserStory userStory) - статический метод создания экземпляра Bug. Возвращает null, если UserStory имеет значение null или не завершена.
        В противном случае возвращает созданный экземпляр Bug.
        toString() - возвращает строковое представление этого бага, используя идентификатор, имя и имя соответствующей UserStory. Пример: с идентификатором = 2, именем бага = "Добавить повторяющийся пароль" и
        именем соответствующей UserStory = "Форма регистрации" в результате получим "[Bug 2] Форма регистрации: Добавить повторяющийся пароль".

*/
public class Bug extends Ticket {
    UserStory userStory;

    public static Bug createBug(int id, String name, int estimate, UserStory userStory) {
        if ((userStory == null) || (!userStory.isCompleted())) return null;
        else {
            return new Bug(id, name, estimate, userStory);
        }
    }

    private Bug(int id, String name, int estimate, UserStory userStory) {
        super(id, name, estimate);
        this.userStory = userStory;
    }

    @Override
    public String toString() {
        return "[Bug " + this.getId() + "] " + userStory.getName() + ": " + this.getName();
    }

}
