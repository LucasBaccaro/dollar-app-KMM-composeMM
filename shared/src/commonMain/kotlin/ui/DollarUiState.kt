package ui

import domain.DolarModel
data class DollarUiState(
    val isLoading: Boolean = false,
    val isFailure: Boolean = false,
    val data: List<DolarModel> = emptyList(),
)