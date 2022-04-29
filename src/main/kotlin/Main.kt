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
         > |   4) Delete a student 
         >     5) search by course name 
         >     6) list all students in SSD
         >     7) list student By CAO points
         >     8) search by ID
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
            5 -> liststudentBycourse()
            6 -> liststudentinSSD()
            7 -> liststudentByCAOpoints()
            8 -> liststudentById()
            0 -> exitApp()
            else -> System.out.println("Invalid option entered: ${option}")


        }
    } while (true)
}


fun addstudent() {
    //logger.info { "addstudent() function invoked" }
    val studentTitle = readNextLine("Enter a Name for the student: ")
    var sID=0
    do{
         sID = readNextInt("Enter an ID between 1000 and 9999: ")
}while (!utils.Helper.validateNumber(sID, 1000, 9999))
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
    println("Exiting...come back soon")
    exit(0)
}

fun liststudentBycourse(){
    var coursename= readNextLine("Enter the course you are looking for")
    println (studentAPI.listStudentByCourse(coursename))
}

fun liststudentinSSD(){
    //var ssd= readNextLine("List ")
    println (studentAPI.liststudentinSSD("SSD"))
}

fun liststudentByCAOpoints(){
    val studentCAOpoints= readNextInt("Enter the points you are looking for")
    println (studentAPI.liststudentByCAOpoints(studentCAOpoints))
}

fun liststudentById(){
    val studentId= readNextInt("Enter the ID you are looking for")
    println (studentAPI.liststudentById(studentId))
}


