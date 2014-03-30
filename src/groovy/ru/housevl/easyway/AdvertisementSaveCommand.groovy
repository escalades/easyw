package ru.housevl.easyway

import grails.validation.Validateable
import org.grails.databinding.BindUsing

@Validateable
class AdvertisementSaveCommand {
    Long id

    String title
    String videoUrl
    Integer budget
    Integer rate

    @BindUsing({ obj, source ->
        source['isPublished'] ? true : false
    })
    Boolean isPublished

}
