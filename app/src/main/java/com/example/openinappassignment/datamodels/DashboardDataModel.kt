import com.google.gson.annotations.SerializedName
data class ApiResponse(
    val status: Boolean,
    val statusCode: Int,
    val message: String,
    @SerializedName("support_whatsapp_number")
    val supportWhatsappNumber: String,
    @SerializedName("extra_income")
    val extraIncome: Double,
    @SerializedName("total_links")
    val totalLinks: Int,
    @SerializedName("total_clicks")
    val totalClicks: Int,
    @SerializedName("today_clicks")
    val todayClicks: Int,
    @SerializedName("top_source")
    val topSource: String,
    @SerializedName("top_location")
    val topLocation: String,
    val startTime: String,
    @SerializedName("links_created_today")
    val linksCreatedToday: Int,
    @SerializedName("applied_campaign")
    val appliedCampaign: Int,
    val data: DashboardDataModel
)

data class DashboardDataModel(
    @SerializedName("recent_links")
    val recentLinks: List<RecentLink>,
    @SerializedName("top_links")
    val topLinks: List<TopLink>,
    @SerializedName("favourite_links")
    val favouriteLinks: List<Any?>,
    @SerializedName("overall_url_chart")
    val overallUrlChart: OverallUrlChart,
)

data class RecentLink(
    @SerializedName("url_id")
    val urlId: Long,
    @SerializedName("web_link")
    val webLink: String,
    @SerializedName("smart_link")
    val smartLink: String,
    val title: String,
    @SerializedName("total_clicks")
    val totalClicks: Long,
    @SerializedName("original_image")
    val originalImage: String,
    val thumbnail: Any?,
    @SerializedName("times_ago")
    val timesAgo: String,
    @SerializedName("created_at")
    val createdAt: String,
    @SerializedName("domain_id")
    val domainId: String,
    @SerializedName("url_prefix")
    val urlPrefix: Any?,
    @SerializedName("url_suffix")
    val urlSuffix: String,
    val app: String,
    @SerializedName("is_favourite")
    val isFavourite: Boolean,
)

data class TopLink(
    @SerializedName("url_id")
    val urlId: Long,
    @SerializedName("web_link")
    val webLink: String,
    @SerializedName("smart_link")
    val smartLink: String,
    val title: String,
    @SerializedName("total_clicks")
    val totalClicks: Long,
    @SerializedName("original_image")
    val originalImage: String,
    val thumbnail: Any?,
    @SerializedName("times_ago")
    val timesAgo: String,
    @SerializedName("created_at")
    val createdAt: String,
    @SerializedName("domain_id")
    val domainId: String,
    @SerializedName("url_prefix")
    val urlPrefix: String?,
    @SerializedName("url_suffix")
    val urlSuffix: String,
    val app: String,
    @SerializedName("is_favourite")
    val isFavourite: Boolean,
)

data class OverallUrlChart(
    @SerializedName("00:00")
    val n0000: Long,
    @SerializedName("01:00")
    val n0100: Long,
    @SerializedName("02:00")
    val n0200: Long,
    @SerializedName("03:00")
    val n0300: Long,
    @SerializedName("04:00")
    val n0400: Long,
    @SerializedName("05:00")
    val n0500: Long,
    @SerializedName("06:00")
    val n0600: Long,
    @SerializedName("07:00")
    val n0700: Long,
    @SerializedName("08:00")
    val n0800: Long,
    @SerializedName("09:00")
    val n0900: Long,
    @SerializedName("10:00")
    val n1000: Long,
    @SerializedName("11:00")
    val n1100: Long,
    @SerializedName("12:00")
    val n1200: Long,
    @SerializedName("13:00")
    val n1300: Long,
    @SerializedName("14:00")
    val n1400: Long,
    @SerializedName("15:00")
    val n1500: Long,
    @SerializedName("16:00")
    val n1600: Long,
    @SerializedName("17:00")
    val n1700: Long,
    @SerializedName("18:00")
    val n1800: Long,
    @SerializedName("19:00")
    val n1900: Long,
    @SerializedName("20:00")
    val n2000: Long,
    @SerializedName("21:00")
    val n2100: Long,
    @SerializedName("22:00")
    val n2200: Long,
    @SerializedName("23:00")
    val n2300: Long,
)
