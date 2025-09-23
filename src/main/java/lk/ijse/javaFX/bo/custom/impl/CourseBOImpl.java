package lk.ijse.javaFX.bo.custom.impl;

import lk.ijse.javaFX.bo.custom.CourseBO;
import lk.ijse.javaFX.bo.exception.DuplicateException;
import lk.ijse.javaFX.bo.util.EntityDTOConverter;
import lk.ijse.javaFX.dao.DAOFactory;
import lk.ijse.javaFX.dao.DAOTypes;
import lk.ijse.javaFX.dao.custom.CourseDAO;
import lk.ijse.javaFX.dto.CoursesDTO;
import lk.ijse.javaFX.entity.Course;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CourseBOImpl implements CourseBO {

    private final CourseDAO courseDAO = (CourseDAO) DAOFactory.getInstance().getDAO(DAOTypes.COURSE);
    private final EntityDTOConverter entityDTOConverter = new EntityDTOConverter();


    @Override
    public List<CoursesDTO> getAllCourses() throws Exception {
        List<Course> courses = courseDAO.getAll();
        List<CoursesDTO> dtos = new ArrayList<>();
        for (Course course : courses) {
            dtos.add(EntityDTOConverter.convert(course , CoursesDTO.class));
        }
        return dtos;
    }

    @Override
    public String getLastCourseId() throws Exception {
        return courseDAO.getLastId();

    }

    @Override
    public boolean saveCourses(CoursesDTO coursesDTO) throws Exception {
        Optional<Course> course = courseDAO.findById(coursesDTO.getC_id());
        if (course.isPresent()) {
            throw new DuplicateException("Course already exists");
        }
        return courseDAO.save(entityDTOConverter.convert(coursesDTO, Course.class));
    }

    @Override
    public boolean updateCourses(CoursesDTO coursesDTO) throws Exception {
        Optional<Course> course = courseDAO.findById(coursesDTO.getC_id());
        if (course.isEmpty()) {
            throw new DuplicateException("Course not Found");
        }
        return courseDAO.save(entityDTOConverter.convert(coursesDTO, Course.class));
    }

    @Override
    public boolean deleteCourses(String id) throws Exception {
        Optional<Course> course = courseDAO.findById(id);
        if (course.isEmpty()) {
            throw new DuplicateException("Course not Found");
        }
        return courseDAO.delete(id);
    }

    @Override
    public List<String> getAllCourseIds() throws Exception {
        return courseDAO.getAllIds();
    }

    @Override
    public Optional<CoursesDTO> findByCourseId(String id) throws Exception {
        Optional<Course> course = courseDAO.findById(id);
        if (course.isPresent()) {
            return Optional.of(entityDTOConverter.convert(course.get(), CoursesDTO.class));
        }
        return Optional.empty();
    }

    @Override
    public String generateNewCourseId() {
        return "";
    }
}
