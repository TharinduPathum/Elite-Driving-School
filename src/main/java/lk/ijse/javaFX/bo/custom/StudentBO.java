package lk.ijse.javaFX.bo.custom;

import lk.ijse.javaFX.bo.SuperBO;
import lk.ijse.javaFX.dto.StudentsDTO;

import java.util.List;
import java.util.Optional;

public interface StudentBO extends SuperBO {

    List<StudentsDTO> getAllStudents() throws Exception;

    String getLastStudentId() throws Exception;

    boolean saveStudents(StudentsDTO t) throws Exception;

    boolean updateStudents(StudentsDTO t) throws Exception;

    boolean deleteStudents(String id) throws Exception;

    List<String> getAllStudentIds() throws Exception;

    Optional<StudentsDTO> findByStudentId(String id) throws Exception;

    String generateNewStudentId();
}

