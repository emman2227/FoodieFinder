import com.example.fofitest.ApiResponse
import com.example.fofitest.LoginRequest
import com.example.fofitest.SignupRequest
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST("db-test/signup.php")
    fun registerUser(@Body request: SignupRequest): Call<ApiResponse>

    @POST("db-test/login.php")
    fun loginUser(@Body request: LoginRequest): Call<ApiResponse>
}