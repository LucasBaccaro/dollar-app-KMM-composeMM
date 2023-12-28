package ui

import domain.GetDollarsUseCase
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import moe.tlaster.precompose.viewmodel.ViewModel
import moe.tlaster.precompose.viewmodel.viewModelScope
import core.data.Result

class DollarViewModel(
    private val getDollarsUseCase: GetDollarsUseCase,
) : ViewModel() {

    private val _state = MutableStateFlow(DollarUiState(isLoading = true))
    val state = _state.asStateFlow()

    private val exceptionHandler = CoroutineExceptionHandler { _, _ ->
        _state.update { it.copy(isLoading = false, isFailure = true) }
    }

    init {
        fetch()
    }

    fun fetch() {
        viewModelScope.launch(exceptionHandler) {
            _state.update { it.copy(isLoading = true) }
            when (val result = getDollarsUseCase()) {

                is Result.Success -> {
                    _state.update { DollarUiState(isLoading = false, data = result.data) }
                }

                is Result.Error -> {
                    _state.update { DollarUiState(isLoading = false, isFailure = true) }
                }
            }
        }
    }
}
