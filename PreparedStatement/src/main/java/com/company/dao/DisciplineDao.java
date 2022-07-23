package com.company.dao;

import com.company.model.Discipline;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DisciplineDao {

    PreparedStatement ps = null;
    ResultSet rs = null;
    int st;//status

    public int insert(Discipline discipline) {
        try (Connection con = ConnectionFactory.getConnection()) {
            String query = "insert into discipline(discipline_name, lecture, practical, lab) values (?,?,?,?)";
            ps = con.prepareStatement(query);
            ps.setString(1, discipline.getDisciplineName());
            ps.setInt(2, discipline.getLecture());
            ps.setInt(3, discipline.getPractical());
            ps.setInt(4, discipline.getLab());
            ps.executeUpdate();
            System.out.println("inserted discipline " + st);
        } catch (SQLIntegrityConstraintViolationException e) {
            st = -1;
            e.printStackTrace();
        } catch (Exception e) {
            st = -2;
            e.printStackTrace();
        }
        return st;
    }


    public List<Discipline> fetchAll() {
        List<Discipline> disciplineList = new ArrayList<Discipline>();

        try (Connection con = ConnectionFactory.getConnection()) {
            String query = "select * from discipline order by discipline_id";
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                Discipline discipline = getDisciplineFromResultSet(rs);
                disciplineList.add(discipline);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return disciplineList;
    }

    private Discipline getDisciplineFromResultSet(ResultSet rs) throws SQLException {
        Discipline discipline = new Discipline();
        discipline.setId(rs.getLong("discipline_id"));
        discipline.setDisciplineName(rs.getString("discipline_name"));
        discipline.setLecture(rs.getInt("lecture"));
        discipline.setPractical(rs.getInt("practical"));
        discipline.setLab(rs.getInt("lab"));
        return discipline;
    }


    public List<Discipline> fetchByName(String name) {
        List<Discipline> disciplineList = new ArrayList<>();
        try (Connection con = ConnectionFactory.getConnection()) {
            String query = "select * from discipline where discipline_name like ?";
            ps = con.prepareStatement(query);
            ps.setString(1, "%" + name + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                disciplineList.add(getDisciplineFromResultSet(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return disciplineList;
    }

    public List<Discipline> fetchByLectureRange(int startRange, int endRange) {
        List<Discipline> disciplineList = new ArrayList<>();
        try (Connection con = ConnectionFactory.getConnection()) {
            String query = "select * from discipline where lecture between ? and ?";
            ps = con.prepareStatement(query);
            ps.setInt(1, startRange);
            ps.setInt(2, endRange);
            rs = ps.executeQuery();
            while (rs.next()) {
                disciplineList.add(getDisciplineFromResultSet(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return disciplineList;
    }
}
