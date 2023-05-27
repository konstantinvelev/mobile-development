package com.example.etherealartefacts

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mobile_development.api.API
import com.example.mobile_development.model.Login
import com.example.mobile_development.model.LoginSuccess
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val apiService: API) : ViewModel() {

    private val _response = MutableStateFlow<Result<LoginSuccess>?>(null)
    val response: StateFlow<Result<LoginSuccess>?> = _response

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    fun login(request: Login) {
        viewModelScope.launch {
            try {
                _isLoading.value = true
                val loginResponse = apiService.login(request)
                _response.value = Result.success(loginResponse)
            } catch (e: Exception) {
                _response.value = Result.failure(e)
            } finally {
                _isLoading.value = false
            }
        }
    }
}