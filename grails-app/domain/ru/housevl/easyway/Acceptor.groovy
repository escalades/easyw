package ru.housevl.easyway

class Acceptor {

    String name
    String annotation
    String content
    String notes
    String image
    String url

    String wherewithalText
    Integer wherewithal

    Date dateCreated
    Boolean isPublished = false

    Boolean isFinished = false
    Integer collectedFunds = 0
    Date transferDate
    String thanks

    static namedQueries = {
        available {
            eq 'isPublished', true
            eq 'isFinished', false
        }

        finished {
            eq 'isPublished', true
            eq 'isFinished', true
        }
    }

    static constraints = {
        name blank: false
        annotation blank: false
        content nullable: true, blank: true, maxSize: 5000
        notes nullable: true, blank: true, maxSize: 3000
        image blank: false
        url blank: false, unique: true, maxSize: 60, matches: /^[\w-]+$/
        wherewithalText blank: false
        transferDate nullable: true
        thanks nullable: true, blank: true, maxSize: 3000
    }
}
