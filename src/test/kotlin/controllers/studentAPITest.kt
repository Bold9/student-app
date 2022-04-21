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

    private var learnKotlin: StudentAPI? = null
    private var summerHoliday: StudentAPI? = null
    private var codeApp: StudentAPI? = null
    private var testApp: StudentAPI? = null
    private var swim: StudentAPI? = null
    private var populatedstudent: StudentAPI? = StudentAPI()
    private var emptystudent: StudentAPI? = StudentAPI()

    @BeforeEach
    fun setup() {
        learnKotlin = StudentAPI("Learning Kotlin", 5, "College", false)
        summerHoliday = StudentAPI("Summer Holiday to France", 1, "Holiday", false)
        codeApp = StudentAPI("Code App", 4, "Work", true)
        testApp = StudentAPI("Test App", 4, "Work", false)
        swim = StudentAPI("Swim - Pool", 3, "Hobby", true)

        //adding 5 student to the student api
        populatedstudent!!.add(learnKotlin!!)
        populatedstudent!!.add(summerHoliday!!)
        populatedstudent!!.add(codeApp!!)
        populatedstudent!!.add(testApp!!)
        populatedstudent!!.add(swim!!)
    }

    @AfterEach
    fun tearDown() {
        learnKotlin = null
        summerHoliday = null
        codeApp = null
        testApp = null
        swim = null
        populatedstudent = null
        emptystudent = null
    }

    @Nested
    inner class Addstudent {
        @Test
        fun `adding a student to a populated list adds to ArrayList`() {
            val newstudent = Student("Study Lambdas", 1, "College", 44"")
            assertEquals(5, populatedstudent!!.numberOfstudent())
            assertTrue(populatedstudent!!.add(newstudent))
            assertEquals(6, populatedstudent!!.numberOfstudent())
            assertEquals(newstudent, populatedstudent!!.findstudent(populatedstudent!!.numberOfstudent() - 1))
        }

        @Test
        fun `adding a student to an empty list adds to ArrayList`() {
            val newstudent = Student("Study Lambdas", 1, "College", 44 "")
            assertEquals(0, emptystudent!!.numberOfstudent())
            assertTrue(emptystudent!!.add(newstudent))
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
            assertTrue(studentString.contains("learning kotlin"))
            assertTrue(studentString.contains("code app"))
            assertTrue(studentString.contains("test app"))
            assertTrue(studentString.contains("swim"))
            assertTrue(studentString.contains("summer holiday"))
        }
    }



    @Nested
    inner class Updatestudent {
        @Test
        fun `adding a student to a populated list adds to ArrayList`() {
            val newStudent = Student("Study Lambdas", 1, "College", 45"")
            assertEquals(5, populatedstudent!!.numberOfstudent())
            assertTrue(populatedstudent!!.add(newStudent))
            assertEquals(6, populatedstudent!!.numberOfstudent())
            assertEquals(newStudent, populatedstudent!!.findstudent(populatedstudent!!.numberOfstudent() - 1))
        }

        @Test
        fun `adding a student to an empty list adds to ArrayList`() {
            val newStudent = Student("Study Lambdas", 1, "College", 45"")
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
    inner class Deletestudent {

        @Test
        fun `deleting a student that does not exist, returns null`() {
            assertNull(emptystudent!!.deletestudent(0))
            assertNull(populatedstudent!!.deletestudent(-1))
            assertNull(populatedstudent!!.deletestudent(5))
        }

        @Test
        fun `deleting a note that exists delete and returns deleted object`() {
            assertEquals(5, populatedstudent!!.numberOfstudent())
            assertEquals(swim, populatedstudent!!.deletestudent(4))
            assertEquals(4, populatedstudent!!.numberOfstudent())
            assertEquals(learnKotlin, populatedstudent!!.deletestudent(0))
            assertEquals(3, populatedstudent!!.numberOfstudent())
        }
    }
}

