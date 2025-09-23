package lk.ijse.javaFX.dao;

import lk.ijse.javaFX.bo.custom.impl.*;
import lk.ijse.javaFX.dao.custom.impl.*;

public class DAOFactory {

    private static DAOFactory daoFactory;

    private DAOFactory() {
    }

    public static DAOFactory getInstance() {
        return daoFactory == null ? (daoFactory = new DAOFactory()) : daoFactory;
    }

    public <T extends SuperDAO> T getDAO(DAOTypes daoType) {
        return switch (daoType) {
            case COURSE -> (T) new CourseDAOImpl();
            case INSTRUCTOR -> (T) new InstructorDAOImpl();
            case LESSON -> (T) new LessonDAOImpl();
            case COURSE_ENROLLMENT -> (T) new ManageCourseDAOImpl();
//            case -> (T) new ManageStudentDAOImpl();
            case STUDENT -> (T) new StudentDAOImpl();
            case PAYMENT -> (T) new PaymentDAOImpl();
            case USER -> (T) new UserDAOImpl();
            case QUERY -> (T) new QueryDAOImpl();

        };

    }
}
