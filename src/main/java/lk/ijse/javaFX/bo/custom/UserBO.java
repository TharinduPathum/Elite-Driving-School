package lk.ijse.javaFX.bo.custom;

import lk.ijse.javaFX.bo.SuperBO;
import lk.ijse.javaFX.dto.UsersDTO;

import java.util.List;
import java.util.Optional;

public interface UserBO extends SuperBO {

    List<UsersDTO> getAllUsers() throws Exception;

    String getLastUserId() throws Exception;

    boolean saveUsers(UsersDTO usersDTO) throws Exception;

    boolean updateUsers(UsersDTO usersDTO) throws Exception;

    boolean deleteUsers(String id) throws Exception;

    List<String> getAllUserIds() throws Exception;

    Optional<UsersDTO> findByUserId(String id) throws Exception;

    String generateNextUserId();
}
