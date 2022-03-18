package onlineassessment

class LicenseKeyFormatting {

    fun licenseKeyFormatting(s: String, k: Int): String {
        val sb = StringBuilder()
        var counter = 0
        for (i in s.indices.reversed()) {
            if (s[i] != '-') {
                counter++
                sb.insert(0, s[i].toUpperCase())
                if (counter % k == 0) {
                    sb.insert(0,'-')
                }
            }
        }
        return sb.toString().trim('-')
    }
}

fun main() {
    println(LicenseKeyFormatting().licenseKeyFormatting("--a-a-a-a--", k = 2))
}


