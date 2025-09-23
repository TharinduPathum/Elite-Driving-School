package lk.ijse.javaFX.bo.custom;

import lk.ijse.javaFX.bo.SuperBO;
import lk.ijse.javaFX.dto.CoursesDTO;

import java.util.List;
import java.util.Optional;

public interface CourseBO extends SuperBO {

    List<CoursesDTO> getAllCourses() throws Exception;

    String getLastCourseId() throws Exception;

    boolean saveCourses(CoursesDTO t) throws Exception;

    boolean updateCourses(CoursesDTO t) throws Exception;

    boolean deleteCourses(String id) throws Exception;

    List<String> getAllCourseIds() throws Exception;

    Optional<CoursesDTO> findByCourseId(String id) throws Exception;

    String generateNewCourseId();
}
