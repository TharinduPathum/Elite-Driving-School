package lk.ijse.javaFX.bo.custom.impl;

import lk.ijse.javaFX.bo.custom.StudentBO;
import lk.ijse.javaFX.bo.exception.DuplicateException;
import lk.ijse.javaFX.bo.util.EntityDTOConverter;
import lk.ijse.javaFX.dao.DAOFactory;
import lk.ijse.javaFX.dao.DAOTypes;
import lk.ijse.javaFX.dao.custom.StudentDAO;
import lk.ijse.javaFX.dto.StudentsDTO;
import lk.ijse.javaFX.entity.Students;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StudentBOImpl implements StudentBO {

    private final StudentDAO studentDAO = DAOFactory.getInstance().getDAO(DAOTypes.STUDENT);
    private final EntityDTOConverter converter = new EntityDTOConverter();


    @Override
    public List<StudentsDTO> getAllStudents() throws Exception {
        List<Students> studentsList = studentDAO.getAll();
        List<StudentsDTO> studentsDTOList = new ArrayList<>();
        for (Students students : studentsList) {
            studentsDTOList.add(converter.getStudentsDTO(students));
        }
        return studentsDTOList;
    }

    @Override
    public String getLastStudentId() throws Exception {
        return studentDAO.getLastId();
    }

    @Override
    public boolean saveStudents(StudentsDTO t) throws Exception {
        Optional<Students> students = studentDAO.findById(t.getS_id());
        if (students.isPresent()) {
            throw new DuplicateException("Student already exists");
        }
        return studentDAO.save(converter.getStudentsEntity(t));
    }

    @Override
    public boolean updateStudents(StudentsDTO t) throws Exception {
        Optional<Students> students = studentDAO.findById(t.getS_id());
        if (students.isEmpty()) {
            throw new DuplicateException("Student Not Found");
        }
        return studentDAO.update(converter.getStudentsEntity(t));
    }

    @Override
    public boolean deleteStudents(String id) throws Exception {
        Optional<Students> students = studentDAO.findById(id);
        if (students.isEmpty()) {
            throw new DuplicateException("Student not found");
        }
        return studentDAO.delete(id);
    }

    @Override
    public List<String> getAllStudentIds() throws Exception {
        return studentDAO.getAllIds();
    }

    @Override
    public Optional<StudentsDTO> findByStudentId(String id) throws Exception {
        Optional<Students> students = studentDAO.findById(id);
        if (students.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(converter.getStudentsDTO(students.get()));
    }

    @Override
    public String generateNewStudentId() {
        return studentDAO.generateNewId();
    }
}
