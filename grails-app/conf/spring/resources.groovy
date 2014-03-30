import com.cloudinary.Cloudinary

// Place your Spring DSL code here
beans = {
    cloudinary(Cloudinary, grailsApplication.config.app.cloudinaryUrl as String)
}
