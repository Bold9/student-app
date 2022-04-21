import models.Student
import mu.KotlinLogging
import utils.ScannerInput
import utils.ScannerInput.readNextDouble
import utils.ScannerInput.readNextInt
import utils.ScannerInput.readNextLine
import java.lang.System.exit



private val logger = KotlinLogging.logger {}

fun main(args: Array<String>) {
    runMenu()
}

private val studentAPI = StudentAPI()



fun mainMenu() : Int {
    return ScannerInput.readNextInt(""" 
         > ----------------------------------
         > |        Student APP         |
         > ----------------------------------
         > | STUDENT MENU                      |
         > |   1) Add a student                |
         > |   2) List all student            |
         > |   3) Update a student             |
         > |   4) Delete a student             |
         > ----------------------------------
         > |   0) Exit                      |
         > ----------------------------------
         > ==>> """.trimMargin(">"))
}

fun runMenu() {
    do {
        val option = mainMenu()
        when (option) {
            1 -> addstudent()
            2 -> liststudent()
            3 -> updatestudent()
            4 -> deletestudent()
            5 -> listActivestudent()
            6 -> listArchivedstudent()
            7 -> numberOfArchivedstudent()
            8 -> numberOfActivestudent()
            0 -> exitApp()
            else -> System.out.println("Invalid option entered: ${option}")


        }
    } while (true)
}


fun addstudent(){
    //logger.info { "addstudent() function invoked" }
    val studentTitle = readNextLine("Enter a Name for the student: ")
    val sID = readNextInt("Enter an ID: ")
    val cName = readNextLine("Enter a course for the student: ")
    val sCAO = readNextInt("Enter CAO points: ")
    val sGrade = readNextDouble("Enter average grade")
    val isAdded = studentAPI.add(Student(studentTitle, sID, cName, sCAO, sGrade))

    if (isAdded) {
        println("Added Successfully")
    } else {
        println("Add Failed")
    }
}

fun liststudent(){
    //logger.info { "liststudent() function invoked" }
    println(studentAPI.listAllstudent())
}

fun updatestudent(){
    logger.info { "addstudent() function invoked" }
    liststudent()
    if (studentAPI.numberOfstudent() > 0) {
        //only ask the user to choose the student to update if student exist
        val indexToUpdate = readNextInt("Enter the index of the student to update: ")
        val name = readNextLine("Enter the name of the student to update: ")
        //pass the index of the student to studentAPI for updating and check for success.
        val studentToUpdate = studentAPI.updateStudent(indexToUpdate, name)
        if (studentToUpdate){
            println("Update Successful!")
        } else {
            println("Update student not Successful")
        }
    }
}

fun deletestudent(){
    //logger.info { "deletestudent() function invoked" }
    liststudent()
    if (studentAPI.numberOfstudent() > 0) {
        //only ask the user to choose the student to delete if student exist
        val indexToDelete = readNextInt("Enter the index of the student to delete: ")
        //pass the index of the student to studentAPI for deleting and check for success.
        val studentToDelete = studentAPI.deletestudent(indexToDelete)
        if (studentToDelete != null) {
            println("Delete Successful! Deleted student: ${studentToDelete.studentName}")
        } else {
            println("Delete student Successful")
        }
    }
}

fun exitApp(){
    println("Exiting...bye")
    exit(0)
}

fun listActivestudent() {
    //studentAPI.listActivestudent()
}

fun listArchivedstudent() {
    //studentAPI.listArchivedstudent()
}

fun numberOfArchivedstudent() {
    //helper method to determine how many archived notes there are
    // studentAPI.numberOfArchivedstudent()
}

fun numberOfActivestudent() {
    //helper method to determine how many active notes there are
    //studentAPI.numberOfActivestudent()
}


