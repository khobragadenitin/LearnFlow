package com.nmks.kotlinflowdemo

import androidx.lifecycle.ViewModel

class FlowDemoViewModel(val useCase: UseCase) : ViewModel(){

    val userFlow = useCase.userFlow


}
