open class `Book` {
    var title: String
        get() = field
        set(value) {
            field = value;
        }
    var author: String
        get() = field
        set(value) {
            field = value;
        }
    var price: Double
        get() = field
        set(value) {
            field = value;
        }

    constructor() {
        title = "";
        author = "";
        price = 0.0;
    }

    constructor(title: String, author: String, price: Double) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    open fun read() {
        println("Reading Paper book");
    }
}