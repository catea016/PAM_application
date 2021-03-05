package com.example.pam_app.foodAndDrinks

class FoodModel(image: Int?, name: String?, price: String?) {
    private var image: Int?
    private var name: String
    private var price: String

    init {
        this.image = image
        this.name = name!!
        this.price = price!!
    }


    fun getImage(): Int? {
        return image
    }

    fun setImage(name: Int?) {
        image = name!!
    }

    fun getName(): String? {
        return name
    }

    fun setName(text: String?) {
        name = text!!
    }

    fun getPrice(): String? {
        return price
    }

    fun setPrice(nr: String?) {
        price = nr!!
    }

    /*
    TODO: replace self written setter and getters with kotlin properties access https://kotlinlang.org/docs/properties.html
    var setGetImage: Int? = image
        get() = field
        set(value) {
            field = value
        }
    var setGetName: String? = name
        get() = field.toString()
        set(value) {
            field = value.toString()
        }
*/

}