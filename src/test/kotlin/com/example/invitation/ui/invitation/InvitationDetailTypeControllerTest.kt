package com.example.invitation.ui.invitation

import com.example.invitation.domain.invitation.InvitationType
import com.example.invitation.domain.invitation.detail.InvitationDetailType
import com.example.invitation.domain.invitation.detail.InvitationDetailTypeRepository
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.transaction.annotation.Transactional

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
class InvitationDetailTypeControllerTest {
    @Autowired
    lateinit var invitationDetailTypeRepository: InvitationDetailTypeRepository

    @Autowired
    lateinit var mockMvc: MockMvc

    @Test
    fun getInvitationDetailTypes() {
        invitationDetailTypeRepository.saveAll(
            listOf(
                InvitationDetailType(
                    invitationType = InvitationType.CASUAL,
                    name = "밥약속",
                    emoji = "🍚",
                    description = "",
                ),
                InvitationDetailType(
                    invitationType = InvitationType.CASUAL,
                    name = "술약속",
                    emoji = "🍺",
                    description = "",
                ),
                InvitationDetailType(
                    invitationType = InvitationType.CASUAL,
                    name = "소풍 & 여행",
                    emoji = "🎒",
                    description = "",
                ),
                InvitationDetailType(
                    invitationType = InvitationType.CASUAL,
                    name = "기타",
                    emoji = "🪄",
                    description = "",
                )
            )
        )
        mockMvc.perform(get("/api/v1/invitation-detail-types"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("\$.data[0].name").value("밥약속"))
            .andExpect(jsonPath("\$.data[1].name").value("술약속"))
            .andExpect(jsonPath("\$.data[2].name").value("소풍 & 여행"))
            .andExpect(jsonPath("\$.data[3].name").value("기타"))
    }
}