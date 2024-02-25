class TestClass {
    fun initBookObjects()
    {
        var book=Book("TestBook1","TestAuthor1",4.0);
        var ebook=EBook("TestEBook2","TestAuthor2",4.0,"pdf");
        book.price=6.0;
        book.title="BestTestBook1";
        println(book.read())
        println(ebook.read())
    }
}
fun main(args:Array<String>)
{
    var testClass=TestClass();
    testClass.initBookObjects();
}