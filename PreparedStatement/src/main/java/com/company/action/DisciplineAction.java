package com.company.action;

import com.company.dao.DisciplineDao;
import com.company.model.Discipline;

import java.util.List;

public class DisciplineAction {

    DisciplineDao dao = new DisciplineDao();
    int st;

    public void fetchAll() {
        List<Discipline> disciplineList = dao.fetchAll();
        if (disciplineList.isEmpty()) {
            System.out.println("No Record Found");
        } else {
            System.out.println("Discipline Details are :");
            for (Discipline discipline : disciplineList) {
                System.out.println(discipline);
            }
        }
    }

    public void insert(Discipline discipline) {
        st = dao.insert(discipline);
        if (st == 1) {
            System.out.println("Discipline Inserted Successfully");
        } else if (st == -1) {
            System.out.println("Discipline Already exists");
        } else {
            System.out.println("Unable to Insert Discipline");
        }
    }

    public void fetchDisciplineByName(String name) {
        List<Discipline> disciplineList= dao.fetchByName(name);
        if (disciplineList.isEmpty()) {
            System.out.println("No Record Found");
        } else {
            System.out.println("Discipline Details are :");
            for (Discipline discipline : disciplineList) {
                System.out.println(discipline);
            }
        }
    }

    public void fetchDisciplineByLectureRange(int startRange, int endRange) {
        List<Discipline> disciplineList= dao.fetchByLectureRange(startRange, endRange);
        if (disciplineList.isEmpty()) {
            System.out.println("No Record Found");
        } else {
            System.out.println("Discipline Details are :");
            for (Discipline discipline : disciplineList) {
                System.out.println(discipline);
            }
        }
    }
}
