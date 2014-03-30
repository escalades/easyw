package ru.housevl.easyway

class Viewer {

    String network
    String uid

    static constraints = {
        uid blank: false, unique: 'network'
    }
}
