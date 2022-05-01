package controllers

import StudentAPI
import models.Student

//import models.Note
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertNull

class StudentAPITest {

    private var bscStudent: Student? = null
    private var summerStudent: Student? = null
    private var lawStudent: Student? = null
    private var mathStudent: Student? = null
    private var sportStudent: Student? = null
    private var populatedstudent: StudentAPI? = StudentAPI()
    private var emptystudent: StudentAPI? = StudentAPI()

    @BeforeEach
    fun setup() {
        bscStudent = Student("John", 8909, "Bsc Applied", 99, 6.0)
        summerStudent = Student("Bold", 4509, "Programming", 89, 8.0)
        lawStudent = Student("Ozioma", 7960, "Social studies", 78, 5.0)
        mathStudent = Student("Chidera", 6754, "Mathematics", 80, 7.0)
        sportStudent = Student("Tboy", 3000, "Sports & Recreation", 69, 6.0)

        //adding 5 student to the student api
        populatedstudent!!.add(bscStudent!!)
        populatedstudent!!.add(summerStudent!!)
        populatedstudent!!.add(lawStudent!!)
        populatedstudent!!.add(mathStudent!!)
        populatedstudent!!.add(sportStudent!!)
    }

    @AfterEach
    fun tearDown() {
        bscStudent = null
        summerStudent = null
        lawStudent = null
        mathStudent = null
        sportStudent = null
        populatedstudent = null
        emptystudent = null
    }

    @Nested
    inner class Addstudent {
        @Test
        fun `adding a student to a populated list adds to ArrayList`() {
            val newstudent = Student("Strong", 1000, "Architecture", 44, 6.0)
            assertEquals(5, populatedstudent!!.numberOfstudent())
            populatedstudent!!.add(newstudent)
            assertEquals(6, populatedstudent!!.numberOfstudent())
            assertEquals(newstudent, populatedstudent!!.findstudent(populatedstudent!!.numberOfstudent() - 1))
        }

        @Test
        fun `adding a student to an empty list adds to ArrayList`() {
            val newstudent = Student("Strong", 1000, "Architecture", 44, 6.0)
            assertEquals(0, emptystudent!!.numberOfstudent())
            (emptystudent!!.add(newstudent))
            assertEquals(1, emptystudent!!.numberOfstudent())
            assertEquals(newstudent, emptystudent!!.findstudent(emptystudent!!.numberOfstudent() - 1))
        }
    }

    @Nested
    inner class Liststudent {

        @Test
        fun `listAllstudent returns No student Stored message when ArrayList is empty`() {
            assertEquals(0, emptystudent!!.numberOfstudent())
            assertTrue(emptystudent!!.listAllstudent().lowercase().contains("no student"))
        }

        @Test
        fun `listAllstudent returns student when ArrayList has notes stored`() {
            assertEquals(5, populatedstudent!!.numberOfstudent())
            val studentString = populatedstudent!!.listAllstudent().lowercase()
            assertTrue(studentString.contains("bscStudent"))
            assertTrue(studentString.contains("summerStudent"))
            assertTrue(studentString.contains("lawStudent"))
            assertTrue(studentString.contains("mathStudent"))
            assertTrue(studentString.contains("sportStudent"))
        }
    }

    @Nested
    inner class Updatestudent {
        @Test
        fun `adding a student to a populated list adds to ArrayList`() {
            val newStudent = Student("blessing", 1500, "Engineering", 45,70.1)
            assertEquals(5, populatedstudent!!.numberOfstudent())
            assertTrue(populatedstudent!!.add(newStudent))
            assertEquals(6, populatedstudent!!.numberOfstudent())
            assertEquals(newStudent, populatedstudent!!.findstudent(populatedstudent!!.numberOfstudent() - 1))
        }

        @Test
        fun `adding a student to an empty list adds to ArrayList`() {
            val newStudent = Student("blessing", 1500, "Engineering", 45,70.1)
            assertEquals(0, emptystudent!!.numberOfstudent())
            assertTrue(emptystudent!!.add(newStudent))
            assertEquals(1, emptystudent!!.numberOfstudent())
            assertEquals(newStudent, emptystudent!!.findstudent(emptystudent!!.numberOfstudent() - 1))
        }
    }
/*
    @Nested
    inner class listActivestudent {

        @Test
        fun `listActivestudent returns No Notes Stored message when ArrayList is empty`() {
            assertEquals(0, emptystudent!!.numberOfstudent())
            assertTrue(emptystudent!!.listAllstudent().lowercase().contains("no student"))
        }

        @Test
        fun `listActivestudent returns student when ArrayList has notes stored`() {
            assertEquals(5, populatedstudent!!.numberOfstudent())
            val studentString = populatedstudent!!.listActivestudent().lowercase()
            assertTrue(studentString.contains("learning kotlin"))
            assertFalse(studentString.contains("code app"))
            assertTrue(studentString.contains("test app"))
            assertFalse(studentString.contains("swim"))
            assertTrue(studentString.contains("summer holiday"))
        }
    }

    @Nested
    inner class ListArchivedstudent {

        @Test
        fun `listArchivedstudent returns No student Stored message when ArrayList is empty`() {
            assertEquals(0, emptystudent!!.numberOfstudent())
            assertTrue(emptystudent!!.listAllstudent().lowercase().contains("no student"))
        }

        @Test
        fun `listArchivedNotes returns student when ArrayList has notes stored`() {
            assertEquals(5, populatedstudent!!.numberOfstudent())
            val studentString = populatedstudent!!.listArchivedstudent().lowercase()
            assertFalse(studentString.contains("learning kotlin"))
            assertTrue(studentString.contains("code app"))
            assertFalse(studentString.contains("test app"))
            assertTrue(studentString.contains("swim"))
            assertFalse(studentString.contains("summer holiday"))
        }
    }

    @Nested
    inner class numberOfArchivedstudent {

        @Test
        fun `numberOfArchivedstudent returns No student Stored message when ArrayList is empty`() {
            assertEquals(0, emptystudent!!.numberOfArchivedstudent())
            assertTrue(emptystudent!!.listArchivedstudent().lowercase().contains("no archived student stored"))
        }

        @Test
        fun `numberOfArchivedstudent returns Notes when ArrayList has student stored`() {
            assertEquals(2, populatedstudent!!.numberOfArchivedstudent())
            val student = populatedstudent!!.listArchivedstudent().lowercase()
            assertFalse(student.contains("learning kotlin"))
            assertTrue(student.contains("code app"))
            assertFalse(student.contains("test app"))
            assertTrue(student.contains("swim"))
            assertFalse(student.contains("summer holiday"))
        }
    }

    @Nested
    inner class numberOfActivestudent {

        @Test
        fun `numberOfActivestudent returns No student Stored message when ArrayList is empty`() {
            assertEquals(0, emptystudent!!.numberOfActivestudent())
            assertTrue(emptystudent!!.listActivestudent().lowercase().contains("no student stored"))
        }

        @Test
        fun `numberOfActivestudent returns student when ArrayList has notes stored`() {
            assertEquals(3, populatedstudent!!.numberOfActivestudent())
            val student = populatedstudent!!.listActivestudent().lowercase()
            assertTrue(student.contains("learning kotlin"))
            assertFalse(student.contains("code app"))
            assertTrue(student.contains("test app"))
            assertFalse(student.contains("swim"))
            assertTrue(student.contains("summer holiday"))
        }
    }*/

    @Nested
    inner class UpdatestudentCAOpoints{
        @Test
        fun `adding a studentCAOpoints to a populated list adds to ArrayList`() {
            val newStudent = Student("Michelle", 5000, "Business and Law", 45,50.1)
            assertEquals(5, populatedstudent!!.numberOfstudent())
            assertTrue(populatedstudent!!.add(newStudent))
            assertEquals(6, populatedstudent!!.numberOfstudent())
            assertEquals(newStudent, populatedstudent!!.findstudent(populatedstudent!!.numberOfstudent() - 1))
        }

        @Test
        fun `adding a studentCAOpoints to an empty list adds to ArrayList`() {
            val newStudent = Student("Michelle", 5000, "Business and Law", 45,50.1)
            assertEquals(0, emptystudent!!.numberOfstudent())
            assertTrue(emptystudent!!.add(newStudent))
            assertEquals(1, emptystudent!!.numberOfstudent())
            assertEquals(newStudent, emptystudent!!.findstudent(emptystudent!!.numberOfstudent() - 1))
        }
    }

    @Nested
    inner class Deletestudent {

        @Test
        fun `deleting a student that does not exist, returns null`() {
            assertNull(emptystudent!!.deletestudent(0))
            assertNull(populatedstudent!!.deletestudent(-1))
            assertNull(populatedstudent!!.deletestudent(5))
        }

        @Test
        fun `deleting a student that exists delete and returns deleted object`() {
            assertEquals(5, populatedstudent!!.numberOfstudent())
            assertEquals(summerStudent, populatedstudent!!.deletestudent(4))
            assertEquals(4, populatedstudent!!.numberOfstudent())
            assertEquals(mathStudent, populatedstudent!!.deletestudent(0))
            assertEquals(3, populatedstudent!!.numberOfstudent())
        }
    }


    @Nested
    inner class DeletestudentId {

        @Test
        fun `deleting a student that does not exist, returns null`() {
            assertNull(emptystudent!!.deletestudent(0))
            assertNull(populatedstudent!!.deletestudent(-1))
            assertNull(populatedstudent!!.deletestudent(5))
        }

        @Test
        fun `deleting a student that exists delete and returns deleted object`() {
            assertEquals(5, populatedstudent!!.numberOfstudent())
            assertEquals(summerStudent, populatedstudent!!.deletestudent(4))
            assertEquals(4, populatedstudent!!.numberOfstudent())
            assertEquals(mathStudent, populatedstudent!!.deletestudent(0))
            assertEquals(3, populatedstudent!!.numberOfstudent())
        }
    }
}


