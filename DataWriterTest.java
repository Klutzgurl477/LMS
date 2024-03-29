import static org.junit.jupiter.api.Assertions.*;

import java.rmi.StubNotFoundException;
import java.util.ArrayList;
//import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DataWriterTest {
    //private UserList userList = UserList.getInstance();
    private ArrayList<User> users = DataLoader.loadUsers(); // this needs to hold the users.json with all the users
    private ArrayList<Course> courses = DataLoader.loadCourses(); // this needs to hold the courses.json with all the courses
    //private CourseList coursesList = CourseList.getInstance();
    //private ArrayList<Course> courses = CourseList.getInstance().getCourses();

    //@BeforeEach
    //@Test
	public void setup() {
		UserList.getInstance().getUsers().clear();
		DataWriter.saveUsers();
        //CourseList.getInstance().getCourses().clear();
        //DataWriter.saveCourses();
	}
	
	//@AfterEach
    //@Test
	public void tearDown() {
		UserList.getInstance().getUsers().clear();
		DataWriter.saveUsers();
        CourseList.getInstance().getCourses().clear();
        DataWriter.saveCourses();
	}

    @Test
    public void testWritingZeroUsers(){
        UserList.getInstance().getUsers().clear();
        DataWriter.saveUsers();
        assertEquals(0, UserList.getInstance().getUsers().size());
    }

    @Test
    public void testWritingUserName(){
        UserList.setUserList(users);
        DataWriter.saveUsers();
        ArrayList <User> writtenUsers = DataLoader.loadUsers();
        assertEquals("username", writtenUsers.get(0).getUserName());
    }

    @Test
    public void testWritingUserFirstName(){
        UserList.setUserList(users);
        DataWriter.saveUsers();
        ArrayList <User> writtenUsers = DataLoader.loadUsers();
        assertEquals("first", writtenUsers.get(0).getFirstName());
    }

    @Test
    public void testWritingUserLastName(){
        UserList.setUserList(users);
        DataWriter.saveUsers();
        ArrayList <User> writtenUsers = DataLoader.loadUsers();
        assertEquals("last", writtenUsers.get(0).getLastName());
    }

    @Test
    public void testWritingUserEmail(){
        UserList.setUserList(users);
        DataWriter.saveUsers();
        ArrayList <User> writtenUsers = DataLoader.loadUsers();
        assertEquals("email", writtenUsers.get(0).getEmail());
    }

    @Test
    public void testWritingUserPassword(){
        UserList.setUserList(users);
        DataWriter.saveUsers();
        ArrayList <User> writtenUsers = DataLoader.loadUsers();
        assertEquals("password", writtenUsers.get(0).getPassword());
    }

    @Test
    public void testWritingUserType(){
        UserList.setUserList(users);
        DataWriter.saveUsers();
        ArrayList <User> writtenUsers = DataLoader.loadUsers();
        assertEquals(1, writtenUsers.get(0).getType());
    }

    @Test
    public void testWritingOneUser(){
        Student newStudent = new Student("first", "last", "email", "username", "password");
        users.add(newStudent);
        UserList.setUserList(users);
        DataWriter.saveUsers();
        ArrayList <User> writtenUsers = DataLoader.loadUsers();
        assertEquals("username", writtenUsers.get(writtenUsers.size()-1).getUserName());
    }

    @Test
    public void testWritingNullUser(){
        Student newStudent = new Student("first", "last", "email", null , "password");
        users.add(newStudent);
        UserList.setUserList(users);
        DataWriter.saveUsers();
        ArrayList <User> writtenUsers = DataLoader.loadUsers();
        assertEquals(null, writtenUsers.get(users.size()-1).getUserName());
    }

    @Test
    public void testWritingEmptyUser(){
        Student newStudent = new Student(null, null, null, null , null);
        users.add(newStudent);
        UserList.setUserList(users);
        DataWriter.saveUsers();
        ArrayList <User> writtenUsers = DataLoader.loadUsers();
        assertEquals(null, writtenUsers.get(users.size()-1).getFirstName());
        assertEquals(null, writtenUsers.get(users.size()-1).getLastName());
        assertEquals(null, writtenUsers.get(users.size()-1).getEmail());
        assertEquals(null, writtenUsers.get(users.size()-1).getUserName());
        assertEquals(null, writtenUsers.get(users.size()-1).getPassword());
    }
 

    @Test
    public void testWritingCourseName(){
        CourseList.setCourseList(courses);
        DataWriter.saveCourses();
        ArrayList <Course> writtenCourses = DataLoader.loadCourses();
        assertEquals("Introduction to JavaScript", writtenCourses.get(0).getCourseName()); 
    }

    @Test
    public void testWritingZeroCourses(){
        CourseList.getInstance().getCourses().clear();
        DataWriter.saveCourses();
        assertEquals(0, CourseList.getInstance().getCourses().size());
    }

    @Test
    public void testWritingNullCourses(){
        Course newCourse = new Course(null,"description","JavaScript", "AuthorID");
        courses.add(newCourse);
        CourseList.setCourseList(courses);
        DataWriter.saveCourses();
        ArrayList <Course> wriitenCourses = DataLoader.loadCourses();
        assertEquals(null, wriitenCourses.get(courses.size()-1).getCourseName());
    }

    @Test
    public void testWritingOneCourse(){
        Course newCourse = new Course("Introduction to JavaScript", "JavaScript is a scripting language for creating dynamic web page content","JavaScript", "51dc7b49-b0a3-4a04-a3d0-4781d1efbedf");
        courses.add(newCourse);
        CourseList.setCourseList(courses);
        DataWriter.saveCourses();
        ArrayList <Course> writtenCourses = DataLoader.loadCourses();
        assertEquals("Introduction to JavaScript", writtenCourses.get(courses.size()-1).getCourseName());
    }

    @Test
    public void testWritingEmptyCourse(){
        Course newCourse = new Course(null,null,null,null);
        courses.add(newCourse);
        CourseList.setCourseList(courses);
        DataWriter.saveCourses();
        ArrayList <Course> writtenCourses = DataLoader.loadCourses();
        assertEquals(null, writtenCourses.get(courses.size()-1).getCourseName());
        assertEquals(null, writtenCourses.get(courses.size()-1).getDescription());
        assertEquals(null, writtenCourses.get(courses.size()-1).getLanguage());
        assertEquals(null, writtenCourses.get(courses.size()-1).getAuthorID());
    }

    @Test
    public void testWritingCourseComment(){
        CourseList.setCourseList(courses);
        DataWriter.saveCourses();
        ArrayList <Course> wriitenCourses = DataLoader.loadCourses();
        assertEquals("hello, world.", wriitenCourses.get(courses.size()-1).getCommentArray());
    }

    @Test
    public void testWritingCourseModuleName(){
        CourseList.setCourseList(courses);
        DataWriter.saveCourses();
        ArrayList <Course> wriitenCourses = DataLoader.loadCourses();
        assertEquals("Strings", wriitenCourses.get(courses.size()-1).getModuleNames());
    }

    @Test
    public void testWritingCourseGrades(){
        CourseList.setCourseList(courses);
        DataWriter.saveCourses();
        ArrayList <Course> wriitenCourses = DataLoader.loadCourses();
        assertEquals("95", wriitenCourses.get(courses.size()-1).gradesToString());
    }

    @Test
    public void testWritingCourseCertification(){
        CourseList.setCourseList(courses);
        DataWriter.saveCourses();
        ArrayList <Course> wriitenCourses = DataLoader.loadCourses();
        assertEquals("Congradulation", wriitenCourses.get(courses.size()-1).getCertificate());
    }
}