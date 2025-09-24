package lk.ijse.javaFX.bo.custom.impl;

import lk.ijse.javaFX.bo.custom.InstructorBO;
import lk.ijse.javaFX.bo.util.EntityDTOConverter;
import lk.ijse.javaFX.dao.DAOFactory;
import lk.ijse.javaFX.dao.custom.InstructorDAO;
import lk.ijse.javaFX.dao.DAOTypes;
import lk.ijse.javaFX.dto.InstructorsDTO;
import lk.ijse.javaFX.entity.Instructors;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InstructorBOImpl implements InstructorBO {

    private final InstructorDAO instructorDAO = DAOFactory.getInstance().getDAO(DAOTypes.INSTRUCTOR);
    private final EntityDTOConverter convertor = new EntityDTOConverter();

    @Override
    public List<InstructorsDTO> getAllInstructors() throws Exception {
        List<Instructors> instructors = instructorDAO.getAll();
        List<InstructorsDTO> instructorDTOs = new ArrayList<>();
        for (Instructors instructor : instructors) {
            instructorDTOs.add(convertor.getInstructorsDTO(instructor));
        }
        return instructorDTOs;
    }

    @Override
    public String getLastInstructorId() throws Exception {
        return instructorDAO.getLastId();
    }

    @Override
    public boolean saveInstructors(InstructorsDTO instructorsDTO) throws Exception {
        Optional<Instructors> instructors = instructorDAO.findById(instructorsDTO.getI_id());
        if (instructors.isPresent()) {
            throw new Exception("Instructor already exists");
        }
        return instructorDAO.save(convertor.getInstructorsEntity(instructorsDTO));
    }

    @Override
    public boolean updateInstructors(InstructorsDTO instructorsDTO) throws Exception {
        Optional<Instructors> instructors = instructorDAO.findById(instructorsDTO.getI_id());
        if (instructors.isEmpty()) {
            throw new Exception("Instructor Not Found");
        }
        return instructorDAO.update(convertor.getInstructorsEntity(instructorsDTO));
    }

    @Override
    public boolean deleteInstructors(String id) throws Exception {
        Optional<Instructors> instructors = instructorDAO.findById(id);
        if (instructors.isEmpty()) {
            throw new Exception("Instructor not Found");
        }
        return instructorDAO.delete(id);
    }

    @Override
    public List<String> getAllInstructorIds() throws Exception {
        return instructorDAO.getAllIds();
    }

    @Override
    public Optional<InstructorsDTO> findByInstructorId(String id) throws Exception {
        Optional<Instructors> instructors = instructorDAO.findById(id);
        if (instructors.isPresent()) {
            return Optional.of(convertor.getInstructorsDTO(instructors.get()));
        }
        return Optional.empty();
    }

    @Override
    public String generateNewInstructorsId() {
        return instructorDAO.generateNewId();
    }
}
