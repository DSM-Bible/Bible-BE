package org.example.biblebe.domain.user.entity

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface UserJpaRepository: CrudRepository<UserEntity, String>