package lk.ijse.javaFX.bo.custom;

import lk.ijse.javaFX.bo.SuperBO;
import lk.ijse.javaFX.dto.CourseEnrollmentDTO;

import java.util.List;
import java.util.Optional;

public interface CourseEnrollmentBO extends SuperBO {

    List<CourseEnrollmentDTO> getAllStudentCourseDetails() throws Exception;

    String getLastStudentCourseDetailId() throws Exception;

    boolean saveStudentCourseDetails(CourseEnrollmentDTO courseEnrollmentDTO) throws Exception;

    boolean updateStudentCourseDetails(CourseEnrollmentDTO courseEnrollmentDTO) throws Exception;

    boolean deleteStudentCourseDetails(String id) throws Exception;

    List<String> getAllStudentCourseDetailIds() throws Exception;

    Optional<CourseEnrollmentDTO> findByStudentCourseDetailId(String id) throws Exception;
}
