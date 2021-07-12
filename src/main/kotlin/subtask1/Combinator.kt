package subtask1

class Combinator {

    /**
     * отсылка ведёт на биноминальный калькулятор
     * который помогает вычислить пример с картами
     * нужно написать эту формулу
     * https://www.ohrt.com/odds/binomial.php
     */
    fun checkChooseFromArray(array: Array<Int>): Int? {
        val posters = array[0]
        val colors = array[1]

        if (posters == colors) return 1

        // приступаем к подборке количеству красок и вариантов возможных производимых постеров.
        for (numColor in 1..colors) {
            // факториальный вариант количества красок по возрастанию
            val variants = factorial(numColor) * factorial( colors - numColor )
            // максимальный вариант цветов
            val factorialColors = factorial(colors)

            /*
            println("Current Color sets  ={$numColor}")
            println("variants = {$variants}")
            println("factorial colors = {$factorialColors}")
            println("number make posters = ${factorialColors/variants} ")
            */
            // если деление цветовых вариантов приближается к количеству плакатов, то
            // отдаём количество цветов, которые стоит выбрать как минимум, что бы
            // покрыть требуемое количество плакатов
            if ((factorialColors/variants) == posters.toLong()) return numColor

        }

        return null


    }


    private fun factorial(num: Int): Long {
        if (num == 1) return 1
        if (num == 0) return 1
        return factorial(num -1) * num
    }

    // пример биноминального калькулятора
    private fun binomi(n: Int, k: Int): Int {
        if ((n == k) || (k == 0))
            return 1
        else
            return binomi(n - 1, k) + binomi(n - 1, k - 1);
    }
}
