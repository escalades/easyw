package ru.housevl.easyway

import com.cloudinary.Transformation
import grails.transaction.Transactional
import org.springframework.web.multipart.MultipartFile

@Transactional
class ImageService {
    def cloudinary

    String uploadImage(MultipartFile image) {
        def file = File.createTempFile(image.originalFilename, 'tmp')
        image.transferTo(file)
        def result = cloudinary.uploader().upload(file, [:])
        file.delete()
        return result.get('public_id')
    }

    String createImageTag(String imageId, Integer height, Integer width) {
        def transform = new Transformation().crop('fill')
        if (height) transform.height(height)
        if (width) transform.width(width)

        cloudinary.url().format('jpg')
                .transformation(transform)
                .source(imageId).imageTag()
    }
}
