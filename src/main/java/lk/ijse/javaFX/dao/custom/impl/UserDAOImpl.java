package lk.ijse.javaFX.dao.custom.impl;

import lk.ijse.javaFX.config.FactoryConfiguration;
import lk.ijse.javaFX.dao.custom.UserDAO;
import lk.ijse.javaFX.entity.Users;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Optional;

public class UserDAOImpl implements UserDAO {

    private final FactoryConfiguration factoryConfiguration = FactoryConfiguration.getInstance();

    @Override
    public List<Users> getAll() throws Exception {
        Session session = factoryConfiguration.getSession();
        try {
            Query<Users> query = session.createQuery("from Users", Users.class);
            List<Users> list = query.getResultList();
            return list;
        }finally {
            session.close();
        }    }

    @Override
    public String getLastId() throws Exception {
        Session session = factoryConfiguration.getSession();

        try {
            Query<String> query = session.createQuery("SELECT use.id FROM Users use ORDER BY use.id DESC",
                    String.class).setMaxResults(1);
            List<String> studentList = query.list();
            if (studentList.isEmpty()) {
                return null;

            }
            return studentList.get(0);
        }finally {
            session.close();
        }    }

    @Override
    public boolean save(Users users) throws Exception {
        Session session = factoryConfiguration.getSession();
        Transaction transaction = session.beginTransaction();

        try {
            session.persist(users);
            transaction.commit();
            return true;
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
            return false;
        }finally {
            session.close();
        }
    }

    @Override
    public boolean update(Users users) throws Exception {
        Session session = factoryConfiguration.getSession();
        Transaction transaction = session.beginTransaction();

        try {
            session.merge(users);
            transaction.commit();
            return true;
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
            return false;
        }finally {
            session.close();
        }    }

    @Override
    public boolean delete(String id) throws Exception {
        Session session = factoryConfiguration.getSession();
        Transaction transaction = session.beginTransaction();
        try{
            Users users = session.get(Users.class,id);
            if (users != null) {
                session.remove(users);
                transaction.commit();
                return true;
            }
            return false;
        }catch (Exception e){
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
            return false;
        }finally {
            session.close();
        }
    }

    @Override
    public List<String> getAllIds() throws Exception {
        Session session = factoryConfiguration.getSession();
        try {
            Query<String> query = session.createQuery("SELECT u.u_id FROM Users u", String.class);
            return query.list();
        } finally {
            session.close();
        }    }

    @Override
    public Optional<Users> findById(String id) throws Exception {
        Session session = factoryConfiguration.getSession();

        try {
            Users users = session.get(Users.class,id);
            return Optional.ofNullable(users);
        }finally {
            session.close();
        }    }

    @Override
    public String generateNewId() {
        String lastId = null;
        try {
            lastId = getLastId();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        if (lastId == null) {
            return "U-001";
        } else {
            int num = Integer.parseInt(lastId.split("-")[1]);
            num++;
            return String.format("U-%03d", num);
        }    }
}
