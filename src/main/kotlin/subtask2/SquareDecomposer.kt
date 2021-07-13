package subtask2

class SquareDecomposer {

    fun decomposeNumber(number: Int): Array<Int>? {

        val quadr = makeQuadr(number)
        // запускаем рекурсивную функцию расщепления квадрата числа
        return decomp(number, quadr)


    }

    private fun decomp(number: Int, quadr: Double): Array<Int>? {
        // приступаем к нарезке квадрата, отщипываем по единице
        for (i in number - 1 downTo 1) {
            //если отщиповаемое значение в квадрате не равно текущенму квадрату (оно не превышает), то
            if (makeQuadr(i) != quadr) {
                // запоминаем текущую разницу значений квадратов чисел для следующего расщепления.
                val saveOst = quadr - makeQuadr(i)
                // если эта разница положительная, то
                if (saveOst > 0) {
                    // запускаем рекурсивное отщипывание
                    val array = decomp(i, saveOst)
                    //если есть результат, то кидаем в накапливаемый массив
                    if (array != null)
                        return array.plus(i)
                }
            } else {
                // если отщипенец равен
                return arrayOf(i)
            }
        }
        // возврат по умолчанию, если значения минимальные
        return null
    }



    private fun makeQuadr(i:Int) : Double {
        return i.toDouble()*i.toDouble()
    }
 }
