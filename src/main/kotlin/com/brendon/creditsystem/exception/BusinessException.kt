package com.brendon.creditsystem.exception

data class BusinessException(override val message: String?) : RuntimeException(message)