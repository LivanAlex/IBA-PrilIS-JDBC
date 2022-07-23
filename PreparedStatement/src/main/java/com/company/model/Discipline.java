package com.company.model;

public class Discipline {
    private long id;
    private String disciplineName;
    private int lecture;
    private int practical;
    private int lab;

    public Discipline() {
    }

    public Discipline(long id, String disciplineName, int lecture, int practical, int lab) {
        this.id = id;
        this.disciplineName = disciplineName;
        this.lecture = lecture;
        this.practical = practical;
        this.lab = lab;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDisciplineName() {
        return disciplineName;
    }

    public void setDisciplineName(String disciplineName) {
        this.disciplineName = disciplineName;
    }

    public int getLecture() {
        return lecture;
    }

    public void setLecture(int lecture) {
        this.lecture = lecture;
    }

    public int getPractical() {
        return practical;
    }

    public void setPractical(int practical) {
        this.practical = practical;
    }

    public int getLab() {
        return lab;
    }

    public void setLab(int lab) {
        this.lab = lab;
    }

    @Override
    public String toString() {
        return "Discipline{" +
                "id=" + id +
                ", disciplineName='" + disciplineName + '\'' +
                ", lecture=" + lecture +
                ", practical=" + practical +
                ", lab=" + lab +
                '}';
    }
}
