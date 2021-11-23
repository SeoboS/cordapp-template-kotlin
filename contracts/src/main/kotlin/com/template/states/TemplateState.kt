package com.template.states

import com.template.contracts.AppleStampContract
import net.corda.core.contracts.BelongsToContract
import net.corda.core.contracts.ContractState
import net.corda.core.identity.AbstractParty
import net.corda.core.identity.Party

// *********
// * State *
// *********
@BelongsToContract(AppleStampContract::class)
data class TemplateState(val msg: String,
                         val sender: Party,
                         val receiver: Party,
                         override val participants: List<AbstractParty> = listOf(sender,receiver)
) : ContractState
