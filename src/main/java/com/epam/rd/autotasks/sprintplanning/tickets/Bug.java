package com.epam.rd.autotasks.sprintplanning.tickets;

/*Bug
        ����� ��������� ticket, ����������� � ����������� UserStory. ���� �� ���������� ���� �� ����, ��� ���������������� �� ���������� UserStory.
        createBug(int id, String name, int estimate, UserStory userStory) - ����������� ����� �������� ���������� Bug. ���������� null, ���� UserStory ����� �������� null ��� �� ���������.
        � ��������� ������ ���������� ��������� ��������� Bug.
        toString() - ���������� ��������� ������������� ����� ����, ��������� �������������, ��� � ��� ��������������� UserStory. ������: � ��������������� = 2, ������ ���� = "�������� ������������� ������" �
        ������ ��������������� UserStory = "����� �����������" � ���������� ������� "[Bug 2] ����� �����������: �������� ������������� ������".

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
