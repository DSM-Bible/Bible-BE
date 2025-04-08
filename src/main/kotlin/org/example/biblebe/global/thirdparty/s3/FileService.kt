package org.example.biblebe.global.thirdparty.s3

import com.amazonaws.services.s3.AmazonS3Client
import com.amazonaws.services.s3.model.ObjectMetadata
import org.example.biblebe.global.exception.InternalServerErrorException
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile
import java.util.UUID


@Service
class FileService(
    private val amazonS3Client: AmazonS3Client
) {
    @Value("\${cloud.aws.bucket-name}")
    val bucketName: String? = null

    fun uploadFile(file: MultipartFile): String {
        try {
            val fileName: String = UUID.randomUUID().toString() + file.originalFilename

            val objectMetadata = ObjectMetadata()
            objectMetadata.contentType = file.contentType
            objectMetadata.contentLength = file.size

            amazonS3Client.putObject(bucketName, fileName, file.inputStream, objectMetadata)

            return amazonS3Client.getResourceUrl(bucketName, fileName)
        } catch (e: Exception) {
            e.printStackTrace()
            throw InternalServerErrorException
        }
    }
}