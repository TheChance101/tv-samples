/*
 * Copyright 2023 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.jetstream.data.entities

import com.google.jetstream.data.models.MoviesResponseItem

data class Movie(
    val id: String,
    val posterUri: String,
    val name: String,
    val description: String
) {
    companion object {
        fun from(
            responseItem: MoviesResponseItem,
            thumbnailType: ThumbnailType = ThumbnailType.Standard
        ): Movie {
            val thumbnail = when (thumbnailType) {
                ThumbnailType.Standard -> responseItem.image_2_3
                ThumbnailType.Long -> responseItem.image_16_9
            }
            return Movie(
                responseItem.id,
                thumbnail,
                responseItem.title,
                responseItem.fullTitle
            )
        }

    }
}

enum class ThumbnailType {
    Standard,
    Long
}