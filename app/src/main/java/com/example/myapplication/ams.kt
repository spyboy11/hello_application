package com.example.myapplication

import java.util.*


fun main(args: Array<String>) {
    println(whatshoulddotoday("Happy"))
    //feedthefish()
    //eagerexample()
    lamda()
}

fun lamda(){
    var rolldice = { Random().nextInt(12) + 1}
    val rollDice0 = { sides: Int ->
        if (sides == 0) 0
        else Random().nextInt(sides) + 1
    }

    val rollDice2: (Int) -> Int = { sides ->
        if (sides == 0) 0
        else Random().nextInt(sides) + 1
    }
    rolldice()
}


fun eagerexample(){
    val decorations=listOf("rook","pagoda","plastic Plant","alligator","flowerpot")

    var eager=decorations.filter { it[0]=='f' }
    println(eager)

    //apply filter lazily OR back filter in sequence
    val filtered=decorations.asSequence().filter{it[0]=='p'}
    println(filtered)
    println(filtered.toList())

    //apply map lazily OR map() use
    var lazymap=decorations.asSequence().map {
        println("map: $it")
    }

    println(lazymap)
    println("first: ${lazymap.first()}")
    println("all: ${lazymap.toList()}")

}

fun getdirtysensorreading()=20

fun shouldchangewater(
    day: String,
    temperature: Int=22,
    dirty: Int= getdirtysensorreading()): Boolean{

    val istoohot = temperature>30
    val isdirty = dirty>30
    val issunday = day=="sunday"

    return when{
        istoohot(temperature)-> true
        isdirty(dirty)->true
        issunday(day)->true
        else->false
    }
}

fun  istoohot(temperature: Int) = temperature>0
fun isdirty(dirty: Int) = dirty>30
fun issunday(day: String) = day=="sunday"


fun whatshoulddotoday(mood: String, weather: String="sunny", temperature: Int=35): String {

    return when {
        mood == "sad" && weather =="rainy" && temperature==0 -> "stay in bed"
        temperature>35->"go swimming"
        else->"Stay home and read"
    }
}

fun feedthefish(){
    val day= randomday()
    val food= fishfood(day)
    println("Today is $day and the fish eat $food")
    shouldchangewater(day, temperature = 0, dirty = 50)
    shouldchangewater(day)
    shouldchangewater(day, dirty = 50)

    if(shouldchangewater(day)){
        println("Change Water Today")
    }

    //calling dirty processor
    //dirtyprocessor()
}

fun randomday() :String{
    val week= listOf("monday","tuesday","thursday","friday","saturday","sunday")
    return week[Random().nextInt(7)]
}

fun fishfood(day: String) : String{
    var  food= "fasting"

    return when(day){
        "monday"->"flakes"
        "tuesday"->"pellets"
        "wednesday"->"redworms"
        "thursday"->"granules"
        "friday"->"mosuitoes"
        "saturday"->"lettuce"
        "sunday"->"plankton"
        else->"fasting"
    }
    //return food
}