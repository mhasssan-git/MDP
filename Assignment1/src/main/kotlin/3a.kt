fun main(args: Array<String>) {
   var result=firstAndLastDig(1245);
    println(result);
}

fun firstAndLastDig(input:Int): Int {
    var _input:Int=input;
    var output:Int=input%10;
    while(_input/10!=0)
    {
        _input /= 10;
    }
    output+= _input%10 *10
    return output;
}