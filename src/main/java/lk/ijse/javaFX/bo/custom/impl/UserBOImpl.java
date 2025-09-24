package lk.ijse.javaFX.bo.custom.impl;

import lk.ijse.javaFX.bo.custom.UserBO;
import lk.ijse.javaFX.bo.exception.DuplicateException;
import lk.ijse.javaFX.bo.exception.NotFoundException;
import lk.ijse.javaFX.bo.util.EntityDTOConverter;
import lk.ijse.javaFX.dao.DAOFactory;
import lk.ijse.javaFX.dao.DAOTypes;
import lk.ijse.javaFX.dao.custom.UserDAO;
import lk.ijse.javaFX.dto.UsersDTO;
import lk.ijse.javaFX.entity.Users;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserBOImpl implements UserBO {

    private  final UserDAO userDAO = DAOFactory.getInstance().getDAO(DAOTypes.USER);
    private final EntityDTOConverter converter = new EntityDTOConverter();


    @Override
    public List<UsersDTO> getAllUsers() throws Exception {
        List<Users> userList = userDAO.getAll();
        List<UsersDTO> userDTOList = new ArrayList<>();
        for (Users user : userList) {
            userDTOList.add(converter.getUserDTO(user));
        }
        return userDTOList;
    }

    @Override
    public String getLastUserId() throws Exception {
        return userDAO.getLastId();

    }

    @Override
    public boolean saveUsers(UsersDTO usersDTO) throws Exception {
        Optional<Users> user = userDAO.findById(usersDTO.getU_id());
        if (user.isPresent()) {
            throw new DuplicateException("User already exists");
        }
        return userDAO.save(converter.getUserEntity(usersDTO));
    }

    @Override
    public boolean updateUsers(UsersDTO usersDTO) throws Exception {
        Optional<Users> user = userDAO.findById(usersDTO.getU_id());
        if (user.isEmpty()) {
            throw new NotFoundException("User not found");
        }
        return userDAO.update(converter.getUserEntity(usersDTO));
    }

    @Override
    public boolean deleteUsers(String id) throws Exception {
        Optional<Users> user = userDAO.findById(id);
        if (user.isEmpty()) {
            throw new NotFoundException("User not found");
        }
        return userDAO.delete(id);
    }

    @Override
    public List<String> getAllUserIds() throws Exception {
        return userDAO.getAllIds();
    }

    @Override
    public Optional<UsersDTO> findByUserId(String id) throws Exception {
        Optional<Users> user = userDAO.findById(id);
        if (user.isPresent()) {
            return Optional.of(converter.getUserDTO(user.get()));
        } else {
            return Optional.empty();
        }
    }

    @Override
    public String generateNextUserId() {
        return userDAO.generateNewId();
    }
}
