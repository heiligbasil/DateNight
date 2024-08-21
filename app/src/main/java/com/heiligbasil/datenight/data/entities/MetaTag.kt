package com.heiligbasil.datenight.data.entities


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MetaTag(
    @SerialName("al:android:package")
    val alAndroidPackage: String?,
    @SerialName("al:android:url")
    val alAndroidUrl: String?,
    @SerialName("al:ios:app_name")
    val alIosAppName: String?,
    @SerialName("al:ios:app_store_id")
    val alIosAppStoreId: String?,
    @SerialName("al:ios:url")
    val alIosUrl: String?,
    @SerialName("apple-itunes-app")
    val appleItunesApp: String?,
    @SerialName("apple-mobile-web-app-capable")
    val appleMobileWebAppCapable: String?,
    @SerialName("apple-mobile-web-app-status-bar-style")
    val appleMobileWebAppStatusBarStyle: String?,
    @SerialName("application-name")
    val applicationName: String?,
    @SerialName("article:modified_time")
    val articleModifiedTime: String?,
    @SerialName("article:opinion")
    val articleOpinion: String?,
    @SerialName("article:published_time")
    val articlePublishedTime: String?,
    @SerialName("article:publisher")
    val articlePublisher: String?,
    @SerialName("article:section")
    val articleSection: String?,
    @SerialName("author")
    val author: String?,
    @SerialName("auto-publish")
    val autoPublish: String?,
    @SerialName("content_type")
    val contentType: String?,
    @SerialName("csrf-param")
    val csrfParam: String?,
    @SerialName("date")
    val date: String?,
    @SerialName("date_day")
    val dateDay: String?,
    @SerialName("date_month")
    val dateMonth: String?,
    @SerialName("date_year")
    val dateYear: String?,
    @SerialName("facebook-domain-verification")
    val facebookDomainVerification: String?,
    @SerialName("fb:app_id")
    val fbAppId: String?,
    @SerialName("fb:pages")
    val fbPages: String?,
    @SerialName("format-detection")
    val formatDetection: String?,
    @SerialName("google-play-app")
    val googlePlayApp: String?,
    @SerialName("handheldfriendly")
    val handheldFriendly: String?,
    @SerialName("m1")
    val m1: String?,
    @SerialName("m2")
    val m2: String?,
    @SerialName("mobileoptimized")
    val mobileOptimized: String?,
    @SerialName("msapplication-navbutton-color")
    val msApplicationNavButtonColor: String?,
    @SerialName("msapplication-tap-highlight")
    val msApplicationTapHighlight: String?,
    @SerialName("msapplication-tilecolor")
    val msApplicationTileColor: String?,
    @SerialName("msapplication-tileimage")
    val msapplicationTileimage: String?,
    @SerialName("msapplication-window")
    val msApplicationWindow: String?,
    @SerialName("msvalidate.01")
    val msValidate01: String?,
    @SerialName("news_keywords")
    val newsKeywords: String?,
    @SerialName("next-head-count")
    val nextHeadCount: String?,
    @SerialName("og:country-name")
    val ogCountryName: String?,
    @SerialName("og:description")
    val ogDescription: String?,
    @SerialName("og:image")
    val ogImage: String?,
    @SerialName("og:image:alt")
    val ogImageAlt: String?,
    @SerialName("og:image:height")
    val ogImageHeight: String?,
    @SerialName("og:image:type")
    val ogImageType: String?,
    @SerialName("og:image:width")
    val ogImageWidth: String?,
    @SerialName("og:latitude")
    val ogLatitude: String?,
    @SerialName("og:locale")
    val ogLocale: String?,
    @SerialName("og:locality")
    val ogLocality: String?,
    @SerialName("og:longitude")
    val ogLongitude: String?,
    @SerialName("og:love:apikey")
    val ogLoveApikey: String?,
    @SerialName("og:postal-code")
    val ogPostalCode: String?,
    @SerialName("og:region")
    val ogRegion: String?,
    @SerialName("og:site_name")
    val ogSiteName: String?,
    @SerialName("og:street-address")
    val ogStreetAddress: String?,
    @SerialName("og:title")
    val ogTitle: String?,
    @SerialName("og:ttl")
    val ogTtl: String?,
    @SerialName("og:type")
    val ogType: String?,
    @SerialName("og:url")
    val ogUrl: String?,
    @SerialName("p:domain_verify")
    val pDomainVerify: String?,
    @SerialName("parsely-author")
    val parselyAuthor: String?,
    @SerialName("parsely-image-url")
    val parselyImageUrl: String?,
    @SerialName("parsely-link")
    val parselyLink: String?,
    @SerialName("parsely-metadata")
    val parselyMetadata: String?,
    @SerialName("parsely-pub-date")
    val parselyPubDate: String?,
    @SerialName("parsely-section")
    val parselySection: String?,
    @SerialName("parsely-tags")
    val parselyTags: String?,
    @SerialName("parsely-title")
    val parselyTitle: String?,
    @SerialName("parsely-type")
    val parselyType: String?,
    @SerialName("pub_date")
    val pubDate: String?,
    @SerialName("referrer")
    val referrer: String?,
    @SerialName("sailthru.contenttype")
    val sailthruContentType: String?,
    @SerialName("sailthru.date")
    val sailthruDate: String?,
    @SerialName("sailthru.image.full")
    val sailthruImageFull: String?,
    @SerialName("sailthru.image.thumb")
    val sailthruImageThumb: String?,
    @SerialName("sailthru.socialtitle")
    val sailthruSocialTitle: String?,
    @SerialName("sailthru.tags")
    val sailthruTags: String?,
    @SerialName("search_rating")
    val searchRating: String?,
    @SerialName("section")
    val section: String?,
    @SerialName("slug")
    val slug: String?,
    @SerialName("static")
    val static: String?,
    @SerialName("subsection")
    val subsection: String?,
    @SerialName("sv-nav-properties")
    val svNavProperties: String?,
    @SerialName("theme-color")
    val themeColor: String?,
    @SerialName("thumbnail")
    val thumbnail: String?,
    @SerialName("thumbnail_webp")
    val thumbnailWebp: String?,
    @SerialName("title")
    val title: String?,
    @SerialName("topic-name")
    val topicName: String?,
    @SerialName("topics")
    val topics: String?,
    @SerialName("twitter:app:id:ipad")
    val twitterAppIdIpad: String?,
    @SerialName("twitter:app:url:ipad")
    val twitterAppUrlIpad: String?,
    @SerialName("twitter:app:id:iphone")
    val twitterAppIdIphone: String?,
    @SerialName("twitter:app:url:iphone")
    val twitterAppUrlIphone: String?,
    @SerialName("twitter:card")
    val twitterCard: String?,
    @SerialName("twitter:creator")
    val twitterCreator: String?,
    @SerialName("twitter:data1")
    val twitterData1: String?,
    @SerialName("twitter:data2")
    val twitterData2: String?,
    @SerialName("twitter:description")
    val twitterDescription: String?,
    @SerialName("twitter:domain")
    val twitterDomain: String?,
    @SerialName("twitter:image")
    val twitterImage: String?,
    @SerialName("twitter:label1")
    val twitterLabel1: String?,
    @SerialName("twitter:label2")
    val twitterLabel2: String?,
    @SerialName("twitter:site")
    val twitterSite: String?,
    @SerialName("twitter:text:title")
    val twitterTextTitle: String?,
    @SerialName("twitter:title")
    val twitterTitle: String?,
    @SerialName("twitter:url")
    val twitterUrl: String?,
    @SerialName("twitter:widgets:theme")
    val twitterWidgetsTheme: String?,
    @SerialName("viewport")
    val viewport: String?,
    @SerialName("x-ua-compatible")
    val xUaCompatible: String?
)
