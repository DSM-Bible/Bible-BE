package org.example.biblebe.global.thirdparty.s3

import com.amazonaws.auth.AWSStaticCredentialsProvider
import com.amazonaws.auth.BasicAWSCredentials
import com.amazonaws.services.s3.AmazonS3Client
import com.amazonaws.services.s3.AmazonS3ClientBuilder
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class S3Config {
    @Value("\${cloud.aws.credentials.access-key}")
    val accessKey: String? = null

    @Value("\${cloud.aws.credentials.secret-key}")
    val secretKey: String? = null

    @Bean
    fun amazonS3Client(): AmazonS3Client {
        val awsCredentials = BasicAWSCredentials(accessKey, secretKey)
        return AmazonS3ClientBuilder.standard()
                .withCredentials(AWSStaticCredentialsProvider(awsCredentials))
                .withRegion("ap-northeast-2")
                .build() as AmazonS3Client
    }
}