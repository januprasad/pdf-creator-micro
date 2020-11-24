package com.jk.micro

import java.util.*

class User {
    var firstName: String? = null
    var lastName: String? = null
    var email: String? = null
    var dob: Date? = null

    constructor() {}
    constructor(firstName: String?, lastName: String?, email: String?, dob: Date?) {
        this.firstName = firstName
        this.lastName = lastName
        this.email = email
        this.dob = dob
    }
}