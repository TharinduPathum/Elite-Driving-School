package lk.ijse.javaFX.dao.custom.impl;

import lk.ijse.javaFX.config.FactoryConfiguration;
import lk.ijse.javaFX.dao.custom.ManageCourseDAO;
import lk.ijse.javaFX.entity.CourseEnrollment;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Optional;

public class ManageCourseDAOImpl implements ManageCourseDAO {

    private final FactoryConfiguration factoryConfiguration = FactoryConfiguration.getInstance();

    @Override
    public List<CourseEnrollment> getAll() throws Exception {
        Session session = factoryConfiguration.getSession();
        try {
            Query<CourseEnrollment> query = session.createQuery("from CourseEnrollment where course.id=:courseId");
            List<CourseEnrollment> studentCourseDetailsList = query.list();
            return studentCourseDetailsList;
        }finally {
            session.close();
        }
    }

    @Override
    public String getLastId() throws Exception {
        Session session = factoryConfiguration.getSession();
        try {
            Query<String> query = session.createQuery("SELECT scd.std_course_id FROM CourseEnrollment scd ORDER BY scd.std_course_id DESC", String.class)
                    .setMaxResults(1);
            List<String> studentCourseList = query.list();
            if (studentCourseList.isEmpty()) {
                return null;
            }
            return studentCourseList.getFirst();
        } finally {
            session.close();
        }
    }

    @Override
    public boolean save(CourseEnrollment courseEnrollment) throws Exception {
        Session session = factoryConfiguration.getSession();
        Transaction transaction = session.beginTransaction();

        try {
            session.persist(courseEnrollment);
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
    public boolean update(CourseEnrollment courseEnrollment) throws Exception {
        Session session = factoryConfiguration.getSession();
        Transaction transaction = session.beginTransaction();

        try {
            session.merge(courseEnrollment);
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
        Session session  = factoryConfiguration.getSession();
        Transaction transaction = session.beginTransaction();

        try {
            CourseEnrollment courseEnrollment = (CourseEnrollment) session.get(CourseEnrollment.class, id);
            if (courseEnrollment != null) {
                session.remove(courseEnrollment);
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
            Query<String> query = session.createQuery("SELECT scd.std_course_id FROM CourseEnrollment scd", String.class);
            return   query.list();
        }finally {
            session.close();
        }
    }

    @Override
    public Optional<CourseEnrollment> findById(String id) throws Exception {
        Session session = factoryConfiguration.getSession();
        try {
            CourseEnrollment courseEnrollment = session.get(CourseEnrollment.class, id);
            return Optional.ofNullable(courseEnrollment);
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
            return "SCD-001";
        } else {
            int num = Integer.parseInt(lastId.split("-")[1]);
            num++;
            return String.format("SCD-%03d", num);
        }
    }
}
