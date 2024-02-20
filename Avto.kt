import java.io.File


class Avto(var NameOfBuyer:String)
{
    var Mark:String = "Undefined"
    var Model:String = "Undefined"
    var Power:Int = 0
    var Cost:Double = 0.0

    fun input(a: Avto)
    {
        try
        {
            println("Введите марку автомобиля")
            a.Mark = readLine().toString()
            println("Введите модель автомобиля")
            a.Model = readLine().toString()
            println("Введите мощность автомобиля")
            a.Power = readLine()!!.toInt()
            println("Введите стоимость автомобиля")
            a.Cost = readLine()!!.toDouble()


        }
        catch(e:Exception)
        {
            print("Неправильно введены данные")
        }
    }
    fun output (a:Avto)
    {
        println("Марка автомобиля:${a.Mark}")
        println("Модель автомобиля:${a.Model}")
        println("Мощность автомобиля:${a.Power}")
        println("Стоимость автомобиля:${a.Cost}")
        a.WanttoBuy(a)
    }
    fun WanttoBuy(a:Avto)
    {
        try
        {


            println("Хотите ли вы приобрести этот автомобиль")
            println("Нажмите 1, если да ")
            println("0, если нет")
            val c = readLine()!!.toInt()
            if(c == 1)
            {
                println("Мы добавили ваш выбор в корзину")
                println("Подтвердите ваш заказ, нажав кнопку 1")
                val d = readLine()!!.toInt()
                if(d == 1)
                {
                    println("Ваш заказ прибудет через 7 дней")
                    println("Хотите получить выписку по заказу?")
                    var h = readLine()!!.toInt()
                    if (h == 1)
                    {
                        a.WantToSave(a)
                    }
                    else
                    {
                        println("Хорошо, спасибо что пользуетесь нашими услугами. Всего доброго!")
                    }
                }
                else
                {
                    println("Некорректно")
                }

            }
            else
            {
                 a.Cost = a.LastChance(a)
                a.WantToSave(a)
            }
        }
        catch (e:Exception)
        {
            print("Неправильно введены данные")
        }
    }
    fun LastChance(a:Avto): Double
    {
        println("Специально для вас скидка 15% на данную модель")
        println("Новая стоимость автомобиля:${a.Cost - (a.Cost*0.15)}")
        println("Вы хотите приобрести этот автомобиль по новой цене?")
        var b = readLine()!!.toInt()
        if(b == 1)
        {
            a.Cost -= a.Cost * 0.15
        }
        return a.Cost
    }
    fun WantToSave(a:Avto)
    {
        println("Вы действительно хотите сохранить информацию об этом заказе?")
        println("Нажмите 1, если да ")
        println("0, если нет")
        val b = readLine()!!.toInt()
        when (b == 1)
        {
            true ->
            {
                val writer = File("${a.Model}.txt").bufferedWriter()
                writer.write("Покупатель: ${a.NameOfBuyer}")
                writer.newLine()
                writer.write("Марка автомобиля: ${a.Mark}")
                writer.newLine()
                writer.write("Модель автомобиля: ${a.Model}")
                writer.newLine()
                writer.write("Мощность автомобиля: ${a.Power}")
                writer.newLine()
                writer.write("Cтоимость автомобиля: ${a.Cost}")
                writer.newLine()
                writer.write("Дата оформления заказа: 20.02.2024")
                writer.newLine()
                writer.write("Дата выполнения заказа: 27.02.2024")
                writer.close()
                println("файл сохранился под именем ${a.Model}.txt, спасибо что пользуетесь нашими услугами. Всего доброго!")
            }
            false ->
            {
                println("Хорошо, спасибо что пользуетесь нашими услугами. Всего доброго!")
            }
        }
    }
}