package ru.housevl.easyway

import grails.validation.Validateable
import org.grails.databinding.BindUsing
import org.grails.databinding.BindingFormat
import org.springframework.web.multipart.MultipartFile

@Validateable
class AcceptorSaveCommand {
    Long id

    String name
    String annotation
    String content
    String notes
    String thanks
    String url

    String wherewithalText
    Integer wherewithal

    String imageId
    MultipartFile imageFile

    @BindingFormat('dd.MM.yyyy')
    Date transferDate

    @BindUsing({ obj, source ->
        source['isPublished'] ? true : false
    })
    Boolean isPublished = false

    @BindUsing({ obj, source ->
        source['isFinished'] ? true : false
    })
    Boolean isFinished = false
}
