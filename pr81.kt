fun main()
{
    val a: tell = tell("МТС")
    a.input(a)
    println("Вы хотите увидеть информацию о разговоре?")
    println("Нажмите 1, если да")
    println("0, если нет")
    val c = readLine()!!.toInt()
    if(c==1)
    {
        a.output(a)
    }
    a.wanttoSave(a)
    val b: Avto = Avto("Алексей")
    b.input(b)
    println("Вы хотите увидеть информацию об автомобиле, ${b.NameOfBuyer}?")
    println("Нажмите 1, если да")
    println("0, если нет")
    val d = readLine()!!.toInt()
    if(d==1)
    {
        b.output(b)
    }
}