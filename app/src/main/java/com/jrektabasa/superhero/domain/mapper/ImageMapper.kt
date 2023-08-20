package com.jrektabasa.superhero.domain.mapper

import com.jrektabasa.superhero.data.model.response.ImageResponse
import com.jrektabasa.superhero.domain.model.Image
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ImageMapper @Inject constructor() {

    fun mapToDomain(response: ImageResponse): Image {
        return Image(response.url)
    }
}