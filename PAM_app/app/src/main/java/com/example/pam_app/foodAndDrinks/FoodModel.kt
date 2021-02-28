package com.example.pam_app.foodAndDrinks

class FoodModel(image: String?, name: String?, price: String?) {
    private var image: String
    private var name: String
    private var price: String
    init {
        this.image = image!!
        this.name = name!!
        this.price = price!!
    }
    fun getImage(): String?{
        return image
    }
    fun setImage(name: String?){
        image = name!!
    }

    fun getName(): String?{
        return name
    }
    fun setName(text: String?){
        name = text!!
    }

    fun getPrice(): String?{
        return price
    }
    fun setPrice(nr: String?){
        price = nr!!
    }
}