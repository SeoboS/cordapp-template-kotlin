package com.template.states

import net.corda.core.contracts.LinearState
import net.corda.core.contracts.UniqueIdentifier
import net.corda.core.identity.AbstractParty
import net.corda.core.identity.Party
import net.corda.core.serialization.ConstructorForDeserialization

class BasketOfApples @ConstructorForDeserialization constructor(
    private val description : String,
    private val farm : Party,
    private val owner: Party,
    private val weight: Int,
    override val linearId : UniqueIdentifier,
    override val participants : List<AbstractParty> = listOf(farm, owner)
    ) : LinearState {

    constructor(description : String, farm : Party, weight : Int, linearId : UniqueIdentifier, participants : List<AbstractParty>)
    : this(description, farm, farm, weight, linearId, listOf(farm)) {

    }
}