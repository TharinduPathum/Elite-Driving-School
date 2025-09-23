package lk.ijse.javaFX.bo.custom.impl;

import lk.ijse.javaFX.bo.custom.CourseEnrollmentBO;
import lk.ijse.javaFX.bo.exception.DuplicateException;
import lk.ijse.javaFX.bo.util.EntityDTOConverter;
import lk.ijse.javaFX.dao.DAOFactory;
import lk.ijse.javaFX.dao.DAOTypes;
import lk.ijse.javaFX.dao.custom.CourseDAO;
import lk.ijse.javaFX.dao.custom.ManageCourseDAO;
import lk.ijse.javaFX.dao.custom.StudentDAO;
import lk.ijse.javaFX.dto.CourseEnrollmentDTO;
import lk.ijse.javaFX.entity.Course;
import lk.ijse.javaFX.entity.CourseEnrollment;
import lk.ijse.javaFX.entity.Students;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CourseEnrollmentBOImpl implements CourseEnrollmentBO {

    private final ManageCourseDAO manageCourseDAO = (ManageCourseDAO) DAOFactory.getInstance().getDAO(DAOTypes.COURSE_ENROLLMENT);
    private final StudentDAO studentDAO = (StudentDAO) DAOFactory.getInstance().getDAO(DAOTypes.STUDENT);
    private final CourseDAO courseDAO = (CourseDAO) DAOFactory.getInstance().getDAO(DAOTypes.COURSE);
    private final EntityDTOConverter converter = new EntityDTOConverter();


    @Override
    public List<CourseEnrollmentDTO> getAllStudentCourseDetails() throws Exception {
        List<CourseEnrollment> courseEnrollments = manageCourseDAO.getAll();
        List<CourseEnrollmentDTO> courseEnrollmentDTOS = new ArrayList<>();
        for (CourseEnrollment courseEnrollment : courseEnrollments) {
            courseEnrollmentDTOS.add(converter.convert(courseEnrollment, CourseEnrollmentDTO.class));
        }
        return courseEnrollmentDTOS;
    }

    @Override
    public String getLastStudentCourseDetailId() throws Exception {
        return ManageCourseDAO.getLastId();
    }

    @Override
    public boolean saveStudentCourseDetails(CourseEnrollmentDTO courseEnrollmentDTO) throws Exception {
        Optional<Students> studentExists = studentDAO.findById(courseEnrollmentDTO.getS_id());
        Optional<Course> courseExists = courseDAO.findById(courseEnrollmentDTO.getC_id());
        Optional<CourseEnrollment> studentCourseDetailsExists = ManageCourseDAO.findById(courseEnrollmentDTO.getStd_course_id());

        if (studentCourseDetailsExists.isPresent()) {
            throw new DuplicateException("Student Course Details already exists");
        }
        if (studentExists.isPresent() &&  courseExists.isPresent()) {
            return ManageCourseDAO.save(converter.getStudentCourseDetailsEntity(courseEnrollmentDTO));
        }
        throw new Exception("Student or Course not found");
    }

    @Override
    public boolean updateStudentCourseDetails(CourseEnrollmentDTO courseEnrollmentDTO) throws Exception {
        Optional<CourseEnrollment>  studentCourseDetailsExists = ManageCourseDAO.findById(courseEnrollmentDTO.getStd_course_id());
        if (studentCourseDetailsExists.isEmpty()) {
            throw new Exception("Student Course not found");
        }
        return ManageCourseDAO.update(converter.getStudentCourseDetailsEntity(courseEnrollmentDTO));
    }

    @Override
    public boolean deleteStudentCourseDetails(String id) throws Exception {
        Optional<CourseEnrollment>  studentCourseDetailsExists = manageCourseDAO.findById(id);
        if (studentCourseDetailsExists.isEmpty()) {
            throw new Exception("Student Course not found");
        }
        return manageCourseDAO.delete(id);
    }

    @Override
    public List<String> getAllStudentCourseDetailIds() throws Exception {
        return manageCourseDAO.getAllIds();
    }

    @Override
    public Optional<CourseEnrollmentDTO> findByStudentCourseDetailId(String id) throws Exception {
        Optional<CourseEnrollment> details = manageCourseDAO.findById(id);
        if (details.isPresent()) {
            return Optional.of(converter.getStudentCourseDetailsDTO(details.get()));
        } else {
            return Optional.empty();
        }
    }
}
