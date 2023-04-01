package com.example.invitation.application.card

import com.example.invitation.domain.card.CardService
import com.example.invitation.domain.card.template.CardTemplateService
import com.example.invitation.domain.card.template.item.CardTemplateItemService
import com.example.invitation.ui.card.CardResponse
import com.example.invitation.ui.card.CardTemplateItemResponse
import com.example.invitation.ui.card.CardTemplateResponse
import org.springframework.stereotype.Component

@Component
class CardApplicationService(
    private val cardTemplateService: CardTemplateService,
    private val cardTemplateItemService: CardTemplateItemService,
    private val cardService: CardService,
) {
    fun getCardTemplates(): List<CardTemplateResponse> {
        return cardTemplateService.getCardTemplates()
            .map { it.toDto() }
    }

    fun getCardTemplateItems(
        invitationDetailTypeId: Long?,
    ): List<CardTemplateItemResponse> {
        return cardTemplateItemService.getCardTemplateItems(
            invitationDetailTypeId = invitationDetailTypeId
        ).map { it.toDto() }
    }

    fun getCard(
        cardId: Long,
    ): CardResponse {
        return cardService.getCard(cardId).toDto()
    }
}
