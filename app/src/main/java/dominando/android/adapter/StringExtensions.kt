package dominando.android.adapter

import java.util.regex.Pattern

fun String.removeAccents() : String {
    val replaces = arrayListOf(
        "a",
        "e",
        "i",
        "o",
        "u",
        "c"
    )

    val patterns = arrayOf(
        Pattern.compile("[âãáàä]", Pattern.CASE_INSENSITIVE),
        Pattern.compile("[éèêë]", Pattern.CASE_INSENSITIVE),
        Pattern.compile("[íìîï]", Pattern.CASE_INSENSITIVE),
        Pattern.compile("[óòôõö]", Pattern.CASE_INSENSITIVE),
        Pattern.compile("[ç]", Pattern.CASE_INSENSITIVE)
    )

    var result = this

    for ((index, value) in patterns.withIndex()) {
        val matcher = value.matcher(result)
        result = matcher.replaceAll(replaces[index])
    }

    return result.lowercase()

}