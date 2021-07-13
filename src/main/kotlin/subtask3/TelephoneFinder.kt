package subtask3

class TelephoneFinder {

    fun findAllNumbersFromGivenNumber(number: String): Array<String>? {

        // создаём результирующий массив
        var array = mutableListOf<String>()

        // перебираем посимвольно входящую строку
        number.forEach { char ->
            // получаем массив соседних бро-номеров
            val broNum = broNumber(char) ?: return null
            // пробегаем по бро-номерам и делаем замену с добавление в результирующий массив
            broNum.forEach {
                //println(it.toString())
                array.add(number.replace(char, it[0]))
            }

        }

        return array.toTypedArray()

    }

    // ищем соседние бро-номера
    private fun broNumber(num: Char): Array<String>? {
        return when(num) {
            '0' -> arrayOf("8")
            '1' -> arrayOf("2","4")
            '2' -> arrayOf("1","3","5")
            '3' -> arrayOf("2","6")
            '4' -> arrayOf("1","5","7")
            '5' -> arrayOf("2","4","6","8")
            '6' -> arrayOf("3","5","9")
            '7' -> arrayOf("4","8")
            '8' -> arrayOf("5","7","9","0")
            '9' -> arrayOf("6","8")

            else -> null

        }

    }
}
