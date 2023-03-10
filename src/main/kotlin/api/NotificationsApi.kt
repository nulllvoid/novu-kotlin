package co.novu.api

import co.novu.dto.response.NotificationGraphStatsResponse
import co.novu.dto.response.NotificationStatsResponse
import co.novu.dto.response.PaginatedResponseWrapper
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface NotificationsApi {

    @GET("notifications")
    suspend fun getNotifications(
        @Query("channels") channels: List<String>,
        @Query("templates") templates: List<String>,
        @Query("emails") emails: List<String>,
        @Query("search") search: String,
        @Query("page") page: String,
        @Query("transactionId") transactionId: String,
    ): Response<PaginatedResponseWrapper<Any>>

    @GET("notification/stats")
    suspend fun getNotificationsStats(): Response<NotificationStatsResponse>

    @GET("notification/graph/stats")
    suspend fun getNotificationGraphStats(): Response<PaginatedResponseWrapper<NotificationGraphStatsResponse>>

    @GET("notification/{notificationId}")
    suspend fun getNotification(@Path("notificationId") path: String): Response<Any>
}
