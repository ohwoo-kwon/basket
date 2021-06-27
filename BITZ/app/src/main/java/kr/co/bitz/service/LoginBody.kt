package kr.co.bitz.service


data class LoginBody (
    var username: String = "", // string
    var password: String = "", // 0
    var last_name: String = "", // string
    var firts_name: String = "", // string
    var phone_number: String = "", // string
    var birth: String = "", // string
    var passwordConfirmation: String = "", // string
    var is_gym:Boolean = false
)