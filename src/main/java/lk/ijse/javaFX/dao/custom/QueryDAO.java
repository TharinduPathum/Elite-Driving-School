package lk.ijse.javaFX.dao.custom;

import lk.ijse.orm_coursework.dao.SuperDAO;

public interface QueryDAO extends SuperDAO {
    public int getStudentCountForLesson(String lessonId);
    double getTotalCourseAmountByStudentId(String studentId) throws Exception;
}
