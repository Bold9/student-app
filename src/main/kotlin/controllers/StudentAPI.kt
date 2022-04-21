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


    /*  fun listActivestudent(): String {
          return if (students.isEmpty()) {
              "No student stored"
          } else {
              var listOfstudent = ""
              for (i in students.indices) {
                  if (!students[i].isstudentArchived)
                  listOfstudent += "${i}: ${student[i]} \n"
              }
              listOfstudent
          }
      }*/

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



