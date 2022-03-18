package onlineassessment

class UniqueEmailAddresses {
    fun numUniqueEmails(emails: Array<String>): Int {
        val uniqueEmails = HashSet<String>()

        for (email in emails) {
            var name = email.substringBefore('@')
            name = name.replace(".", "")
            name = name.substringBefore('+')

            var domain = email.substringAfter('@')

            uniqueEmails.add("$name@$domain")
        }

        return uniqueEmails.size
    }
}

fun main() {
    println(UniqueEmailAddresses().numUniqueEmails(arrayOf(
        "test.email+alex@leetcode.com",
        "test.e.mail+bob.cathy@leetcode.com",
        "testemail+david@lee.tcode.com")))
}
