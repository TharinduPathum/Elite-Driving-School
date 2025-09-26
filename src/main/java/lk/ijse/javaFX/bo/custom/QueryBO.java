package lk.ijse.javaFX.bo.custom;

import lk.ijse.orm_coursework.bo.SuperBO;

public interface QueryBO extends SuperBO {
    double getTotalCourseAmountByStudentId(String studentId) throws Exception;
}
