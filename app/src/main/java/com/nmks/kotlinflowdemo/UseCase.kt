package com.nmks.kotlinflowdemo

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.scan
import kotlinx.coroutines.flow.zip

class UseCase(val photoRepository: PhotoRepository,names : Flow<String>) {

    val userFlow  : Flow<List<User>> =
        names.zip(photoRepository.flowOfPhoto){
            name,photo ->
            User(name,photo)
        }.scan(emptyList()){
            acc,value -> acc +value
        }
}