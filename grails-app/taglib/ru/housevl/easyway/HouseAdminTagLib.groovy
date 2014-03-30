package ru.housevl.easyway

import org.codehaus.groovy.grails.web.util.StreamCharBuffer

import java.text.DateFormatSymbols
import java.text.SimpleDateFormat

class HouseAdminTagLib {
    static defaultEncodeAs = 'none'
    static namespace = "ha"

    def grailsApplication
    def imageService

    //static encodeAsForTags = [tagName: 'raw']

    /**
     * @attr name REQUIRED
     */
    def adminMenuLink = { attrs ->
        out << render(template: "/templates/admin/adminMenuItem", model: [
                name: attrs.get('name'),
                linkEdit: attrs.'link-edit',
                linkView: attrs.'link-view',
                linkAdd: attrs.'link-add'
        ])
    }

    /**
     * @attr date REQUIRED
     * @attr format
     */
    def formatDate = { attrs ->
        Date date = attrs.date
        String format = attrs.format ?: message([code: "default.date.format"])
        DateFormatSymbols russSymbol = new DateFormatSymbols(new Locale("ru"))
        russSymbol.setMonths([
                "января", "февраля", "марта",
                "апреля", "мая", "июня",
                "июля", "августа", "сентября",
                "октября", "ноября", "декабря"
            ].toArray() as String[])
        SimpleDateFormat sdf = new SimpleDateFormat(format, russSymbol)
        out << sdf.format(date)
    }

    /**
     * @attr p REQUIRED
     * @attr per REQUIRED
     * @attr total REQUIRED
     */
    def paginator = { attrs, body ->
        Integer total = attrs.remove('total')
        Integer per = attrs.remove('per')
        Integer p = attrs.remove('p')
        String cls = attrs.get('class') ? " " + attrs.remove('class') : ""
        def pageCount = (total / per) + (total % per ? 1 : 0) ?: 1
        if (pageCount > 1) {
        out << "<div class=\"pagination$cls\" ${paramsToHtmlAttr(attrs)}><ul>"

        out << "<li class=\"previous\">"
        if (p == 1)
            out << "<span class=\"fui-arrow-left\"></span>"
        else
            out << "<a href=\"${body(p-1).trim()}\" class=\"fui-arrow-left\"></a>"
        out << "</li>"

        (1..pageCount).each {
            if (it == 1 || it == pageCount || (it > p - 3 && it < p + 3))
                if (it == p)
                    out << "<li class=\"active\"><span>${it}</span></li>"
                else
                    out << "<li><a href=\"${body(it).trim()}\">${it}</a></li>"
            else if (it == p + 3 || it == p - 3)
                out << "<li><a href=\"${body(it).trim()}\">..</a></li>"
        }

        out << "<li class=\"next\">"
        if (p == pageCount)
            out << "<span class=\"fui-arrow-right\"></span>"
        else
            out << "<a href=\"${body(p+1).trim()}\" class=\"fui-arrow-right\"></a>"
        out << "</li>"

        out << "</ul></div>"
        }
    }

    /**
     * @attr imageId REQUIRED
     * @attr width
     * @attr height
     */
    def image = { attrs, body ->
        String imageId = attrs.remove('imageId')
        Integer height = attrs.height ? Integer.parseInt(attrs.height) : 0
        Integer width = attrs.width ? Integer.parseInt(attrs.width) : 0
        out << imageService.createImageTag(imageId, height, width)
    }

    /**
     * @attr label REQUIRED
     */
    def label = { attrs ->
        out << render(template: "/templates/admin/labelWithHint", model: [
                label: attrs.'label',
                hintTitle: attrs.'hint-title' ?: null,
                hintContent: attrs.'hint-content' ?: null
        ])
    }

    def serverUrl = { attrs ->
        out << grailsApplication.config.grails.serverURL
    }

    /**
     * @attr bean REQUIRED
     * @attr field REQUIRED
     * @attr placeholder
     * @attr prefix
     * @attr size
     */
    def textField = { attrs ->
        def content = new StreamCharBuffer()
        if (attrs.prefix) {
            content += "<div class=\"input-group\">"
            content += "<span class=\"input-group-addon\">$attrs.prefix</span>"
            content += g.textField([
                    name: attrs.field,
                    class: "form-control input-lg",
                    placeholder: attrs.placeholder ?: null,
                    value: attrs.bean."$attrs.field"
            ])
            content += "</div>"
        } else {
            content += g.textField([
                    name: attrs.field,
                    class: "form-control",
                    placeholder: attrs.placeholder ?: null,
                    value: attrs.bean."$attrs.field"
            ])
        }
        out << render(template: "/templates/admin/fieldWrapper", model: [
                bean: attrs.bean,
                field: attrs.field,
                fieldSize: attrs.size ?: '11',
                content: content
        ])
    }

    /**
     * @attr bean REQUIRED
     * @attr field REQUIRED
     * @attr rows
     * @attr size
     */
    def textArea = { attrs ->
        def content = g.textArea([
                name: attrs.field,
                class: "form-control",
                rows: attrs.rows ?: '3',
                value: attrs.bean."$attrs.field"
        ])
        out << render(template: "/templates/admin/fieldWrapper", model: [
                bean:attrs.bean,
                field: attrs.field,
                fieldSize: attrs.size ?: '11',
                content: content
        ])
    }

    /**
     * @attr bean REQUIRED
     * @attr field REQUIRED
     * @attr size
     */
    def ckeditor = { attrs ->
        def content = g.textArea([
                name: attrs.field,
                value: attrs.bean."$attrs.field"
        ])
        content += "<script>CKEDITOR.replace('$attrs.field', {language: 'ru'});</script>"
        out << render(template: "/templates/admin/fieldWrapper", model: [
                bean:attrs.bean,
                field: attrs.field,
                fieldSize: attrs.size ?: '11',
                content: content
        ])
    }

    /**
     * @attr bean REQUIRED
     * @attr field REQUIRED
     * @attr size
     */
    def imageUpload = { attrs ->
        def content = new StreamCharBuffer()
        def imageId = attrs.bean."$attrs.field"
        content += "<input type=\"file\" id=\"${attrs.field}File\" name=\"${attrs.field}File\">"
        if (imageId) {
            content += g.hiddenField(name: "${attrs.field}Id", value: imageId)
            content += "<div class=\"admin-input-images\">"
            content += ha.image(imageId: imageId)
            content += "</div>"
        }

        out << render(template: "/templates/admin/fieldWrapper", model: [
                bean:attrs.bean,
                field: attrs.field,
                fieldSize: attrs.size ?: '11',
                content: content
        ])
    }

    /**
     * @attr bean REQUIRED
     * @attr field REQUIRED
     * @attr label REQUIRED
     * @attr size
     */
    def checkbox = { attrs ->
        def content = new StreamCharBuffer()
        content += "<label class=\"checkbox\" for=\"$attrs.field\">"
        content += g.checkBox([
                name: attrs.field,
                value: attrs.bean."$attrs.field",
                'data-toggle': 'checkbox'
        ])
        content += attrs.label
        content += "</label>"

        out << render(template: "/templates/admin/fieldWrapper", model: [
                bean:attrs.bean,
                field: attrs.field,
                fieldSize: attrs.size ?: '11',
                content: content
        ])
    }

    /**
     * @attr bean REQUIRED
     * @attr field REQUIRED
     * @attr size
     */
    def tags = { attrs ->
        def content = new StreamCharBuffer()
        content += "<input name=\"$attrs.field\" class=\"tagsinput\" value=\"${attrs.bean."$attrs.field"}\" />"

        out << render(template: "/templates/admin/fieldWrapper", model: [
                bean:attrs.bean,
                field: attrs.field,
                fieldSize: attrs.size ?: '11',
                content: content
        ])
    }

    /**
     * @attr bean REQUIRED
     * @attr field REQUIRED
     * @attr prefix
     * @attr size
     */
    def datePicker = { attrs ->
        def content = new StreamCharBuffer()
        def date = attrs.bean."$attrs.field" as Date
        def dateStr = date ? date.format('dd.MM.yyyy') : ''
        def input = "<input name=\"$attrs.field\" class=\"datepicker form-control\" value=\"$dateStr\" />"

        if (attrs.prefix) {
            content += "<div class=\"col-md-2\">$attrs.prefix</div>"
            content += "<div class=\"col-md-10\">$input</div>"
        } else
            content += input

        out << render(template: "/templates/admin/fieldWrapper", model: [
                bean:attrs.bean,
                field: attrs.field,
                fieldSize: attrs.size ?: '11',
                content: content
        ])
    }

    private paramsToHtmlAttr(attrs) {
        attrs.collect { key, value -> "${key}=\"${value.toString().replace('\'', '\\\'')}\"" }?.join(" ")
    }
}