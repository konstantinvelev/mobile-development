import com.example.etherealartefacts.networking.TokenProvider
import okhttp3.Interceptor
import okhttp3.Response

class JWTInterceptor(private val tokenProvider: TokenProvider) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()

        if (tokenProvider.isLoggedIn() && tokenProvider.getJwtToken() != null) {
            val requestWithToken = originalRequest.newBuilder()
                .header("Authorization", "Bearer ${tokenProvider.getJwtToken()}")
                .build()

            return chain.proceed(requestWithToken)
        }

        return chain.proceed(originalRequest)
    }
}