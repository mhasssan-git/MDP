fun main(args: Array<String>) {

    var isContinue:String;
    do {
        print("Please enter your mass in pound ");
        val mass= readln()
        print("Please enter planet name from this list --> Venus, Mars, Jupiter, Saturn, Uranus, Neptune ");
        val planet= readln();
        val weight=weightInDifferentPlanet(mass.toDouble(),planet);
        println("Your Weight in $planet is : $weight");
        print("Do you want to continue??(Y/N) ");
        isContinue= readln();
    }while (isContinue.lowercase()=="y")


}

fun weightInDifferentPlanet(mass: Double, planet: String): Double {
    var weight: Double = when (planet.lowercase()) {
        "venus" -> mass * 0.78
        "mars" -> mass * 0.78
        "jupiter" -> mass * 0.78
        "saturn" -> mass * 0.78
        "uranus" -> mass * 0.78
        "neptune" -> mass * 0.78
        else -> 0.0
    }
    return weight;
}