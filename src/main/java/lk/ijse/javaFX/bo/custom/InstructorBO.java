package lk.ijse.javaFX.bo.custom;

import lk.ijse.javaFX.bo.SuperBO;
import lk.ijse.javaFX.dto.InstructorsDTO;

import java.util.List;
import java.util.Optional;

public interface InstructorBO extends SuperBO {

    List<InstructorsDTO> getAllInstructors() throws Exception;

    String getLastInstructorId() throws Exception;

    boolean saveInstructors(InstructorsDTO instructorsDTO) throws Exception;

    boolean updateInstructors(InstructorsDTO instructorsDTO) throws Exception;

    boolean deleteInstructors(String id) throws Exception;

    List<String> getAllInstructorIds() throws Exception;

    Optional<InstructorsDTO> findByInstructorId(String id) throws Exception;

    String generateNewInstructorsId();
}
