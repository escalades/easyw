package ru.housevl.easyway

class View {

    Viewer viewer
    Advertisement advertisement
    Acceptor acceptor

    Integer rate = 0
    Date dateCreated

    static constraints = {
        viewer unique: 'advertisement'
    }
}
