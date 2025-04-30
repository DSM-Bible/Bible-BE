package org.example.biblebe.domain.user.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import org.hibernate.annotations.ColumnDefault
import org.hibernate.annotations.DynamicInsert
import org.hibernate.annotations.DynamicUpdate

@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "user")
class UserEntity(
        @Id
        @Column(nullable = false, columnDefinition = "VARCHAR(15)")
        var userId: String,

        @Column(nullable = false, columnDefinition = "VARCHAR(225)")
        var password: String,

        @Column(nullable = false, columnDefinition = "VARCHAR(8)")
        var nickname: String,

        @ColumnDefault("'BASE_PROFILE_URL'")
        @Column(nullable = false, columnDefinition = "VARCHAR(200)")
        var profile: String?
)