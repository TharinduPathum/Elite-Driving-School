package lk.ijse.javaFX.dao.custom.impl;

import lk.ijse.javaFX.config.FactoryConfiguration;
import lk.ijse.javaFX.dao.custom.InstructorDAO;
import lk.ijse.javaFX.entity.Instructors;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Optional;

public class InstructorDAOImpl implements InstructorDAO {

    private final FactoryConfiguration factoryConfiguration = FactoryConfiguration.getInstance();


    @Override
    public List<Instructors> getAll() throws Exception {
        Session session = factoryConfiguration.getSession();
        try {
            Query<Instructors> query = session.createQuery("from Instructors ", Instructors.class);
            List<Instructors> instructorList = query.list();
            return instructorList;
        }finally {
            session.close();
        }
    }

    @Override
    public String getLastId() throws Exception {
        Session session = factoryConfiguration.getSession();
        try {
            Query<String> query = session.createQuery("SELECT i.i_id FROM Instructors i ORDER BY i.i_id DESC", String.class)
                    .setMaxResults(1);
            List<String> instructorsList = query.list();
            if (instructorsList.isEmpty()) {
                return null;
            }
            return instructorsList.getFirst();
        } finally {
            session.close();
        }
    }

    @Override
    public boolean save(Instructors instructors) throws Exception {
        Session session = factoryConfiguration.getSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.persist(instructors);
            transaction.commit();
            return true;
        }catch (Exception e){
            transaction.rollback();
            return false;
        }finally {
            session.close();
        }
    }

    @Override
    public boolean update(Instructors instructors) throws Exception {
        Session session = factoryConfiguration.getSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.merge(instructors);
            transaction.commit();
            return true;
        }catch (Exception e){
            transaction.rollback();
            return false;
        }finally {
            session.close();
        }
    }

    @Override
    public boolean delete(String id) throws Exception {
        Session session = factoryConfiguration.getSession();
        Transaction transaction = session.beginTransaction();
        try {
            Instructors instructor = (Instructors) session.get(Instructors.class, id);
            if (instructor != null) {
                session.remove(instructor);
                transaction.commit();
                return true;
            }
            return false;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        } finally {
            session.close();
        }
    }

    @Override
    public List<String> getAllIds() throws Exception {
        Session session = factoryConfiguration.getSession();
        try {
            Query<String> query = session.createQuery("SELECT i.i_id FROM Instructors i", String.class);
            return query.list();
        } finally {
            session.close();
        }
    }

    @Override
    public Optional<Instructors> findById(String id) throws Exception {
        Session session = factoryConfiguration.getSession();
        try {
            Instructors instructor = session.get(Instructors.class, id);
            return Optional.ofNullable(instructor);
        } finally {
            session.close();
        }
    }

    @Override
    public String generateNewId() {
        String lastId = null;
        try {
            lastId = getLastId();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        if (lastId == null) {
            return "I-001";
        } else {
            int num = Integer.parseInt(lastId.split("-")[1]);
            num++;
            return String.format("I-%03d", num);
        }

    }
}
