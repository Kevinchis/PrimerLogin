package com.example.loginbicho1

class User {
    var id : Int =0
    var login: String = ""
    var contraseña: String = ""

    constructor(login: String, contraseña: String){
        this.login =login
        this.contraseña = contraseña
    }
    constructor(){

    }
}