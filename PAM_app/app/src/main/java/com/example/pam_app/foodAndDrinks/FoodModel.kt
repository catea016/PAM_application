package com.example.pam_app.foodAndDrinks

class FoodModel(image: Int?, name: String?, price: String?) {

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
    var setGetPrice: String? = price
        get() = field.toString()
        set(value) {
            field = value.toString()
        }

}