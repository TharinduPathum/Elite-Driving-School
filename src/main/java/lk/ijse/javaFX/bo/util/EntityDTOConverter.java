package lk.ijse.javaFX.bo.util;


import lk.ijse.javaFX.dto.*;
import lk.ijse.javaFX.entity.*;

import java.lang.reflect.Field;

public class EntityDTOConverter {

    public CoursesDTO getCourseDTO(Course course){
        CoursesDTO dto=new CoursesDTO();
        dto.setC_id(course.getC_id());
        dto.setName(course.getName());
        dto.setDuration(course.getDuration());
        dto.setFee(course.getFee());
        dto.setI_id(course.getInstructor().getI_id());
        return dto;
    }

    public Course getCourseEntity(CoursesDTO coursesDTO){
        Course course=new Course();
        Instructors instructor =new Instructors();
        course.setC_id(coursesDTO.getC_id());
        course.setName(coursesDTO.getName());
        course.setDuration(coursesDTO.getDuration());
        course.setFee(coursesDTO.getFee());
        instructor.setI_id(coursesDTO.getI_id());
        course.setInstructor(instructor);
        return course;
    }

    public InstructorsDTO getInstructorsDTO(Instructors instructor){
        InstructorsDTO dto=new InstructorsDTO();
        dto.setI_id(instructor.getI_id());
        dto.setName(instructor.getName());
        dto.setEmail(instructor.getEmail());
        dto.setSpecialization(instructor.getSpecialization());
        dto.setAvailability(instructor.getAvailability());
        return dto;
    }

    public Instructors getInstructorsEntity(InstructorsDTO instructorsDTO){
        Instructors instructor =new Instructors();
        instructor.setI_id(instructorsDTO.getI_id());
        instructor.setName(instructorsDTO.getName());
        instructor.setEmail(instructorsDTO.getEmail());
        instructor.setSpecialization(instructorsDTO.getSpecialization());
        instructor.setAvailability(instructorsDTO.getAvailability());
        return instructor;
    }

    public LessonsDTO getLessonsDTO(Lessons lessons){
        LessonsDTO dto=new LessonsDTO();
        dto.setL_id(lessons.getL_id());
        dto.setDate(lessons.getDate());
        dto.setStartTime(lessons.getStartTime());
        dto.setEndTime(lessons.getEndTime());
        dto.setS_id(lessons.getStudents().getS_id());
        dto.setC_id(lessons.getCourse().getC_id());
        dto.setI_id(lessons.getInstructors().getI_id());
        return dto;
    }

    public  Lessons getLessonsEntity(LessonsDTO lessonsDTO){
        Lessons lessons=new Lessons();
        Instructors instructor =new Instructors();
        Course course=new Course();
        Students student=new Students();
        lessons.setL_id(lessonsDTO.getL_id());
        lessons.setDate(lessonsDTO.getDate());
        lessons.setStartTime(lessonsDTO.getStartTime());
        lessons.setEndTime(lessonsDTO.getEndTime());
        student.setS_id(lessonsDTO.getS_id());
        lessons.setStudents(student);
        course.setC_id(lessonsDTO.getC_id());
        lessons.setCourse(course);
        instructor.setI_id(lessonsDTO.getI_id());
        lessons.setInstructors(instructor);
        return lessons;
    }

    public PaymentsDTO getPaymentsDTO(Payments payments){
        PaymentsDTO dto=new PaymentsDTO();
        dto.setP_id(payments.getP_id());
        dto.setDate(payments.getDate());
        dto.setAmount(payments.getAmount());
        dto.setAmount(payments.getAmount());
        dto.setPaymentMethod(payments.getPaymentMethod());
        dto.setStatus(payments.getStatus());
        dto.setS_id(payments.getStudent().getS_id());
        return dto;
    }

    public Payments getPaymentsEntity(PaymentsDTO paymentsDTO){
        Payments payments=new Payments();
        Students students=new Students();
        payments.setP_id(paymentsDTO.getP_id());
        payments.setDate(paymentsDTO.getDate());
        payments.setAmount(paymentsDTO.getAmount());
        payments.setPaymentMethod(paymentsDTO.getPaymentMethod());
        payments.setStatus(paymentsDTO.getStatus());
        students.setS_id(paymentsDTO.getS_id());
        payments.setStudent(students);
        return payments;
    }

    public CourseEnrollmentDTO getStudentCourseDetailsDTO(CourseEnrollment courseEnrollment){
        CourseEnrollmentDTO dto=new CourseEnrollmentDTO();
        dto.setStd_course_id(courseEnrollment.getStd_course_id());
        dto.setDate(courseEnrollment.getEnrollmentDate());
        dto.setStatus(courseEnrollment.getStatus());
        dto.setS_id(courseEnrollment.getStudent().getS_id());
        dto.setC_id(courseEnrollment.getCourse().getC_id());
        return dto;
    }

    public CourseEnrollment getStudentCourseDetailsEntity(CourseEnrollmentDTO courseEnrollmentDTO){
        CourseEnrollment studentCourseDetails=new CourseEnrollment();
        Students students=new Students();
        Course course=new Course();
        studentCourseDetails.setStd_course_id(courseEnrollmentDTO.getStd_course_id());
        studentCourseDetails.setEnrollmentDate(courseEnrollmentDTO.getDate());
        studentCourseDetails.setStatus(courseEnrollmentDTO.getStatus());
        students.setS_id(courseEnrollmentDTO.getS_id());
        studentCourseDetails.setStudent(students);
        course.setC_id(courseEnrollmentDTO.getC_id());
        studentCourseDetails.setCourse(course);
        return studentCourseDetails;
    }

    public StudentsDTO getStudentsDTO(Students students){
        StudentsDTO dto=new StudentsDTO();
        dto.setS_id(students.getS_id());
        dto.setName(students.getName());
        dto.setEmail(students.getEmail());
        dto.setPhone(students.getPhone());
        dto.setRegistrationDate(students.getRegistrationDate());
        return dto;
    }

    public Students getStudentsEntity(StudentsDTO studentsDTO){
        Students students=new Students();
        students.setS_id(studentsDTO.getS_id());
        students.setName(studentsDTO.getName());
        students.setEmail(studentsDTO.getEmail());
        students.setPhone(studentsDTO.getPhone());
        students.setRegistrationDate(studentsDTO.getRegistrationDate());
        return students;
    }

    public UsersDTO getUserDTO(Users user){
        UsersDTO dto=new UsersDTO();
        dto.setU_id(user.getU_id());
        dto.setUserName(user.getUserName());
        dto.setPassWord(user.getPassword());
        dto.setRole(user.getRole());
        dto.setStatus(user.getStatus());
        return dto;
    }

    public Users getUserEntity(UsersDTO dto){
        Users user=new Users();
        user.setU_id(dto.getU_id());
        user.setUserName(dto.getUserName());
        user.setPassword(dto.getPassWord());
        user.setRole(dto.getRole());
        user.setStatus(dto.getStatus());
        return user;
    }
}
