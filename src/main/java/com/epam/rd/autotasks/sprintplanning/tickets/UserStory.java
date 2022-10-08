package com.epam.rd.autotasks.sprintplanning.tickets;

/*
UserStory
UserStory (���������������� �������) ������������ ticket, ������� ����� ��������� �����������. ����������� � ��� ������ ���������� UserStory, ������� ������ ���� ��������� � ������ �������,
����� ����� ���������� ��������� � ��������� �� ��� UserStory. ����������� ���������� ����� ����������� ������ UserStory.
complete() - ��� � ����� Ticket#complete() � ��������� ticket � ����������� ���������. ������� ���� � ���, ��� ������� ������������ ����� �� ���� ���������, ���� ��� ����������� ��� �� ���������.
getDependencies() - ���������� �������� ����� ������� ������������.
toString() - ���������� ������, �������������� ������� ������������, ��������� �� ������������� � ���. ������: "[US 1] ������ ����������� ������������".
Bug
����� ��������� ticket, ����������� � ����������� UserStory. ���� �� ���������� ���� �� ����, ��� ���������������� �� ���������� UserStory.
createBug(int id, String name, int estimate, UserStory userStory) - ����������� ����� �������� ���������� Bug. ���������� null, ���� UserStory ����� �������� null ��� �� ���������.
 � ��������� ������ ���������� ��������� ��������� Bug.
toString() - ���������� ��������� ������������� ����� ����, ��������� �������������, ��� � ��� ��������������� UserStory. ������: � ��������������� = 2, ������ ���� = "�������� ������������� ������" �
 ������ ��������������� UserStory = "����� �����������" � ���������� ������� "[Bug 2] ����� �����������: �������� ������������� ������".
Sprint
������� ����� ��������� ������� � ����������� ���������� ticket���, ������� �������� ����� �����������. ������ �� ����� ��������� ticket�� � ��������� ������� ������� ����������, ����������� ��������� ������� �������.
 �� �����������, ����� ������ �������� ������ ticket���, ��� ���������� ������������ ���������� ticket��� ��� ����� �������. ������ ������ ��������� ticket�� � ������� ������� add*.
��� ������ ���������� true, ����� ������� ticket ��� ������ � ������, � false � ��������� ������. �������� ��������, ��� ������ �� ������ ���������:
�������� null.
ticket��, ������� ��� ���������.
ticket��, ������� �������� ������ ������� ����������, �������, � ������ ���������� ticket��, ������� � ������������ ��������� ������� �������.
����� ticket, ���� ��������� ������ ���������� ticket��� � �������.
addUserStory(UserStory userStory) - ��������� userStory, ���� ��� �� ����� null, �� ��������� � � ������������� �����������, ���� ����� ����, ��� ������� � ������.
���������� true, ���� ������� ������������ �������, � ��������� ������ false.
addBug(Bug bugReport) - ��������� bug, ���� �� �� ����� null � �� ��������. ���������� true, ���� ��� ������, � ��������� ������ false.
getTickets() - ���������� �������� ����� ������� ticket��� �� ������. ���������, ��� ticket�� ����������� � ��� �� �������, � ����� ��� ���� ������� � ������.
getTotalEstimate() - ���������� ����� ������ ������� ���������� ���� ticket���, �������� �� ������.
������ �����������: �������� ��������, ��� � ���� ���������� �� �� ������ ������������ ��������� � ������.

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
