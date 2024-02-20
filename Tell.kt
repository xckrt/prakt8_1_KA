import java.io.File

class tell(var operator:String)
{
    var number: Long = 0
    var date: String = "Undefined"
    var time: Int = 0
    var code: Int = 0
    var oldprice:Double = 1.5
    var price:Double = 0.0
    var discount:Double = 1.0

    fun input(a: tell)
    {
        try
        {
            println("Введите номер")
            a.number = readLine()!!.toLong()
            println("Введите дату")
            a.date = readLine().toString()
            println("Введите длительность")
            a.time = readLine()!!.toInt()
            if(a.time >= 600)
            {


                println("Введите код города")
                a.code = readLine()!!.toInt()
                disc(a)
            }
            else if(a.time >= 900)
            {
                println("Введите код города")
                a.code = readLine()!!.toInt()
                wanttoRemake(a)
            }
            else
            {
                println("Введите код города")
                a.code = readLine()!!.toInt()
                price = oldprice * (time / 60)
            }
        }
        catch (e: Exception)
        {
            print("Неправильно введены данные")
        }
    }

    fun output(a: tell)
    {
        println("Оператор:${a.operator}")
        println("Номер телефона: ${a.number}")
        println("Дата разговора: ${a.date}")
        println("Длительность разговора: ${a.time}")
        println("Код города: ${a.code}")
        println("Стоимость разговора: ${a.price}")
        println("Скидка: ${a.discount}")

    }
    fun wanttoSave(a:tell)
    {
        println("Вы действительно хотите сохранить информацию об этом звонке?")
        println("Нажмите 1, если да ")
        println("0, если нет")
        val b = readLine()!!.toInt()
        when (b == 1)
        {
            true ->
            {
                val writer = File("${a.number}.txt").bufferedWriter()
                writer.write("Оператор:${a.operator}")
                writer.newLine()
                writer.write("Номер телефона: ${a.number}")
                writer.newLine()
                writer.write("Дата разговора: ${a.date}")
                writer.newLine()
                writer.write("Длительность разговора: ${a.time}")
                writer.newLine()
                writer.write("Код города: ${a.code}")
                writer.newLine()
                writer.write("Стоимость разговора: ${a.price}")
                writer.newLine()
                writer.write("Скидка: ${a.discount}")
                writer.close()

                println("файл сохранился под именем ${a.number}.txt, спасибо что пользуетесь нашими услугами. Всего доброго!")
            }
            false ->
            {
             println("Хорошо, спасибо что пользуетесь нашими услугами. Всего доброго!")
            }
        }
    }
    fun disc(a: tell)
    {
        println("Вы общались больше 10 минут, поэтому для вас скидка на 1 минуту 25%")
        discount = 0.25
        price = (oldprice * (time/60)) - (oldprice*(time/60)*discount)
    }
    fun wanttoRemake(a: tell)
    {
        try {
            println("В связи с тем, что часто ваша продолжительность разговора занимает больше 15 минут, мы предлагаем вам перейти на другой тариф \"Продолжительность\"")
            println("Вы хотите узнать стоимость данного тарифа")
            val c = readLine()!!.toInt()
            if (c == 1)
            {
                println("Стоимость минуты = 0.75")
                println("Вы хотите перейти на данный тариф?")
                println("Нажмите 1, если да ")
                println("0, если нет")
                var e = readLine()!!.toInt()
                if (e == 1)
                {
                    oldprice = 0.75
                    println("Мы поменяли тариф, хорошего вам дня!")
                }
                else
                {
                    println("Хорошо, спасибо что вы с нами, хорошего дня!")
                }

            }
            else
            {
                println("Вы точно хотите отказаться от этого предложения?")
                println("Нажмите 1, если да ")
                val d = readLine()!!.toInt()
                if (d == 1)
                {
                    println("Хорошо, мы вас услышали, хорошего дня!")
                }
                else
                {
                    println("Стоимость минуты = 0.75")
                    println("Вы хотите перейти на данный тариф?")
                    println("Нажмите 1, если да ")
                    println("0, если нет")
                    var e = readLine()!!.toInt()
                    if (e == 1)
                    {
                        oldprice = 0.75
                        println("Мы поменяли тариф, хорошего вам дня!")
                    }
                    else
                    {
                        println("Хорошо, спасибо что вы с нами, хорошего дня!")
                    }
                }

            }
        }
        catch (e:Exception)
        {
            print("Неправильно введены данные")
        }

    }
}