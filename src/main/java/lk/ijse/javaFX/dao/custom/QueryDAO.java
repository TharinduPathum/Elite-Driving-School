package lk.ijse.javaFX.dao.custom;

import lk.ijse.javaFX.dao.SuperDAO;

public interface QueryDAO extends SuperDAO {

    public int getStdCountForALesson(String lessonId);

}
