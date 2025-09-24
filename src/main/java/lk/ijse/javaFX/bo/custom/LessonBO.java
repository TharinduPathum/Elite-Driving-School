package lk.ijse.javaFX.bo.custom;

import lk.ijse.javaFX.bo.SuperBO;
import lk.ijse.javaFX.dto.LessonsDTO;

import java.util.List;
import java.util.Optional;

public interface LessonBO extends SuperBO {

    List<LessonsDTO> getAllLessons() throws Exception;

    String getLastLessonId() throws Exception;

    boolean saveLessons(LessonsDTO lessonsDTO) throws Exception;

    boolean updateLessons(LessonsDTO lessonsDTO) throws Exception;

    boolean deleteLessons(String id) throws Exception;

    List<String> getAllLessonIds() throws Exception;

    Optional<LessonsDTO> findByLessonId(String id) throws Exception;
}
