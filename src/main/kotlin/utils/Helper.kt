package utils

object Helper {
    @JvmStatic
    fun validateNumber(numCheck:Int, numSmall:Int, numBig:Int):Boolean{
        // return(if(numCheck>=numSmall && numCheck<=numBig))
        return (numCheck in numSmall..numBig)

    }
}