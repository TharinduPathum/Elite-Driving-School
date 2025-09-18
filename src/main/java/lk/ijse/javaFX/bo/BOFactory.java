package lk.ijse.javaFX.bo;

import lk.ijse.javaFX.bo.custom.impl.*;


public class BOFactory {

    private static BOFactory boFactory;

    private BOFactory() {
    }

    public static BOFactory getInstance() {
        return boFactory == null ? (boFactory = new BOFactory()) : boFactory;
    }

    @SuppressWarnings("unchecked")
    public <Hello extends SuperBO> Hello getBO(BOTypes boType) {
        return switch (boType) {
            case COURSE -> (Hello) new CourseBOImpl();
            case INSTRUCTOR -> (Hello)new InstructorBOImpl();
            case LESSON -> (Hello) new LessonBOImpl();
            case MANAGE_COURSE -> (Hello) new ManageCourseBOImpl();
            case MANAGE_STUDENT -> (Hello) new ManageStudentBOImpl();
            case STUDENT -> (Hello) new StudentBOImpl();

            default -> throw new IllegalArgumentException("Invalid BO Type: " + boType);
        };
    }


}