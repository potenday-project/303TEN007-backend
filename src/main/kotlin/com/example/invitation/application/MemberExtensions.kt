package com.example.invitation.application

import com.example.invitation.domain.member.Member
import com.example.invitation.ui.MemberResponse

fun Member.toDto(): MemberResponse {
    return MemberResponse(
        memberId = this.memberId,
    )
}