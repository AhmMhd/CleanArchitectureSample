package com.data.network

import kotlinx.coroutines.Deferred

import okhttp3.ResponseBody
import retrofit2.Response
import java.lang.Exception
import com.domain.common.Result
import javax.inject.Inject

/**
 * Created by Dell 5521 on 9/28/2017.
 */

class NetworkCall @Inject constructor(
    protected var apiInterface: ApiInterface
) {
    //creating general methods for calling GET/POST request

    inline suspend fun generalRequest(request: () -> Deferred<Response<ResponseBody>>) =
        try {

            var response = request().await()

            if (response.isSuccessful) {
                var responseString = response.body()?.string()

//                handleMessage(responseString?:"")
                Result.Success(
                    responseString
                )

            } else {

//            to handle response codes other than 200
                var errorJson = response.errorBody()?.string()
                Result.Error(response .message())
            }

        } catch (exception: Exception) {
            Result.Exception(exception)
        }


    //simple POST with data map
    inline suspend fun get(
        endpoint: String
    ): Result<out Any> {


        return generalRequest { apiInterface.get(endpoint) }
    }


}
