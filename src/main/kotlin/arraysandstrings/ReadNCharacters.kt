package arraysandstrings

/**
 * The read4 API is defined in the parent class Reader4.
 * fun read4(buf4:CharArray): Int {}
 */

/*
class Solution:Reader4() {
    /**
     * @param  buf Destination buffer
     * @param  n   Number of characters to read
     * @return     The number of actual characters read
     */
    val buf4 = CharArray(4)
    var buf4pos = 4
    var buf4size = 4

    override fun read(buf:CharArray, n:Int): Int {
        //println("${buf4.contentToString()}, ${buf4pos.toString()}, ${buf4size.toString()}")
        var outPos = 0
        while (outPos < n && buf4size > 0) {
            while (buf4pos < buf4size && outPos < n) {
                buf[outPos++] = buf4[buf4pos++]
            }

            if (outPos < n) {
                buf4size = read4(buf4)
                buf4pos = 0
            }
        }
        return outPos
    }
}*/
