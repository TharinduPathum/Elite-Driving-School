package lk.ijse.javaFX.bo.custom.impl;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import lk.ijse.javaFX.bo.custom.LessonBO;
import lk.ijse.javaFX.bo.exception.DuplicateException;
import lk.ijse.javaFX.bo.exception.NotFoundException;
import lk.ijse.javaFX.bo.util.EntityDTOConverter;
import lk.ijse.javaFX.dao.DAOFactory;
import lk.ijse.javaFX.dao.DAOTypes;
import lk.ijse.javaFX.dao.custom.CourseDAO;
import lk.ijse.javaFX.dao.custom.InstructorDAO;
import lk.ijse.javaFX.dao.custom.LessonDAO;
import lk.ijse.javaFX.dao.custom.QueryDAO;
import lk.ijse.javaFX.dto.LessonsDTO;
import lk.ijse.javaFX.entity.Lessons;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class LessonBOImpl implements LessonBO {

    private final LessonDAO lessonsDAO = (LessonDAO) DAOFactory.getInstance().getDAO(DAOTypes.LESSON);
    private final CourseDAO courseDAO = (CourseDAO) DAOFactory.getInstance().getDAO(DAOTypes.COURSE);
    private final InstructorDAO instructorDAO =  (InstructorDAO) DAOFactory.getInstance().getDAO(DAOTypes.INSTRUCTOR);
    private final QueryDAO queryDAO = (QueryDAO) DAOFactory.getInstance().getDAO(DAOTypes.QUERY);
    private final EntityDTOConverter converter = new EntityDTOConverter();

    @Override
    public List<LessonsDTO> getAllLessons() throws Exception {
        List<Lessons> lessons = lessonsDAO.getAll();
        List<LessonsDTO> lessonsDTOS = new ArrayList<>();
        for (Lessons lesson : lessons) {
            lessonsDTOS.add(converter.getLessonsDTO(lesson));
        }
        return lessonsDTOS;
    }

    @Override
    public String getLastLessonId() throws Exception {
        return lessonsDAO.getLastId();
    }

    @Override
    public boolean saveLessons(LessonsDTO lessonsDTO) throws Exception {
        //check course exist
        boolean courseExists = courseDAO.findById(lessonsDTO.getC_id()).isPresent();

        // check instructor exists
        boolean instructorExists = instructorDAO.findById(lessonsDTO.getC_id()).isPresent();

        if (courseExists && instructorExists) {
            return lessonsDAO.save(converter.getLessonsEntity(lessonsDTO));
        }
        throw new Exception("Lessons not saved");
    }

    @Override
    public boolean updateLessons(LessonsDTO lessonsDTO) throws Exception {
        Optional<Lessons> lessons = lessonsDAO.findById(lessonsDTO.getL_id());
        if (lessons.isEmpty()) {
            throw new DuplicateException("Lessons Not Found");
        }
        return lessonsDAO.update(converter.getLessonsEntity(lessonsDTO));
    }

    @Override
    public boolean deleteLessons(String id) throws Exception {
        Optional<Lessons> lesson = lessonsDAO.findById(id);
        if (lesson.isEmpty()) {
            throw new NotFoundException("Lesson not found");
        }

        int studentsEnrolled = queryDAO.getStdCountForALesson(id);
        if (studentsEnrolled > 0) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION,
                    "Students are enrolled in this lesson. Are you sure you want to delete?",
                    ButtonType.YES,
                    ButtonType.NO);
            alert.setTitle("Confirmation");
            alert.setHeaderText(null);

            ButtonType result = alert.showAndWait().orElse(ButtonType.NO);
            if (result != ButtonType.YES) {
                return false; // User cancelled deletion
            }
        }

        return lessonsDAO.delete(id);
    }

    @Override
    public List<String> getAllLessonIds() throws Exception {
        return lessonsDAO.getAllIds();
    }

    @Override
    public Optional<LessonsDTO> findByLessonId(String id) throws Exception {
        Optional<Lessons> lessons = lessonsDAO.findById(id);
        if (lessons.isPresent()) {
            return Optional.of(converter.getLessonsDTO(lessons.get()));
        }
        return Optional.empty();
    }
}
