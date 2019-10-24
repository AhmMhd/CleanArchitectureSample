package com.data.network

import com.google.gson.JsonObject
import kotlinx.coroutines.Deferred
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.*
import javax.inject.Inject

/**
 * Created by Dell 5521 on 11/6/2017.
 */

public interface ApiInterface  {

    //Creating GET/POST request
    @GET
    operator fun get(@Url endpoint: String): Deferred<Response<ResponseBody>>

    @GET
    operator fun get(
        @Url endpoint: String,
        @HeaderMap headerMap: @JvmSuppressWildcards Map<String, String>
    ): Deferred<Response<ResponseBody>>

    @GET
    operator fun get(
        @Url endpoint: String,
        @HeaderMap headers: @JvmSuppressWildcards Map<String, String>,
        @QueryMap query: @JvmSuppressWildcards Map<String, String>
    ): Deferred<Response<ResponseBody>>

    @POST
    fun post(@Url endpoint: String): Deferred<Response<ResponseBody>>

    @POST
    fun post(
        @Url endpoint: String,
        @HeaderMap headerMap: @JvmSuppressWildcards Map<String, String>
    ): Deferred<Response<ResponseBody>>

    //multipart POST request for uploading files
    @Multipart
    @POST
    fun post(
        @Url endpoint: String,
        @HeaderMap headerMap: Map<String, String>,
        @PartMap bodyMap: Map<String, @JvmSuppressWildcards RequestBody>
    ): Deferred<Response<ResponseBody>>

    //multipart POST request for uploading files
    @POST
    fun post(
        @Url endpoint: String,
        @HeaderMap headerMap: Map<String, String>,
        @Body bodyMap: JsonObject
    ): Deferred<Response<ResponseBody>>

    //post with query map
    @POST
    fun post(
        @Url endpoint: String,
        @HeaderMap headerMap: Map<String, String>,
        @Body bodyMap: JsonObject,
        @QueryMap query: @JvmSuppressWildcards Map<String, String>
    ): Deferred<Response<ResponseBody>>


    //single File
    //multipart POST request for uploading files
    @Multipart
    @POST
    fun post(
        @Url endpoint: String,
        @HeaderMap headerMap: @JvmSuppressWildcards Map<String, String>,
        @PartMap bodyMap: @JvmSuppressWildcards Map<String, RequestBody>,
        @Part file: @JvmSuppressWildcards MultipartBody.Part
    ): Deferred<Response<ResponseBody>>

    //multiple Files -- Can be used for 1 file also
    //Recommended to use this as this one method can cover all scenario
    //multipart POST request for uploading files
    @Multipart
    @POST
    fun post(
        @Url endpoint: String,
        @HeaderMap headerMap: @JvmSuppressWildcards Map<String, String>,
        @PartMap bodyMap: @JvmSuppressWildcards Map<String, RequestBody>,
        @Part files: @JvmSuppressWildcards List<MultipartBody.Part>
    ): Deferred<Response<ResponseBody>>

    //delete request is not working with bodyMap.. retrofit is not accepting
    //only simple delete is working
    @DELETE
    fun delete(@Url endpoint: String): Deferred<Response<ResponseBody>>

    @DELETE
    fun delete(
        @Url endpoint: String,
        @HeaderMap headerMap: @JvmSuppressWildcards Map<String, String>
    ): Deferred<Response<ResponseBody>>

    @HTTP(method = "DELETE", hasBody = true)
    fun delete(
        @Url endpoint: String,
        @HeaderMap headerMap: Map<String, String>,
        @PartMap bodyMap: Map<String, RequestBody>
    ): Deferred<Response<ResponseBody>>

}
