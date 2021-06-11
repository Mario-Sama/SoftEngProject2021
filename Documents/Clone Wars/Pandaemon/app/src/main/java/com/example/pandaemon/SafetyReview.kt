package com.example.pandaemon

import java.time.LocalDateTime

class SafetyReview(
    var placeId: String,
    var username: String,
    var reviewText: String,
    var reviewTime: LocalDateTime,
    var staffGrade: Int,
    var overallGrade: Float,
    var upvoteCounter: Int,
    var equipmentGrade: Int,
    var distanceGrade: Int
) {
    fun getMostUpvoted(location: String): Int {
        return 0
    }

    fun getAllReviews(location: String): Int {
        return 0
    }

    fun upvote(): Int {
        upvoteCounter += upvoteCounter
        return upvoteCounter
    }

    fun downvote(): Int {
        upvoteCounter -= upvoteCounter
        return upvoteCounter
    }
}