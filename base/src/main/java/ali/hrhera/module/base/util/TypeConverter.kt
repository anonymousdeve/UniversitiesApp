package ali.hrhera.module.base.util

import androidx.room.TypeConverter
import java.util.Collections

/**
 * Converts between a string and a list of strings.
 *
 * This class provides methods to convert a string to a list of strings and vice versa.
 * It is typically used in conjunction with Room database to store and retrieve data
 * in a format that is not directly supported by the database.
 */
class TypeConverter {
    /**
     * Converts a string to a list of strings.
     *
     * This method splits the input string based on a delimiter and returns the resulting list.
     * If the input string is empty, an empty list is returned.
     *
     * @param value The input string to be converted.
     * @return A list of strings obtained by splitting the input string.
     */
    @TypeConverter
    fun fromString(value: String): List<String> {
        if (value.isEmpty()) {
            return Collections.emptyList()
        }
        return value.split(",")
    }

    /**
     * Converts a list of strings to a single string.
     *
     * This method joins the elements of the input list into a single string,
     * using a delimiter to separate the elements.
     *
     * @param list The list of strings to be converted.
     * @return A single string obtained by joining the elements of the input list.
     */
    @TypeConverter
    fun listToString(list: List<String>): String {
        return list.joinToString(",")
    }
}
