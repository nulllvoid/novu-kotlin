package co.novu.api

import co.novu.dto.response.PaginatedResponseWrapper
import co.novu.dto.response.ResponseWrapper
import co.novu.dto.response.changes.ChangesResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query
import java.math.BigInteger

interface ChangesApi {

    @GET("changes")
    suspend fun getChanges(@Query("page") page: BigInteger, @Query("limit") limit: BigInteger, @Query("promoted") promoted: String): Response<PaginatedResponseWrapper<ChangesResponse>>

    @GET("changes/count")
    suspend fun getChangesCount(): Response<ResponseWrapper<BigInteger>>

    @POST("changes/bulk/apply")
    suspend fun applyChanges(): Response<ResponseWrapper<List<ChangesResponse>>>

    @POST("changes/{changeId}/apply")
    suspend fun applychange(@Path("changedId") changedId: String): Response<ResponseWrapper<ChangesResponse>>
}
