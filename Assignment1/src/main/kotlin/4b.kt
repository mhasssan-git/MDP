class EBook : Book {
    private var fileTYpe: String
        get() = field
        set(value) {
            field = value;
        }

    constructor(title: String, author: String, price: Double, fileType: String) :
            super(title, author, price) {
        this.fileTYpe = fileType
    }

    override fun read() {
        println("Read from Electronic Device")
    }
}