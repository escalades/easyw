package ru.housevl.easyway

class Advertisement {

    String title
    String videoUrl
    Integer budget = 0
    Integer spentFunds = 0
    Integer rate = 0

    Date dateCreated
    Boolean isPublished = false

    static namedQueries = {
        available {
            eq 'isPublished', true
            gtProperty 'budget', 'spentFunds'
        }
    }

    static constraints = {
        title blank: false
        videoUrl blank: false
        spentFunds validator: { val, obj -> val < obj.budget }
    }
}