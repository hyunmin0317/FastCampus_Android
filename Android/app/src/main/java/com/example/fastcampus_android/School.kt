package com.example.fastcampus_android

import io.realm.RealmObject

open class School : RealmObject() {
    var name: String? = null
    var location: String? = null
}