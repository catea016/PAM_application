package com.example.pam_app.foodAndDrinks

class FoodModel(image: Int?, name: String?, price: String?) {

    var image: Int? = image
        get() = field
        set(value) {
            field = value
        }
    var name: String? = name
        get() = field.toString()
        set(value) {
            field = value.toString()
        }
    var price: String? = price
        get() = field.toString()
        set(value) {
            field = value.toString()
        }
}