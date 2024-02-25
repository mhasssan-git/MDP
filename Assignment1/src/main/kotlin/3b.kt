fun main(args:Array<String>)
{
    val result=sumOfOddSqr(arrayOf(1,2,3,4,6,5));
    println(result);
}
fun sumOfOddSqr(arr:Array<Int>):Int
{
    var output=0;
    for(number in arr)
    {
        if(number%2!=0)
            output+=number*number;
    }
    return output;
}