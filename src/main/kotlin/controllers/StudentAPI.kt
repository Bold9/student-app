import models.Student



// deleting and updating or executing

class StudentAPI {

    private var students = ArrayList<Student>()

    fun add(student: Student): Boolean {
        return students.add(student)
    }

    fun listAllstudent(): String {
        return if (students.isEmpty()) {
            "No student stored"
        } else {
            var listOfstudent = ""
            for (i in students.indices) {

                listOfstudent += "${i}: ${students[i]} \n"
            }
            listOfstudent
        }

    }

    fun numberOfstudent(): Int {
        return students.size
    }

    fun updateStudent(indexToUpdate: Int, newName:String):Boolean {
        if (isValidListIndex(indexToUpdate, students)) {
            students[indexToUpdate].studentName=newName
            return true
        }
        return false
    }


    fun findstudent(index: Int): Student? {
        return if (isValidListIndex(index, students)) {
            students[index]
        } else null
    }

    //utility method to determine if an index is valid in a list.
    fun isValidListIndex(index: Int, list: List<Any>): Boolean {
        return (index >= 0 && index < list.size)
    }

      fun listStudentByCourse(cName:String): String {
          return if (students.isEmpty()) {
              "No student stored"
          } else {
              var listOfstudent = ""
              for (i in students.indices) {
                  if (students[i].courseName.equals(cName))
                  listOfstudent += "${i}: ${students[i]} \n"
              }
              listOfstudent
          }
      }

        fun liststudentByCAOpoints(points:Int): String{

            return if (students.isEmpty()) {
                "No points stored"
            } else {
                var listOfstudent = ""
                for (i in students.indices) {
                    if (students[i].studentCAOpoints>points)
                        listOfstudent += "${i}: ${students[i]} \n"
                }
                listOfstudent
            }
       }

    fun liststudentinSSD(cName:String): String {
        return if (students.isEmpty()) {
            "No student in SSD"
        } else {
            var listOfstudent = ""
            for (i in students.indices) {
                if (students[i].courseName.equals(cName))
                    listOfstudent += "${i}: ${students[i]} \n"
            }
            listOfstudent
        }
    }

    fun liststudentById(sID:Int): String {
        return if (students.isEmpty()) {
            "No ID stored"
        } else {
            var listOfstudent = ""
            for (i in students.indices) {
                if (students[i].studentId.equals(sID))
                    listOfstudent += "${i}: ${students[i]} \n"
            }
            listOfstudent
        }
    }

    /*  fun listArchivedstudent(): String {
          return if (numberOfArchivedstudent() == 0) {
              "No Archived student stored"
          } else {
              var listOfstudent = ""
              for (i in student.indices) {
                  if (student[i].isstudentArchived)
                      listOfstudent += "${i}: ${student[i]} \n"
              }
              listOfstudent
          }
      }*/


    /*   fun numberOfActivestudent(): Int {
           var counter = 0
           for (stud in student) {
               if (!student.isstudentArchived) {
                   counter++
               }
           }
           return counter
       }*/



//    fun numberOfArchivedstudent(): Int {
//        var counter = 0
//        for (student in student) {
//            if (student.isstudentArchived) {
//                counter++
//            }
//        }
//        return counter
//    }

    fun deletestudent(indexToDelete: Int): Student? {
        return if (isValidListIndex(indexToDelete, students)) {
            students.removeAt(indexToDelete)
        } else null
    }
}



